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
        message2 = "-------- ��� �л��� ���� --------\n";
		try {

	    conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			message2 += "�й� : "+ rs.getInt("num")+"\n"+
					   "�̸� : "+ rs.getString("name")+"\n"+
					   "�������� : "+ rs.getInt("kor")+"\n"+
					   "�������� : "+ rs.getInt("eng")+"\n"+
					   "�������� : "+ rs.getInt("mat")+"\n"+
					   "������� : "+ rs.getDouble("avg")+"\n"+
					   "���� : "+ rs.getString("hakjum")+"\n"+
					   "����ð� : "+ rs.getString("regdate")+"\n"+"\n";
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

