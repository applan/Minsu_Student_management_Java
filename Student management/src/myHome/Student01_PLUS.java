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
                + "�л�  �̸�: " + this.name + "\r\n"
    			+ "�л� �޴��� ��ȣ : " + this.number+ "\r\n"
    			+ "�л�  ����  ����: " + this.kor+" ��\r\n"
    			+ "�л�  ����  ����: " + this.eng+" ��\r\n"
    			+ "�л�  ����  ����: " + this.mat+" ��\r\n"
    			+ "�л�  ����  ����: " + this.total+" ��\r\n"
    			+ "�л�  ���  ����: " + (int)(this.avg)+" ��\r\n";
    			
    }
}
