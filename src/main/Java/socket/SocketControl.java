package socket;

import dao.*;
import org.apache.ibatis.session.SqlSession;
import po.Hum;
import po.Light;
import po.smoke;
import po.Temp;

import java.util.Date;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/24 23:33.
 * @Comment
 */
public class SocketControl {

   public static SqlSession sqlSession ;

    public  static  void insertHum(int id,int value){
       // sqlSession = MybatisUtil.getSqlSession();
       // HumMapper humdao = sqlSession.getMapper(HumMapper.class);
        Hum hum = new Hum();
        hum.setDate(new Date(System.currentTimeMillis()));
        hum.setNodeid(id);
        hum.setValue(value);
        SocketDao.insertHum(hum);
        /*try{
            humdao.insert(hum);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }*/

    }
    public static void insertTemp(int id,int value)
    {
       // sqlSession = MybatisUtil.getSqlSession();
        //TempMpper humdao = sqlSession.getMapper(TempMpper.class);
        Temp temp = new Temp();
        temp.setDate(new Date(System.currentTimeMillis()));
        temp.setNodeid(id);
        temp.setValue(value);
        SocketDao.insertTemp(temp);
        /*try{

            humdao.insert(temp);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }*/
    }
    public static void insertSmock(int id,int value)
    {
        //sqlSession = MybatisUtil.getSqlSession();
       // SmokeMapper smockdao = sqlSession.getMapper(SmokeMapper.class);
        smoke smoke = new smoke();
        smoke.setDate(new Date(System.currentTimeMillis()));
        smoke.setNodeid(id);
        smoke.setValue(value);
        SocketDao.insertSmock(smoke);
       /* try{
            smockdao.insert(smoke);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }*/
    }
    public static void insertLight(int id,int value)
    {
        //sqlSession = MybatisUtil.getSqlSession();
        //LightMapper smockdao = sqlSession.getMapper(LightMapper.class);
        Light light = new Light();
        light.setDate(new Date(System.currentTimeMillis()));
        light.setNodeid(id);
        light.setValue(value);
        SocketDao.insertLight(light);
       /* try{
            smockdao.insert(light);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }*/
    }

   /* public static void main(String[] args) {
        String str="H12H12";
        while(true) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
               continue;
            }
            System.out.println("LLLL");
        }
    }*/
}
