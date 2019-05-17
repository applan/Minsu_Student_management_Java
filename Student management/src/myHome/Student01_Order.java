package myHome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MyUtil;

public class Student01_Order {
String message5;
	public String OrderASC() {
		// 등수 기준값을 평균값으로 잡아서 나열.
		// 5. 등수 순 보기 ( 학번, 이름, 평균 출력)
String sql = "SELECT * FROM student ORDER BY avg ASC";
	
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    message5 = "------- 등수순 나열 ( 오름차순  ) -------\n\n";
	try {
		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		rs = ps.executeQuery();
		while(rs.next()) {
			message5 += "학번 : "+ rs.getInt("num")+"\n"+
					   "이름 : "+ rs.getString("name")+"\n"+
					   "평균점수 : "+ rs.getDouble("avg")+"\n";
		}
          return message5;
    }catch(Exception ex) {
			ex.printStackTrace();
			return message5;
		}finally {
		  MyUtil.close(conn, ps);
			
		}	
	}

	public String OrderDESC() {
		// 등수 기준값을 평균값으로 잡아서 나열.
		// 5. 등수 순 보기 ( 학번, 이름, 평균 출력)
String sql = "SELECT * FROM student ORDER BY avg DESC";
	

    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    message5 = "------- 등수순 나열 ( 내림차순  ) -------\n\n";
	try {
		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		rs = ps.executeQuery();
		while(rs.next()) {
			message5 +="학번 : "+ rs.getInt("num")+"\n"+
					   "이름 : "+ rs.getString("name")+"\n"+
					   "평균점수 : "+ rs.getDouble("avg")+"\n";
		}
          return message5;
    }catch(Exception ex) {
			ex.printStackTrace();
			return message5;
		}finally {
		  MyUtil.close(conn, ps);
			
		}	
	}
}
