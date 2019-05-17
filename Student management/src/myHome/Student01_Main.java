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
 * < 학생 관리 프로그램>
1. 학생 등록
2. 모든 학생 보기
3. 1등 보기
4. 꼴등 보기
5. 등수 순 보기 ( 학번, 이름, 평균 출력)
6. 학생 수정 ( 학번을 입력 받고 국,영,수 수정 ==> 평균, 등급은 자동 계산)
7. 학생 삭제 ( 학번을 입력 받고 해당 학생을 삭제 ==> "삭제 완료" 혹은 "미등록 학생" 출력)
0. 종료
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
		TitledBorder ti = new TitledBorder(new EtchedBorder(),"만든이");
		jl.setBorder(ti);
		// jl.setPreferredSize(new Dimension(W(높이),H()));
		JFrame jf = new JFrame("학생 관리 프로그램");
		jf.setSize(1000, 700); // (너비 1000, 높이 700)
		jf.setLocationRelativeTo(null); // 화면 중앙에 배치
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bigLayout = new BorderLayout();
		jf.setLayout(bigLayout);
		JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder( new EtchedBorder(), " "));
		panel.setLayout(layout);

		// Text Area 세팅
        JPanel showin = new JPanel();
        showin.setBorder(new TitledBorder( new EtchedBorder(), "학생 정보 표시칸 "));
		textArea = new JTextArea(33,55);
		textArea.setEditable(false); // 사용자가 편집 불가.
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		showin.add(scrollPane);

		// 레이아웃 준비
		// 종류 ) FlowLayout, GridLayout, BorderLayout
		// FlowLayout layout = new FlowLayout(); // 자연스럽게 순차적으로 배치
		// 행 , 열 구조의 형태 . 2행 3열
		// = new BorderLayout(); // 동,서,남,북,중앙 형태 ( add 할때 추가 옵션 써야 함)

		JButton jb1 = new JButton("-- 학생 정보 추가 --");
		JButton jb2 = new JButton("-- 모든 학생 보기 --");
		JButton jb3 = new JButton("-- 1등 보기 --");
		JButton jb4 = new JButton("- 꼴등 보기 -");
		JButton jb5 = new JButton("- 등수 순 보기 -");// 학번, 이름 , 평균 출력
		JButton jb6 = new JButton("- 학생 수정 -"); // 학번 입력받으면 국,영,수 수정 ==> 평균, 등급은 자동 계산)
		JButton jb7 = new JButton("- 학생 삭제 -"); // ( 학번을 입력 받고 해당 학생을 삭제 ==> "삭제 완료" 혹은 "미등록 학생" 출력)
		JButton jb8 = new JButton("- 정보창 초기화 -");
		JButton jb0 = new JButton("- 종료 -");

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
		// 이벤트 리스너 : 사용자의 선택 , 입력 등의 상호작용을 인식하는 객체
		textArea.setText(ch.Student01_CheckSystem2());
		
// ----------------------------------------------------------------------------------------------------				
//// 1번 선택 = 학생 등록
		 ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 JButton btn = (JButton)e.getSource();
				String message = btn.getText()+"을 선택하셨습니다.";
				JOptionPane.showMessageDialog(null, message);
				JOptionPane.showMessageDialog(null, "추가할려는 학생의 정보를 입력하세요 ");
				try {
					
					sq = new Student01_PLUSsql(JOptionPane.showInputDialog(null, "학생의 이름을 입력하세요"),
							Integer.parseInt(JOptionPane.showInputDialog(null, "학생의 국어점수를 입력하세요")),
							Integer.parseInt(JOptionPane.showInputDialog(null, "학생의 영어점수를 입력하세요")),
							Integer.parseInt(JOptionPane.showInputDialog(null, "학생의 수학점수를 입력하세요"))
							);
						JOptionPane.showMessageDialog(null, "학생 정보 추가 완료");
						textArea.setText(ch.Student01_CheckSystem2());
					} catch(Exception k) { // try 안에서 발생하는 모든 예외상황을 이곳에서 처리
						JOptionPane.showMessageDialog(null, "정보를 잘못 입력하셧습니다.");
						System.out.println("e.getMessage() : " + k.getMessage());  
						// e.getMessage() : 문제의 원일을 String형으로 알려줌
					}
				

				
				
			}
		};
// ----------------------------------------------------------------------------------------------------				
// 2번 선택 = 모든 학생 정보 출력
		ActionListener al2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String message = btn.getText() + "을 선택하셨습니다.";
				textArea.setText(ch.Student01_CheckSystem2());
				JOptionPane.showMessageDialog(null, message);

			};
		};
// ----------------------------------------------------------------------------------------------------		
//// 3번 선택 = -- 1등 보기 --
		ActionListener al3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String message = btn.getText() + "을 선택하셨습니다.";
				textArea.setText(first.Student01_FirstStudent2());
				JOptionPane.showMessageDialog(null, message);

			};
		};
// ----------------------------------------------------------------------------------------------------		
//// 4번 선택 = -- 꼴등 보기 --
			ActionListener al4 = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton) e.getSource();
					String message = btn.getText() + "을 선택하셨습니다.";
					textArea.setText(last.Student01_LastStudent2());
					JOptionPane.showMessageDialog(null, message);

				};
			};	
// ----------------------------------------------------------------------------------------------------		
//// 5번 선택 = -- 등수 순 보기 --
					ActionListener al5 = new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton btn = (JButton) e.getSource();
							String message = btn.getText() + "을 선택하셨습니다.";
							String anser2 = JOptionPane.showInputDialog(null, "오름차순으로 보시겠습니까 내림차순으로 보시겠습니까? [U/D]");
							if("U".equalsIgnoreCase(anser2)) {
								JOptionPane.showMessageDialog(null,"오름차순으로 표기합니다.");
								textArea.setText(order.OrderASC());
							}else if("D".equalsIgnoreCase(anser2)) {
								JOptionPane.showMessageDialog(null,"내림차순으로 표기합니다.");
								textArea.setText(order.OrderDESC());
							}else {
								JOptionPane.showMessageDialog(null,"잘못된 문자를 입력하셨습니다.");
							}

						};
					};
// ----------------------------------------------------------------------------------------------------				
//// 6번 선택 = 학생 수정     [[ 오류있음 (없는 번호 선택해도 넘어가짐) ]]
				 ActionListener al6 = new ActionListener() {
							
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton btn = (JButton)e.getSource();
							String message = btn.getText()+"을 선택하셨습니다.";
							JOptionPane.showMessageDialog(null, message);
							
							try {
								num = Integer.parseInt(JOptionPane.showInputDialog(null, "수정할 학생의 학번을 입력하세요"));
								boolean bol2 = chUp.Stu(num, bol);
								
								if(bol2 = true) {
									String anser3 =JOptionPane.showInputDialog(null, num+" 학번의 학생을 수정하시겠습니까? [Y/N]");
									if("Y".equalsIgnoreCase(anser3)) {
										up = new Student01_Update(num,
												Integer.parseInt(JOptionPane.showInputDialog(null,"국어 점수를 입력하세요")),
												Integer.parseInt(JOptionPane.showInputDialog(null,"영어 점수를 입력하세요")),
												Integer.parseInt(JOptionPane.showInputDialog(null,"수학 점수를 입력하세요")));
												JOptionPane.showMessageDialog(null, num+" 학번의 학생 수정 완료");
												textArea.setText(ch.Student01_CheckSystem2());
									}else if("N".equalsIgnoreCase(anser3)) {
										JOptionPane.showMessageDialog(null,num+" 학번의 학생 수정이 취소되었습니다.");
										textArea.setText(ch.Student01_CheckSystem2());
									}else {
										JOptionPane.showMessageDialog(null,"없는 학생이거나 잘못된 문자를 입력하셨습니다");
									}
								}else {
									JOptionPane.showMessageDialog(null, "해당 학생이 없습니다");
								}
								
								} catch(Exception k) {
									JOptionPane.showMessageDialog(null, "정보를 잘못 입력하셧습니다.");
									k.printStackTrace();
								}
										
						}
					};
// ----------------------------------------------------------------------------------------------------
//// 8번 선택 = -- 정보 표시창 초기화 --
		ActionListener al8 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String message = btn.getText() + "을 선택하셨습니다.";
				String anser = JOptionPane.showInputDialog(null, "정보 표시창을 초기화 하시겠습니까?"
						+ "  [Y/N]");
				if("Y".equalsIgnoreCase(anser)) {
					JOptionPane.showMessageDialog(null,"정보 표시창을 초기화 합니다.");
					textArea.setText("");
				}else if("N".equalsIgnoreCase(anser)) {
					JOptionPane.showMessageDialog(null, "정보 표시창 초기화를 취소합니다.");
				}else {
					JOptionPane.showMessageDialog(null,"잘못된 문자를 입력하셨습니다.");
				}

				
			}
		};
// ----------------------------------------------------------------------------------------------------				
////  0. 종료
		ActionListener al0 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				String message = "학생 관리 프로그램을 종료합니다.";
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
/////////// 버튼에 액션 입히기
		jb1.addActionListener(al);
		jb2.addActionListener(al2);
		jb3.addActionListener(al3);
		jb4.addActionListener(al4);
		jb5.addActionListener(al5);
		jb6.addActionListener(al6);
		jb0.addActionListener(al0);
		jb8.addActionListener(al8);
			
		jf.setVisible(true);  // GUI보이게 하기.

	}

	

	public static void main(String[] args) {
		new Student01_Main();
	}
}
