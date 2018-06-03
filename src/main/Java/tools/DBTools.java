package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTools {
	/*Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "root");*/
	private static final String DRIVERPATH = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/socket?characterEncoding=utf8&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static Connection conn = null;
	static{
		try {
			Class.forName(DRIVERPATH);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static int excuteUpdate(String sql,Object...objs){
		Connection conn = getConn();
		int a=0;
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(sql);
			if (objs!=null&&objs.length!=0) {
				for(int i=0;i<objs.length;i++){
					pstat.setObject(i+1, objs[i]);
				}
			}
			a=pstat.executeUpdate();

			pstat.close();
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			close(conn);
		}
		return a;

	}
	public static List<Object[]> excuteQuery(String sql,Object...objs){
		Connection conn = getConn();
		List<Object[]> list = new ArrayList<Object[]>();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(sql);
			if (objs!=null&&objs.length!=0) {
				for(int i=0;i<objs.length;i++){
					pstat.setObject(i+1, objs[i]);

				}
			}
			rs = pstat.executeQuery();
			while(rs.next()){
				Object[] obj = new Object[rs.getMetaData().getColumnCount()];
				for(int i=0;i<obj.length;i++){
					obj[i] = rs.getObject(i+1);
				}
				list.add(obj);
			}
			rs.close();
			pstat.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			close(conn);
		}


		return list;


	}
	public static void close(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		DBTools.getConn();
	}
}
