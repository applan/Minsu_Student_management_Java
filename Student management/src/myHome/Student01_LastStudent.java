package myHome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MyUtil;

public class Student01_LastStudent {

	String message4;
	public String Student01_LastStudent2() {
		
String sql = "SELECT * FROM student WHERE avg = (SELECT MIN(avg) FROM student)";
	

    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    message4 = "-------- �õ� �л��� ���� --------\n\n";
	try {
		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		rs = ps.executeQuery();
		rs.next();
		message4 += "�й� : "+ rs.getInt("num")+"\n"+
				   "�̸� : "+ rs.getString("name")+"\n"+
				   "�������� : "+ rs.getInt("kor")+"\n"+
				   "�������� : "+ rs.getInt("eng")+"\n"+
				   "�������� : "+ rs.getInt("mat")+"\n"+
				   "������� : "+ rs.getDouble("avg")+"\n"+
				   "���� : "+ rs.getString("hakjum")+"\n"+
				   "����ð� : "+ rs.getString("regdate")+"\n"+"\n";
          return message4;
    }catch(Exception ex) {
			ex.printStackTrace();
			return message4;
		}finally {
		  MyUtil.close(conn, ps);
			
		}


	}
}
