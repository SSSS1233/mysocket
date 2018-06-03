package dao;

import po.smoke;
import tools.DBTools;
import po.Hum;
import po.Light;
import po.Temp;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/29 10:05.
 * @Comment
 */
public class SocketDao {
    public static void insertTemp(Temp temp)
    {
        String sql="insert into temp value(?,?,?,?)";
        DBTools.excuteUpdate(sql,null,temp.getNodeid(),temp.getValue(),temp.getDate());

    }
    public static void insertHum(Hum hum)
    {
        String sql="insert into hum value(?,?,?,?)";
        DBTools.excuteUpdate(sql,null,hum.getNodeid(),hum.getValue(),hum.getDate());

    }
    public static void insertLight(Light light)
    {
        String sql="insert into light value(?,?,?,?)";
        DBTools.excuteUpdate(sql,null,light.getNodeid(),light.getValue(),light.getDate());

    }
    public static void insertSmock(smoke smoke)
    {
        String sql="insert into smoke value(?,?,?,?)";
        DBTools.excuteUpdate(sql,null, smoke.getNodeid(), smoke.getValue(), smoke.getDate());

    }
}
