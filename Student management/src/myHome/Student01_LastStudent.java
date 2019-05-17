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
    message4 = "-------- 꼴등 학생의 정보 --------\n\n";
	try {
		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		rs = ps.executeQuery();
		rs.next();
		message4 += "학번 : "+ rs.getInt("num")+"\n"+
				   "이름 : "+ rs.getString("name")+"\n"+
				   "국어점수 : "+ rs.getInt("kor")+"\n"+
				   "영어점수 : "+ rs.getInt("eng")+"\n"+
				   "수학점수 : "+ rs.getInt("mat")+"\n"+
				   "평균점수 : "+ rs.getDouble("avg")+"\n"+
				   "학점 : "+ rs.getString("hakjum")+"\n"+
				   "저장시간 : "+ rs.getString("regdate")+"\n"+"\n";
          return message4;
    }catch(Exception ex) {
			ex.printStackTrace();
			return message4;
		}finally {
		  MyUtil.close(conn, ps);
			
		}


	}
}
