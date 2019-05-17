package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyUtil {

	 // getConnection() : DB�� ����� Connection�� return
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(
				        "jdbc:oracle:thin:@localhost:1521:xe",
				        "jsp121800",
				        "jsppassword"
				);
	}
	
	
	
	// close() : rs, ps, conn�� �Ѳ����� �ݾ��ִ� �޼ҵ�
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
		 		 conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
	public static void close(Connection conn, PreparedStatement ps) {
	close(conn, ps, null);
		
	
	}
}
