package myHome;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.MyUtil;

public class Student01_CheckSystem {
	String message2;
	public String Student01_CheckSystem2() {
		
	    Connection conn =null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM student ORDER BY num";
        message2 = "-------- 모든 학생의 정보 --------\n";
		try {

	    conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			message2 += "학번 : "+ rs.getInt("num")+"\n"+
					   "이름 : "+ rs.getString("name")+"\n"+
					   "국어점수 : "+ rs.getInt("kor")+"\n"+
					   "영어점수 : "+ rs.getInt("eng")+"\n"+
					   "수학점수 : "+ rs.getInt("mat")+"\n"+
					   "평균점수 : "+ rs.getDouble("avg")+"\n"+
					   "학점 : "+ rs.getString("hakjum")+"\n"+
					   "저장시간 : "+ rs.getString("regdate")+"\n"+"\n";
		}
		return message2;
	    }catch(Exception e) {
				e.printStackTrace();
				return message2;
			}finally {
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


	}

}

