package basic;


import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Strudent01 {
	
 public static void main(String[] args) {
	JFrame jf = new JFrame("�л� ���� ���α׷�");
	jf.setSize(500, 700);   // (�ʺ� 500, ���� 700)
	jf.setLocationRelativeTo(null);  // ȭ�� �߾ӿ� ��ġ
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	// ���̾ƿ� �غ�
	// ���� ) FlowLayout, GridLayout, BorderLayout
	//FlowLayout layout = new FlowLayout();  // �ڿ������� ���������� ��ġ
		 GridLayout layout = new GridLayout(6, 1); // �� , �� ������ ���� . 2�� 3��
		 //BorderLayout layout = new BorderLayout(); // ��,��,��,��,�߾� ���� ( add �Ҷ� �߰� �ɼ� ��� ��)
	jf.setLayout(layout);
	JButton jb1 = new JButton("-- �л� ���� �߰� --");
	JButton jb2 = new JButton("-- �л� ���� ���� --");
	JButton jb3 = new JButton("-- �л� ���� ���� --");
	JButton jb4 = new JButton("- �л� ���� ��ȸ/���� -");
	  //                      �л� ��ȸ�� 1. ��� ��ȸ , �˻� ��ȸ�� ��������.
	JButton jb5 = new JButton("-- ���α׷� ���� --");
	jf.add(jb1);
	jf.add(jb2);
	jf.add(jb3);
	jf.add(jb4);
	jf.add(jb5);
	jf.add(new JLabel("������ : siepe \n"));

	 jf.setVisible(true); // â ���̰� �ϱ�
	 // �̺�Ʈ ������ : ������� ���� , �Է� ���� ��ȣ�ۿ��� �ν��ϴ� ��ü
    FirstButton fi = new FirstButton();
    

    
   jb1.addActionListener(fi.al);
   jb2.addActionListener(fi.al2);
   jb3.addActionListener(fi.al3);
   jb4.addActionListener(fi.al4);
   jb5.addActionListener(fi.al5);
   
   

	}
	
	
	
	

	
	
	
}

