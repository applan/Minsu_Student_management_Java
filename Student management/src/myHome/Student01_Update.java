package myHome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import util.MyUtil;

public class Student01_Update {
	String message3;

	public Student01_Update(int num, int k, int e, int m) { 
		
		

		float avg =  Student01_Avg.getAvg(k, e, m);
	    
		String hakjum =Student01_Hakjum.getHakjum(avg);

	    String sql = "UPDATE student SET kor = ?, eng = ?, mat = ?, avg = ?,hakjum = ? WHERE num = ?";
		

	    Connection conn =null;
	    PreparedStatement ps = null;
	    


		try {
			conn = MyUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
            ps.setInt(1, k);
            ps.setInt(2, e);
            ps.setInt(3, m);
			ps.setDouble(4, avg);
			ps.setString(5, hakjum);
			ps.setInt(6, num);

			ps.executeUpdate();

	    }catch(Exception ex) {
				ex.printStackTrace();
				
			}finally {
			  MyUtil.close(conn, ps);
				
			}
	}
}
