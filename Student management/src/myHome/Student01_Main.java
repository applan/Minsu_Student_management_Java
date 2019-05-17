package myHome;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import util.MyUtil;
/*
 * < �л� ���� ���α׷�>
1. �л� ���
2. ��� �л� ����
3. 1�� ����
4. �õ� ����
5. ��� �� ���� ( �й�, �̸�, ��� ���)
6. �л� ���� ( �й��� �Է� �ް� ��,��,�� ���� ==> ���, ����� �ڵ� ���)
7. �л� ���� ( �й��� �Է� �ް� �ش� �л��� ���� ==> "���� �Ϸ�" Ȥ�� "�̵�� �л�" ���)
0. ����
 */
public class Student01_Main {
	int num;
	boolean bol;
	JTextArea textArea;
	Student01_PLUSsql sq;
	Student01_Update up;
	Student01_CheckUpdate chUp;
	public Student01_Main() {
		BorderLayout bigLayout;
        Student01_CheckSystem ch = new Student01_CheckSystem();
        Student01_FirstStudent first = new Student01_FirstStudent();
        Student01_LastStudent last = new Student01_LastStudent();
        Student01_Order order = new Student01_Order();
		JTextField textField;
		GridLayout layout = new GridLayout(7, 1);
		JLabel jl = new JLabel("siepe");
		JLabel jl2 = new JLabel(" ");
		TitledBorder ti = new TitledBorder(new EtchedBorder(),"������");
		jl.setBorder(ti);
		// jl.setPreferredSize(new Dimension(W(����),H()));
		JFrame jf = new JFrame("�л� ���� ���α׷�");
		jf.setSize(1000, 700); // (�ʺ� 1000, ���� 700)
		jf.setLocationRelativeTo(null); // ȭ�� �߾ӿ� ��ġ
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bigLayout = new BorderLayout();
		jf.setLayout(bigLayout);
		JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder( new EtchedBorder(), " "));
		panel.setLayout(layout);

		// Text Area ����
        JPanel showin = new JPanel();
        showin.setBorder(new TitledBorder( new EtchedBorder(), "�л� ���� ǥ��ĭ "));
		textArea = new JTextArea(33,55);
		textArea.setEditable(false); // ����ڰ� ���� �Ұ�.
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		showin.add(scrollPane);

		// ���̾ƿ� �غ�
		// ���� ) FlowLayout, GridLayout, BorderLayout
		// FlowLayout layout = new FlowLayout(); // �ڿ������� ���������� ��ġ
		// �� , �� ������ ���� . 2�� 3��
		// = new BorderLayout(); // ��,��,��,��,�߾� ���� ( add �Ҷ� �߰� �ɼ� ��� ��)

		JButton jb1 = new JButton("-- �л� ���� �߰� --");
		JButton jb2 = new JButton("-- ��� �л� ���� --");
		JButton jb3 = new JButton("-- 1�� ���� --");
		JButton jb4 = new JButton("- �õ� ���� -");
		JButton jb5 = new JButton("- ��� �� ���� -");// �й�, �̸� , ��� ���
		JButton jb6 = new JButton("- �л� ���� -"); // �й� �Է¹����� ��,��,�� ���� ==> ���, ����� �ڵ� ���)
		JButton jb7 = new JButton("- �л� ���� -"); // ( �й��� �Է� �ް� �ش� �л��� ���� ==> "���� �Ϸ�" Ȥ�� "�̵�� �л�" ���)
		JButton jb8 = new JButton("- ����â �ʱ�ȭ -");
		JButton jb0 = new JButton("- ���� -");

		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		panel.add(jb4);
		panel.add(jb5);
		panel.add(jb6);
		panel.add(jb7);
		panel.add(jb8);
		panel.add(jb0);
		panel.add(jl2);
		panel.add(jl);
		jf.add(showin, BorderLayout.WEST);
		jf.add(panel, BorderLayout.EAST);
		// �̺�Ʈ ������ : ������� ���� , �Է� ���� ��ȣ�ۿ��� �ν��ϴ� ��ü
		textArea.setText(ch.Student01_CheckSystem2());
		
// ----------------------------------------------------------------------------------------------------				
//// 1�� ���� = �л� ���
		 ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 JButton btn = (JButton)e.getSource();
				String message = btn.getText()+"�� �����ϼ̽��ϴ�.";
				JOptionPane.showMessageDialog(null, message);
				JOptionPane.showMessageDialog(null, "�߰��ҷ��� �л��� ������ �Է��ϼ��� ");
				try {
					
					sq = new Student01_PLUSsql(JOptionPane.showInputDialog(null, "�л��� �̸��� �Է��ϼ���"),
							Integer.parseInt(JOptionPane.showInputDialog(null, "�л��� ���������� �Է��ϼ���")),
							Integer.parseInt(JOptionPane.showInputDialog(null, "�л��� ���������� �Է��ϼ���")),
							Integer.parseInt(JOptionPane.showInputDialog(null, "�л��� ���������� �Է��ϼ���"))
							);
						JOptionPane.showMessageDialog(null, "�л� ���� �߰� �Ϸ�");
						textArea.setText(ch.Student01_CheckSystem2());
					} catch(Exception k) { // try �ȿ��� �߻��ϴ� ��� ���ܻ�Ȳ�� �̰����� ó��
						JOptionPane.showMessageDialog(null, "������ �߸� �Է��ϼ˽��ϴ�.");
						System.out.println("e.getMessage() : " + k.getMessage());  
						// e.getMessage() : ������ ������ String������ �˷���
					}
				

				
				
			}
		};
// ----------------------------------------------------------------------------------------------------				
// 2�� ���� = ��� �л� ���� ���
		ActionListener al2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String message = btn.getText() + "�� �����ϼ̽��ϴ�.";
				textArea.setText(ch.Student01_CheckSystem2());
				JOptionPane.showMessageDialog(null, message);

			};
		};
// ----------------------------------------------------------------------------------------------------		
//// 3�� ���� = -- 1�� ���� --
		ActionListener al3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String message = btn.getText() + "�� �����ϼ̽��ϴ�.";
				textArea.setText(first.Student01_FirstStudent2());
				JOptionPane.showMessageDialog(null, message);

			};
		};
// ----------------------------------------------------------------------------------------------------		
//// 4�� ���� = -- �õ� ���� --
			ActionListener al4 = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton) e.getSource();
					String message = btn.getText() + "�� �����ϼ̽��ϴ�.";
					textArea.setText(last.Student01_LastStudent2());
					JOptionPane.showMessageDialog(null, message);

				};
			};	
// ----------------------------------------------------------------------------------------------------		
//// 5�� ���� = -- ��� �� ���� --
					ActionListener al5 = new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton btn = (JButton) e.getSource();
							String message = btn.getText() + "�� �����ϼ̽��ϴ�.";
							String anser2 = JOptionPane.showInputDialog(null, "������������ ���ðڽ��ϱ� ������������ ���ðڽ��ϱ�? [U/D]");
							if("U".equalsIgnoreCase(anser2)) {
								JOptionPane.showMessageDialog(null,"������������ ǥ���մϴ�.");
								textArea.setText(order.OrderASC());
							}else if("D".equalsIgnoreCase(anser2)) {
								JOptionPane.showMessageDialog(null,"������������ ǥ���մϴ�.");
								textArea.setText(order.OrderDESC());
							}else {
								JOptionPane.showMessageDialog(null,"�߸��� ���ڸ� �Է��ϼ̽��ϴ�.");
							}

						};
					};
// ----------------------------------------------------------------------------------------------------				
//// 6�� ���� = �л� ����     [[ �������� (���� ��ȣ �����ص� �Ѿ��) ]]
				 ActionListener al6 = new ActionListener() {
							
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton btn = (JButton)e.getSource();
							String message = btn.getText()+"�� �����ϼ̽��ϴ�.";
							JOptionPane.showMessageDialog(null, message);
							
							try {
								num = Integer.parseInt(JOptionPane.showInputDialog(null, "������ �л��� �й��� �Է��ϼ���"));
								boolean bol2 = chUp.Stu(num, bol);
								
								if(bol2 = true) {
									String anser3 =JOptionPane.showInputDialog(null, num+" �й��� �л��� �����Ͻðڽ��ϱ�? [Y/N]");
									if("Y".equalsIgnoreCase(anser3)) {
										up = new Student01_Update(num,
												Integer.parseInt(JOptionPane.showInputDialog(null,"���� ������ �Է��ϼ���")),
												Integer.parseInt(JOptionPane.showInputDialog(null,"���� ������ �Է��ϼ���")),
												Integer.parseInt(JOptionPane.showInputDialog(null,"���� ������ �Է��ϼ���")));
												JOptionPane.showMessageDialog(null, num+" �й��� �л� ���� �Ϸ�");
												textArea.setText(ch.Student01_CheckSystem2());
									}else if("N".equalsIgnoreCase(anser3)) {
										JOptionPane.showMessageDialog(null,num+" �й��� �л� ������ ��ҵǾ����ϴ�.");
										textArea.setText(ch.Student01_CheckSystem2());
									}else {
										JOptionPane.showMessageDialog(null,"���� �л��̰ų� �߸��� ���ڸ� �Է��ϼ̽��ϴ�");
									}
								}else {
									JOptionPane.showMessageDialog(null, "�ش� �л��� �����ϴ�");
								}
								
								} catch(Exception k) {
									JOptionPane.showMessageDialog(null, "������ �߸� �Է��ϼ˽��ϴ�.");
									k.printStackTrace();
								}
										
						}
					};
// ----------------------------------------------------------------------------------------------------
//// 8�� ���� = -- ���� ǥ��â �ʱ�ȭ --
		ActionListener al8 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String message = btn.getText() + "�� �����ϼ̽��ϴ�.";
				String anser = JOptionPane.showInputDialog(null, "���� ǥ��â�� �ʱ�ȭ �Ͻðڽ��ϱ�?"
						+ "  [Y/N]");
				if("Y".equalsIgnoreCase(anser)) {
					JOptionPane.showMessageDialog(null,"���� ǥ��â�� �ʱ�ȭ �մϴ�.");
					textArea.setText("");
				}else if("N".equalsIgnoreCase(anser)) {
					JOptionPane.showMessageDialog(null, "���� ǥ��â �ʱ�ȭ�� ����մϴ�.");
				}else {
					JOptionPane.showMessageDialog(null,"�߸��� ���ڸ� �Է��ϼ̽��ϴ�.");
				}

				
			}
		};
// ----------------------------------------------------------------------------------------------------				
////  0. ����
		ActionListener al0 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				String message = "�л� ���� ���α׷��� �����մϴ�.";
				JOptionPane.showMessageDialog(null, message);
				System.exit(0);
				Connection conn =null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				try { }catch(Exception ex) {
					ex.printStackTrace();
				}finally {
				    MyUtil.close(conn, ps,rs);

				}
			
				};
			};
			
// ----------------------------------------------------------------------------------------------------	
/////////// ��ư�� �׼� ������
		jb1.addActionListener(al);
		jb2.addActionListener(al2);
		jb3.addActionListener(al3);
		jb4.addActionListener(al4);
		jb5.addActionListener(al5);
		jb6.addActionListener(al6);
		jb0.addActionListener(al0);
		jb8.addActionListener(al8);
			
		jf.setVisible(true);  // GUI���̰� �ϱ�.

	}

	

	public static void main(String[] args) {
		new Student01_Main();
	}
}
