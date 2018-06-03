package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Client implements Runnable{

    private String ip;
    private int port;
    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }



    public  void getClient() throws Exception {
        Socket s = new Socket(ip,port);
        PrintWriter w =new PrintWriter(s.getOutputStream());
        int count=0;
        do{
            count++;
            int temp = (int)(Math.random()*80);//产生一个-30℃-50℃的随机温度值
            int hum  = 20+(int)(Math.random()*60);//产生一个20%RH-80%RH的随机湿度值
            int light  = 150+(int)(Math.random()*4000);//产生随机光照度数
            int smock = 20+(int)(Math.random()*100);//产生随机酒精浓度
            String s1[]={"T"+temp,"H"+hum,"L"+light,"S"+smock};
            Random random=new Random();
            int num=random.nextInt(4);
            w.println(s1[num]);
            w.flush();
            Thread.sleep(500);
//            w.println("T"+temp);
//            w.flush();
//            Thread.sleep(300);
//            w.println("H"+hum);
//            w.flush();
//            Thread.sleep(300);
//            w.println("L"+light);
//            w.flush();
//            Thread.sleep(300);
//            w.println("S"+smock);
//            w.flush();
        }while(count<100000);
        try {
            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            getClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

