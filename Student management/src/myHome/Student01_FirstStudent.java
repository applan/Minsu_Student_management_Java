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
    message3 = "-------- 1등 학생의 정보 --------\n\n";
	try {
		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		rs = ps.executeQuery();
		rs.next();
		message3 += "학번 : "+ rs.getInt("num")+"\n"+
				   "이름 : "+ rs.getString("name")+"\n"+
				   "국어점수 : "+ rs.getInt("kor")+"\n"+
				   "영어점수 : "+ rs.getInt("eng")+"\n"+
				   "수학점수 : "+ rs.getInt("mat")+"\n"+
				   "평균점수 : "+ rs.getDouble("avg")+"\n"+
				   "학점 : "+ rs.getString("hakjum")+"\n"+
				   "저장시간 : "+ rs.getString("regdate")+"\n"+"\n";
          return message3;
    }catch(Exception ex) {
			ex.printStackTrace();
			return message3;
		}finally {
		  MyUtil.close(conn, ps);
			
		}}


}
