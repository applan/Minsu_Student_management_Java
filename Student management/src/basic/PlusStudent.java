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
            + "�л�  �̸�: " + this.name + "\r\n"
			+ "�л� �޴��� ��ȣ : " + this.number+ "\r\n"
			+ "�л�  ��     �ּ�: " + this.address+ "\r\n"
			+ "�л�  ����  ����: " + this.kor+" ��\r\n"
			+ "�л�  ����  ����: " + this.eng+" ��\r\n"
			+ "�л�  ����  ����: " + this.mat+" ��\r\n"
			+ "�л�  ����  ����: " + this.age+" ��\r\n"
			+ "�л�  ���  ����: " + (int)(this.ag)+" ��\r\n";
			
}
 

}
