package myHome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.MyUtil;

public class Student01_CheckUpdate {
	public Student01_CheckUpdate(int num, boolean bol) {

	}
	public boolean Stu(int num, boolean bol){
		
	    Connection conn =null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE num = ?";
		JOptionPane.showMessageDialog(null, bol);
		try {
			conn = MyUtil.getConnection();
			ps = conn.prepareStatement(sql);
			// 학번 확인하기
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			// 결과 얻기
			int result = ps.executeUpdate();
			// 있는 학번이면
			if (result == 1) {
				bol = true; // 메소드 종료
			}else if(result != 1){
				bol = false;
			}
			ps.executeUpdate();
            return bol;
	    }catch(Exception ex) {
				ex.printStackTrace();
				return bol; // 메소드 종료
			}finally {
			  MyUtil.close(conn, ps);

		}
	}

}
