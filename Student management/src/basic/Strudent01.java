package basic;


import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Strudent01 {
	
 public static void main(String[] args) {
	JFrame jf = new JFrame("학생 관리 프로그램");
	jf.setSize(500, 700);   // (너비 500, 높이 700)
	jf.setLocationRelativeTo(null);  // 화면 중앙에 배치
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	// 레이아웃 준비
	// 종류 ) FlowLayout, GridLayout, BorderLayout
	//FlowLayout layout = new FlowLayout();  // 자연스럽게 순차적으로 배치
		 GridLayout layout = new GridLayout(6, 1); // 행 , 열 구조의 형태 . 2행 3열
		 //BorderLayout layout = new BorderLayout(); // 동,서,남,북,중앙 형태 ( add 할때 추가 옵션 써야 함)
	jf.setLayout(layout);
	JButton jb1 = new JButton("-- 학생 정보 추가 --");
	JButton jb2 = new JButton("-- 학생 정보 수정 --");
	JButton jb3 = new JButton("-- 학생 정보 제거 --");
	JButton jb4 = new JButton("- 학생 정보 조회/저장 -");
	  //                      학생 조회는 1. 모두 조회 , 검색 조회로 나눠진다.
	JButton jb5 = new JButton("-- 프로그램 종료 --");
	jf.add(jb1);
	jf.add(jb2);
	jf.add(jb3);
	jf.add(jb4);
	jf.add(jb5);
	jf.add(new JLabel("만든사람 : siepe \n"));

	 jf.setVisible(true); // 창 보이게 하기
	 // 이벤트 리스너 : 사용자의 선택 , 입력 등의 상호작용을 인식하는 객체
    FirstButton fi = new FirstButton();
    

    
   jb1.addActionListener(fi.al);
   jb2.addActionListener(fi.al2);
   jb3.addActionListener(fi.al3);
   jb4.addActionListener(fi.al4);
   jb5.addActionListener(fi.al5);
   
   

	}
	
	
	
	

	
	
	
}

