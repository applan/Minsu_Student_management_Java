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
	
	
///// 1번 선택 = 학생 정보 추가
	ActionListener al = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			String message =btn.getText()+"을 선택하셨습니다.";
			JOptionPane.showMessageDialog(null, message);
			JOptionPane.showMessageDialog(null, "추가하려는 학생의 정보입력를 입력하세요 ");
			try {   // Exception이 발생할 가능성이 있는 코드
				
				pl.add(new PlusStudent(
						JOptionPane.showInputDialog("학생의 이름 입력"),
						JOptionPane.showInputDialog("학생의 전화번호 입력"),
						JOptionPane.showInputDialog("학생의 주소 입력"),
						Integer.parseInt(JOptionPane.showInputDialog("학생의 국어 점수 입력")), 
						Integer.parseInt(JOptionPane.showInputDialog("학생의 영어 점수 입력")),
						Integer.parseInt(JOptionPane.showInputDialog("학생의 수학 점수 입력"))));
				
				} catch(Exception k) { // try 안에서 발생하는 모든 예외상황을 이곳에서 처리
					JOptionPane.showMessageDialog(null, "정보를 잘못 입력하셧습니다.");
					System.out.println("e.getMessage() : " + k.getMessage());  
					// e.getMessage() : 문제의 원일을 String형으로 알려줌
				}
			
			JOptionPane.showMessageDialog(null, "학생 정보 추가 완료");
			
		}
 };
 
 ///// 2번 선택 = 학생 정보 수정
 ActionListener al2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(pl.size() >0) {
				String message =btn.getText()+"을 선택하셨습니다.";
				JOptionPane.showMessageDialog(null, message);
				int input = Integer.parseInt(JOptionPane.showInputDialog("\"몇번쨰 학생을 수정하고싶은지 입력하세요 [처음 학생 : 0] :\""));
			  if(input <= pl.size()) {
				  String input2 = JOptionPane.showInputDialog("수정하고 싶은 학생의 정보가 맞습니까? ( Y/N )"+ pl.get(input)+"\n( Y/N ) :");
				  if("Y".equalsIgnoreCase(input2)) {
					  JOptionPane.showMessageDialog(null,"바꿀 학생 정보를 입력하세요. ");
					  try {   // Exception이 발생할 가능성이 있는 코드
						  pl.set(input, new PlusStudent(JOptionPane.showInputDialog("바꿀 학생의 이름 입력"),
									JOptionPane.showInputDialog("바꿀 학생의 전화번호 입력"),
									JOptionPane.showInputDialog("바꿀 학생의 주소 입력"),
									Integer.parseInt(JOptionPane.showInputDialog("바꿀 학생의 국어 점수 입력")), 
									Integer.parseInt(JOptionPane.showInputDialog("바꿀 학생의 영어 점수 입력")),
									Integer.parseInt(JOptionPane.showInputDialog("바꿀 학생의 수학 점수 입력"))));
							} catch(Exception k) { // try 안에서 발생하는 모든 예외상황을 이곳에서 처리
								JOptionPane.showMessageDialog(null, "정보를 잘못 입력하셧습니다.");
								System.out.println("e.getMessage() : " + k.getMessage());  
								// e.getMessage() : 문제의 원일을 String형으로 알려줌
							}
					  
				  }else if("N".equalsIgnoreCase(input2)){
					  JOptionPane.showMessageDialog(null, "수정을 취소합니다.");
				  }else {
					  JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				  }
			  }else {
				  JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			  }
			}else {
				JOptionPane.showMessageDialog(null, "저장된 학생 정보가 없습니다.");
			}
			
			
		}
};

///// 3번 선택 = 학생 정보 제거
ActionListener al3 = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(pl.size() > 0) {
			String message =btn.getText()+"을 선택하셨습니다.";
			JOptionPane.showMessageDialog(null, message);
			int input3 = Integer.parseInt(JOptionPane.showInputDialog("정보 제거를 하고싶은 학생의 번쨰를 입력하세요 [ 처음 학생 번쨰 : 0 ] :"));
			if(input3 < 0 || input3 > pl.size()) {
				JOptionPane.showMessageDialog(null, "잘못된 학생 번쨰입니다.");
			}
			String input4 = JOptionPane.showInputDialog("삭제하고 싶은 학생 정보가 맞습니까?"+
				    pl.get(input3)+
				    "\n( Y/N ):");
					if("Y".equalsIgnoreCase(input4)) {
						pl.remove(input3);
					}else if("N".equalsIgnoreCase(input4)){
				JOptionPane.showMessageDialog(null, "삭제를 취소합니다.");
					}else{
			JOptionPane.showMessageDialog(null, "잘못된 입력값입니다 삭제를 취소합니다.");
		   }
		}else {
	JOptionPane.showMessageDialog(null, "저장된 학생 정보가 없습니다.");
		}
	}
};

///// 4번 선택 = 학생 정보 조회
ActionListener al4 = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(pl.size() > 0) {
			String message =btn.getText()+"을 선택하셨습니다.";
			JOptionPane.showMessageDialog(null, message);
			String message2 ="---------- 학생 정보 리스트 ----------";
			for(int i =0; i< pl.size(); ++i) {
				message2 +="\r\n---- [ ("+i+") 번째 학생 정보 출력 ] ----------\r\n" +pl.get(i)+"\r\n";
			}
			txt = message2;
			JOptionPane.showMessageDialog(null, message2);
			String inputTxt=JOptionPane.showInputDialog("정보를 텍스트파일로 저장하시겠습니까? (Y/N)");
			if("Y".equalsIgnoreCase(inputTxt)) {
				String inputTxtName=JOptionPane.showInputDialog("새로 만들 텍스트 파일의 이름을 입력하세요");
				String inputTxtAnser=JOptionPane.showInputDialog("새로 만들 텍스트 파일의 이름이 "+inputTxtName+"이 맞습니까? ( Y/N )");
				 if("Y".equalsIgnoreCase(inputTxtAnser)) {
						try {
					    	  PrintWriter pw = new PrintWriter(inputTxtName+".txt");
					    	  pw.print(txt);
					    	  pw.close();
					    	  JOptionPane.showMessageDialog(null, inputTxtName+"이 저장되었습니다.");
					      }catch(Exception h) {
					    	  h.printStackTrace();
					      }
				 }else if("N".equalsIgnoreCase(inputTxtAnser)){
					 JOptionPane.showMessageDialog(null, "저장을 취소합니다.");
				 }else {
					 JOptionPane.showMessageDialog(null, "취소");
				 }

			}else if("N".equalsIgnoreCase(inputTxt)) {
				JOptionPane.showMessageDialog(null, "저장을 취소합니다.");
			}else {
				JOptionPane.showMessageDialog(null, "취소");
			}
		}else {
			JOptionPane.showMessageDialog(null, "저장된 학생 정보가 없습니다.");
		}

		
	}
};

///// 5번 선택 = 프로그램 종료
ActionListener al5 = new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
	JButton btn = (JButton)e.getSource();
	String message =btn.getText()+"을 선택하셨습니다.";
	JOptionPane.showMessageDialog(null, message);
	String inputExit =JOptionPane.showInputDialog("정말로 종료하시겠습니까? (Y/N)");
	if("Y".equalsIgnoreCase(inputExit)) {
		sc.close();
		System.exit(0);
	}else if("N".equalsIgnoreCase(inputExit)) {
		JOptionPane.showMessageDialog(null, "프로그램 종료를 취소합니다.");
	}else {
		JOptionPane.showMessageDialog(null, "프로그램 종료를 취소합니다.");
	}

	
}
};
}
