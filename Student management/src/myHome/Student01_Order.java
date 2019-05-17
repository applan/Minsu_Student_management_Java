package myHome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MyUtil;

public class Student01_Order {
String message5;
	public String OrderASC() {
		// ��� ���ذ��� ��հ����� ��Ƽ� ����.
		// 5. ��� �� ���� ( �й�, �̸�, ��� ���)
String sql = "SELECT * FROM student ORDER BY avg ASC";
	
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    message5 = "------- ����� ���� ( ��������  ) -------\n\n";
	try {
		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		rs = ps.executeQuery();
		while(rs.next()) {
			message5 += "�й� : "+ rs.getInt("num")+"\n"+
					   "�̸� : "+ rs.getString("name")+"\n"+
					   "������� : "+ rs.getDouble("avg")+"\n";
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
		// ��� ���ذ��� ��հ����� ��Ƽ� ����.
		// 5. ��� �� ���� ( �й�, �̸�, ��� ���)
String sql = "SELECT * FROM student ORDER BY avg DESC";
	

    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    message5 = "------- ����� ���� ( ��������  ) -------\n\n";
	try {
		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		rs = ps.executeQuery();
		while(rs.next()) {
			message5 +="�й� : "+ rs.getInt("num")+"\n"+
					   "�̸� : "+ rs.getString("name")+"\n"+
					   "������� : "+ rs.getDouble("avg")+"\n";
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
