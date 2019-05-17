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
			// �й� Ȯ���ϱ�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			// ��� ���
			int result = ps.executeUpdate();
			// �ִ� �й��̸�
			if (result == 1) {
				bol = true; // �޼ҵ� ����
			}else if(result != 1){
				bol = false;
			}
			ps.executeUpdate();
            return bol;
	    }catch(Exception ex) {
				ex.printStackTrace();
				return bol; // �޼ҵ� ����
			}finally {
			  MyUtil.close(conn, ps);

		}
	}

}
