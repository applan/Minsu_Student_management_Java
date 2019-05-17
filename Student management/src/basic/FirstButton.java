package basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;



public class FirstButton extends PlusStudent{
	Scanner sc = new Scanner(System.in);
	ArrayList<PlusStudent> pl = new ArrayList<>();
	String txt = "";
	
	
///// 1�� ���� = �л� ���� �߰�
	ActionListener al = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			String message =btn.getText()+"�� �����ϼ̽��ϴ�.";
			JOptionPane.showMessageDialog(null, message);
			JOptionPane.showMessageDialog(null, "�߰��Ϸ��� �л��� �����Է¸� �Է��ϼ��� ");
			try {   // Exception�� �߻��� ���ɼ��� �ִ� �ڵ�
				
				pl.add(new PlusStudent(
						JOptionPane.showInputDialog("�л��� �̸� �Է�"),
						JOptionPane.showInputDialog("�л��� ��ȭ��ȣ �Է�"),
						JOptionPane.showInputDialog("�л��� �ּ� �Է�"),
						Integer.parseInt(JOptionPane.showInputDialog("�л��� ���� ���� �Է�")), 
						Integer.parseInt(JOptionPane.showInputDialog("�л��� ���� ���� �Է�")),
						Integer.parseInt(JOptionPane.showInputDialog("�л��� ���� ���� �Է�"))));
				
				} catch(Exception k) { // try �ȿ��� �߻��ϴ� ��� ���ܻ�Ȳ�� �̰����� ó��
					JOptionPane.showMessageDialog(null, "������ �߸� �Է��ϼ˽��ϴ�.");
					System.out.println("e.getMessage() : " + k.getMessage());  
					// e.getMessage() : ������ ������ String������ �˷���
				}
			
			JOptionPane.showMessageDialog(null, "�л� ���� �߰� �Ϸ�");
			
		}
 };
 
 ///// 2�� ���� = �л� ���� ����
 ActionListener al2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(pl.size() >0) {
				String message =btn.getText()+"�� �����ϼ̽��ϴ�.";
				JOptionPane.showMessageDialog(null, message);
				int input = Integer.parseInt(JOptionPane.showInputDialog("\"����� �л��� �����ϰ������ �Է��ϼ��� [ó�� �л� : 0] :\""));
			  if(input <= pl.size()) {
				  String input2 = JOptionPane.showInputDialog("�����ϰ� ���� �л��� ������ �½��ϱ�? ( Y/N )"+ pl.get(input)+"\n( Y/N ) :");
				  if("Y".equalsIgnoreCase(input2)) {
					  JOptionPane.showMessageDialog(null,"�ٲ� �л� ������ �Է��ϼ���. ");
					  try {   // Exception�� �߻��� ���ɼ��� �ִ� �ڵ�
						  pl.set(input, new PlusStudent(JOptionPane.showInputDialog("�ٲ� �л��� �̸� �Է�"),
									JOptionPane.showInputDialog("�ٲ� �л��� ��ȭ��ȣ �Է�"),
									JOptionPane.showInputDialog("�ٲ� �л��� �ּ� �Է�"),
									Integer.parseInt(JOptionPane.showInputDialog("�ٲ� �л��� ���� ���� �Է�")), 
									Integer.parseInt(JOptionPane.showInputDialog("�ٲ� �л��� ���� ���� �Է�")),
									Integer.parseInt(JOptionPane.showInputDialog("�ٲ� �л��� ���� ���� �Է�"))));
							} catch(Exception k) { // try �ȿ��� �߻��ϴ� ��� ���ܻ�Ȳ�� �̰����� ó��
								JOptionPane.showMessageDialog(null, "������ �߸� �Է��ϼ˽��ϴ�.");
								System.out.println("e.getMessage() : " + k.getMessage());  
								// e.getMessage() : ������ ������ String������ �˷���
							}
					  
				  }else if("N".equalsIgnoreCase(input2)){
					  JOptionPane.showMessageDialog(null, "������ ����մϴ�.");
				  }else {
					  JOptionPane.showMessageDialog(null, "�߸��� �Է��Դϴ�.");
				  }
			  }else {
				  JOptionPane.showMessageDialog(null, "�߸��� �Է��Դϴ�.");
			  }
			}else {
				JOptionPane.showMessageDialog(null, "����� �л� ������ �����ϴ�.");
			}
			
			
		}
};

///// 3�� ���� = �л� ���� ����
ActionListener al3 = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(pl.size() > 0) {
			String message =btn.getText()+"�� �����ϼ̽��ϴ�.";
			JOptionPane.showMessageDialog(null, message);
			int input3 = Integer.parseInt(JOptionPane.showInputDialog("���� ���Ÿ� �ϰ���� �л��� ������ �Է��ϼ��� [ ó�� �л� ���� : 0 ] :"));
			if(input3 < 0 || input3 > pl.size()) {
				JOptionPane.showMessageDialog(null, "�߸��� �л� �����Դϴ�.");
			}
			String input4 = JOptionPane.showInputDialog("�����ϰ� ���� �л� ������ �½��ϱ�?"+
				    pl.get(input3)+
				    "\n( Y/N ):");
					if("Y".equalsIgnoreCase(input4)) {
						pl.remove(input3);
					}else if("N".equalsIgnoreCase(input4)){
				JOptionPane.showMessageDialog(null, "������ ����մϴ�.");
					}else{
			JOptionPane.showMessageDialog(null, "�߸��� �Է°��Դϴ� ������ ����մϴ�.");
		   }
		}else {
	JOptionPane.showMessageDialog(null, "����� �л� ������ �����ϴ�.");
		}
	}
};

///// 4�� ���� = �л� ���� ��ȸ
ActionListener al4 = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(pl.size() > 0) {
			String message =btn.getText()+"�� �����ϼ̽��ϴ�.";
			JOptionPane.showMessageDialog(null, message);
			String message2 ="---------- �л� ���� ����Ʈ ----------";
			for(int i =0; i< pl.size(); ++i) {
				message2 +="\r\n---- [ ("+i+") ��° �л� ���� ��� ] ----------\r\n" +pl.get(i)+"\r\n";
			}
			txt = message2;
			JOptionPane.showMessageDialog(null, message2);
			String inputTxt=JOptionPane.showInputDialog("������ �ؽ�Ʈ���Ϸ� �����Ͻðڽ��ϱ�? (Y/N)");
			if("Y".equalsIgnoreCase(inputTxt)) {
				String inputTxtName=JOptionPane.showInputDialog("���� ���� �ؽ�Ʈ ������ �̸��� �Է��ϼ���");
				String inputTxtAnser=JOptionPane.showInputDialog("���� ���� �ؽ�Ʈ ������ �̸��� "+inputTxtName+"�� �½��ϱ�? ( Y/N )");
				 if("Y".equalsIgnoreCase(inputTxtAnser)) {
						try {
					    	  PrintWriter pw = new PrintWriter(inputTxtName+".txt");
					    	  pw.print(txt);
					    	  pw.close();
					    	  JOptionPane.showMessageDialog(null, inputTxtName+"�� ����Ǿ����ϴ�.");
					      }catch(Exception h) {
					    	  h.printStackTrace();
					      }
				 }else if("N".equalsIgnoreCase(inputTxtAnser)){
					 JOptionPane.showMessageDialog(null, "������ ����մϴ�.");
				 }else {
					 JOptionPane.showMessageDialog(null, "���");
				 }

			}else if("N".equalsIgnoreCase(inputTxt)) {
				JOptionPane.showMessageDialog(null, "������ ����մϴ�.");
			}else {
				JOptionPane.showMessageDialog(null, "���");
			}
		}else {
			JOptionPane.showMessageDialog(null, "����� �л� ������ �����ϴ�.");
		}

		
	}
};

///// 5�� ���� = ���α׷� ����
ActionListener al5 = new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
	JButton btn = (JButton)e.getSource();
	String message =btn.getText()+"�� �����ϼ̽��ϴ�.";
	JOptionPane.showMessageDialog(null, message);
	String inputExit =JOptionPane.showInputDialog("������ �����Ͻðڽ��ϱ�? (Y/N)");
	if("Y".equalsIgnoreCase(inputExit)) {
		sc.close();
		System.exit(0);
	}else if("N".equalsIgnoreCase(inputExit)) {
		JOptionPane.showMessageDialog(null, "���α׷� ���Ḧ ����մϴ�.");
	}else {
		JOptionPane.showMessageDialog(null, "���α׷� ���Ḧ ����մϴ�.");
	}

	
}
};
}
