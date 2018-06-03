package socket;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/24 23:53.
 * @Comment
 */
public class Server implements Runnable{
    private int port = 6800;
    private ServerSocket serverSocket;

    public Server() throws Exception{
        serverSocket = new ServerSocket(port,3);
        System.out.println("服务器启动!");
    }
    public  void run(){
        InputStream stream=null;

            Socket socket = null;

            try {
                socket = serverSocket.accept();
                stream=socket.getInputStream();
                byte buf[]=new byte[1024];
                int len=0;
                int  i=0;
                while(len!=-1) {
                    len=stream.read(buf);

                    String str=new String(buf,0,len);
                    if(str.substring(0,1).equals("H"))
                    {
                        String str1=str.substring(0,3);
                        try {
                            System.out.println("H:"+Integer.parseInt(str1.substring(1).replaceAll("\\s*","")));

                        }catch (NumberFormatException e)
                        {
                          continue;
                        }
                        SocketControl.insertHum(2,Integer.parseInt(str1.substring(1).replaceAll("\\s*","")));


                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }else
                    if(str.substring(0,1).equals("T"))
                    {
                        String str1=str.substring(0,3);

                        try {
                            System.out.println("T:"+Integer.parseInt(str1.substring(1).replaceAll("\\s*","")));

                        }catch (NumberFormatException e)
                        {
                            continue;
                        }
                        SocketControl.insertTemp(1,Integer.parseInt(str1.substring(1).replaceAll("\\s*","")));

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }else
                    if(str.substring(0,1).equals("S"))
                    {
                        String str1=str.substring(0,5);
                        try {
                            System.out.println("S:"+Integer.parseInt(str1.substring(1).replaceAll("\\s*","")));

                        }catch (NumberFormatException e)
                        {
                            continue;
                        }
                        SocketControl.insertSmock(3,Integer.parseInt(str1.substring(1).replaceAll("\\s*","")));

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }else
                    if(str.substring(0,1).equals("L"))
                    {
                        String str1=str.substring(0,5);

                        try {
                            System.out.println("L:"+Integer.parseInt(str1.substring(1).replaceAll("\\s*","")));

                        }catch (NumberFormatException e)
                        {
                            continue;
                        }
                        SocketControl.insertLight(4,Integer.parseInt(str1.substring(1).replaceAll("\\s*","")));

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }else {
                        System.out.println(str);
                    }
                    /*try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    //i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

    }

    public static void main(String[] args) throws Exception{
        Server server = new Server();
        Thread thread=new Thread(server);
        thread.start();
    }
}