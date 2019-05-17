package myHome;

import java.sql.Connection;

import java.sql.PreparedStatement;

import util.MyUtil;
// student_seq.NEXTVAL, '김인자', 90, 50, 60, (90+50+60)/3 ,'C학점', SYSDATE  
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

		ps.setString(1, n); // 1번 물음표에 String형태로 name 값을 대입한다.
		ps.setInt(2, k);     // 2번 물음표에 int형태로 kor 값을 대입한다.
		ps.setInt(3, e);     // 3번 물음표에 int형태로 eng 값을 대입한다.
 		ps.setInt(4, m);     // 4번 물음표에 int형태로 mat 값을 대입한다.
		ps.setDouble(5, avg);    // 5번 물음표에 double형태로 avg 값을 대입한다.
		ps.setString(6, hakjum);   // 6번 물음표에 String형태로 prHakjum 값을 대입한다.
		ps.executeUpdate();

    }catch(Exception ex) {
			ex.printStackTrace();
		}finally {
		  MyUtil.close(conn, ps);
			
		}
}
}

