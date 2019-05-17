package basic;

public class PlusStudent {
	String name,number,address;
	int kor,eng,mat,age;
	int i=0;
	float ag;

public PlusStudent() {}
public PlusStudent(String name,String number,String address,int kor,int eng,int mat) {
	this.name = name;
	this.number = number;
	this.address = address;
	this.kor = kor;
	this.eng = eng;
	this.mat = mat;
	this.age = (kor+eng+mat);
	this.ag = this.age/3.0f;
}
@Override
public String toString() {
	return  "\n"
            + "학생  이름: " + this.name + "\r\n"
			+ "학생 휴대폰 번호 : " + this.number+ "\r\n"
			+ "학생  집     주소: " + this.address+ "\r\n"
			+ "학생  국어  점수: " + this.kor+" 점\r\n"
			+ "학생  영어  점수: " + this.eng+" 점\r\n"
			+ "학생  수학  점수: " + this.mat+" 점\r\n"
			+ "학생  과목  총점: " + this.age+" 점\r\n"
			+ "학생  평균  점수: " + (int)(this.ag)+" 점\r\n";
			
}
 

}
