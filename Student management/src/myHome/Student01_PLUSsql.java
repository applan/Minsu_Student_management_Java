package myHome;

import java.sql.Connection;

import java.sql.PreparedStatement;

import util.MyUtil;
// student_seq.NEXTVAL, '������', 90, 50, 60, (90+50+60)/3 ,'C����', SYSDATE  
public class Student01_PLUSsql {
	public Student01_PLUSsql() { }
public Student01_PLUSsql(String n,int k, int e,int m) {
	
    float avg =  Student01_Avg.getAvg(k, e, m);
    
	String hakjum =Student01_Hakjum.getHakjum(avg);

    String sql = "INSERT INTO student VALUES(student_seq.NEXTVAL, ?, ?, ?, ?,?,?, SYSDATE)";
	

    Connection conn =null;
    PreparedStatement ps = null;
    
	try {

		conn = MyUtil.getConnection();
		ps = conn.prepareStatement(sql);

		ps.setString(1, n); // 1�� ����ǥ�� String���·� name ���� �����Ѵ�.
		ps.setInt(2, k);     // 2�� ����ǥ�� int���·� kor ���� �����Ѵ�.
		ps.setInt(3, e);     // 3�� ����ǥ�� int���·� eng ���� �����Ѵ�.
 		ps.setInt(4, m);     // 4�� ����ǥ�� int���·� mat ���� �����Ѵ�.
		ps.setDouble(5, avg);    // 5�� ����ǥ�� double���·� avg ���� �����Ѵ�.
		ps.setString(6, hakjum);   // 6�� ����ǥ�� String���·� prHakjum ���� �����Ѵ�.
		ps.executeUpdate();

    }catch(Exception ex) {
			ex.printStackTrace();
		}finally {
		  MyUtil.close(conn, ps);
			
		}
}
}

