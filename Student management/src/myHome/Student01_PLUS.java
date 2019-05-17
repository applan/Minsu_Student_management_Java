package myHome;
public class Student01_PLUS {
       String name, number;
       int kor,eng,mat,total;
       float avg;
       
       public Student01_PLUS() {}
       public Student01_PLUS(String n,String nu,int k,int e,int m) {
    	   name = n;
    	   number = nu;
    	   kor = k;
    	   eng = e;
    	   mat = m;
    	   total = (k+e+m);
    	   avg = total/3.0f;
       }
       
       @Override
    public String toString() {
    	return "\n"
                + "학생  이름: " + this.name + "\r\n"
    			+ "학생 휴대폰 번호 : " + this.number+ "\r\n"
    			+ "학생  국어  점수: " + this.kor+" 점\r\n"
    			+ "학생  영어  점수: " + this.eng+" 점\r\n"
    			+ "학생  수학  점수: " + this.mat+" 점\r\n"
    			+ "학생  과목  총점: " + this.total+" 점\r\n"
    			+ "학생  평균  점수: " + (int)(this.avg)+" 점\r\n";
    			
    }
}
