package myHome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MyUtil;

public class Student01_FirstStudent {
	String message3;
	public String Student01_FirstStudent2() { 
		
String sql = "SELECT * FROM student WHERE avg = (SELECT MAX(avg) FROM student)";
	

    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    message3 = "-------- 1�� �л��� ���� --------\n\n";
	try {
		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		rs = ps.executeQuery();
		rs.next();
		message3 += "�й� : "+ rs.getInt("num")+"\n"+
				   "�̸� : "+ rs.getString("name")+"\n"+
				   "�������� : "+ rs.getInt("kor")+"\n"+
				   "�������� : "+ rs.getInt("eng")+"\n"+
				   "�������� : "+ rs.getInt("mat")+"\n"+
				   "������� : "+ rs.getDouble("avg")+"\n"+
				   "���� : "+ rs.getString("hakjum")+"\n"+
				   "����ð� : "+ rs.getString("regdate")+"\n"+"\n";
          return message3;
    }catch(Exception ex) {
			ex.printStackTrace();
			return message3;
		}finally {
		  MyUtil.close(conn, ps);
			
		}}


}
