package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.Button_Calandar_Controller;
import controller.SchdulingController;
import model.Food_DAO;
import model.Food_VO;
import model.MemberDAO;
import model.MemberVO;
import model.MyCalVO;
import util.CustomUI;



@SuppressWarnings("serial")
public class Button_Calandar extends CustomUI {
	private JFrame frame = new JFrame();
	private JLabel lbTitle, lbDayNames[], lbDay;
	private JTextField txtInputMoney;
	private JButton btnBack;
	
	private String text1 = "메인으로 가기";
    private JLabel hyperlink1 = new JLabel(text1);
	
	private MouseListener listener;
	

	
	/*private MemberVO mVo = null;*/
	private MemberDAO mDao = MemberDAO.getInstance();
	private Food_VO fVo = null;
	private MemberVO mVo2 = new MemberVO();
	
	public Button_Calandar(MemberVO mVo2) {
		this.mVo2 = mVo2;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int countNum = Food_DAO.calcCount();
		int randoms = (int)(Math.random()*countNum)+1;
		
		fVo = Food_DAO.imageFromDB(randoms);
		MyCalVO mcVO = new MyCalVO();
		
		SchdulingController sc = new SchdulingController();
		listener = new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() instanceof JLabel) {
					JLabel lb = (JLabel)e.getSource();
					int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
					int selectDay = Integer.parseInt(lb.getText());
					
					if(today > selectDay) {
						JOptionPane.showMessageDialog(frame, "이전 일자는 선택할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					} else {
						/*String reserveDate = lbTitle.getText().substring(0, 4) + "-" + lbTitle.getText().substring(6, 8) + "-" + lb.getText();*/

						/*if(beforePage.equals("Movie")) {
							DetailView dv = new DetailView(mVo, fVo);
							
							new SelectMovie1(userId, reserveDate);
							frame.dispose();
							dv.setVisible(true);
						} *//*else {*/
							/*JOptionPane.showMessageDialog(null, selectDay+"를 선택함");
						
							
							new DetailViewForSC(mVo2, selectDay, 1);*/
							
							
							sc.chooseDate(mVo2, fVo, selectDay);
							frame.dispose();
							//dv.goToDetail();
							
							/*new SelectMovie1(userId, reserveDate);*/
							/*frame.dispose();
							dv.setVisible(true);*/
			/*			}*/
					}
				}
			}
		};
			
		init();
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(beforePage.equals("Movie")) {
					DetailView dv = new DetailView(mVo, fVo);
					new SelectMovie1(userId, reserveDate);
					frame.dispose();
					dv.setVisible(true);
				} else {*/
		/*			DetailView dv = new DetailView(mVo, fVo);
					new SelectMovie1(userId, reserveDate);
					frame.dispose();
					dv.setVisible(true);*/
			/*	}*/
				// 버튼이 눌리면, 입력금액에 맞게 스케쥴링을 해 주어야 한다. 
				frame.dispose();
				sc.insertToDB(txtInputMoney.getText(), mVo2);
				/*JOptionPane.showMessageDialog(null, txtInputMoney.getText()+" 스케쥴링 완료, 입력 금액이 너무 낮으면 물을 먹어야 합니다.");*/
				
				
				
				
			}
		});
		Font f1 = new Font("바탕", Font.ITALIC, 12);
        //hyperlink1.setForeground(Color.BLUE.darker());
		hyperlink1.setBounds(300, 640, 350, 45);
		hyperlink1.setForeground(UIManager.getColor("Button.darkShadow"));
		hyperlink1.setFont(f1);
        hyperlink1.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink1.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {   	
                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
                	hyperlink1.setText(text1);
                	//Main_View view = new FindIdView();
                	/*view.setExtendedState(JFrame.MAXIMIZED_BOTH);*/
                    //view.setUndecorated(false);
                	
                    frame.dispose();
                    Main_View view = new Main_View(mVo2, fVo);
                    view.setVisible(true);
                    //view.setVisible(false);            
                   // view.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
            	hyperlink1.setText(text1);
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink1.setText("<html><a href=''>" + text1 + "</a></html>");
            }
 
        });
		 	
	        //setLayout(new FlowLayout());
	    frame.add(hyperlink1);
		
		//frame.setSize(426, 779);
		frame.setBounds(100, 100, 426, 779);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void init() {
		// backgroundPanel��� �̸��� JPanel��
		// frame�� �־��ش�. 
		
		backgroundPanel = new JPanel();
		frame.setContentPane(backgroundPanel);
		MemberVO mVo3 = mDao.allInfo(mVo2.getUserid());
		if(mVo3.getBalance() == null) {
			mVo3.setBalance(0);
		}
		
		frame.setTitle("한 달 식비 : "+mVo3.getBudget()+"원,"+" 잔액 : "+mVo3.getBalance()+"원");

		CustomUI custom = new CustomUI(backgroundPanel);
		custom.setPanel();
		
		Calendar current = Calendar.getInstance();
		int year = current.get(Calendar.YEAR);
		int month = current.get(Calendar.MONTH);
		int day = current.get(Calendar.DAY_OF_MONTH);
		
		String dayNames[] = {"일", "월", "화", "수", "목", "금", "토"};
		
        lbTitle = custom.setLb("lbTitle", year + "년" + (month+1) + "월", 100, 85, 220, 185, "center", 20, "bold");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		Calendar iterator = (Calendar) calendar.clone();
		iterator.add(Calendar.DAY_OF_MONTH, -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

		Calendar maximum = (Calendar) calendar.clone();
		maximum.add(Calendar.MONTH, +1);

		lbDayNames = new JLabel[dayNames.length];
		int moveX = 0;
		for (int i = 0; i < dayNames.length; i++) {
			lbDayNames[i] = custom.setLb("lbDayNames", dayNames[i], 50 + moveX, 210, 35, 30, "center", 20, "bold");
			backgroundPanel.add(lbDayNames[i]);
			moveX += 50;
		}
		
		moveX = 0;
		int moveY = 0;
		while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
			int iMonth = iterator.get(Calendar.MONTH);
			int iYear = iterator.get(Calendar.YEAR);

			if(50+moveX > 380) {
				moveY += 50;
				moveX = 0;
			}

			lbDay = custom.setLb("lbDay"+iterator.getTimeInMillis(), "", 50 + moveX, 260 + moveY, 35, 30, "center", 20, "bold");
			
			if ((year == iYear) && (month == iMonth)) {
				int iDay = iterator.get(Calendar.DAY_OF_MONTH);
				lbDay.setText(Integer.toString(iDay));
				
				if(day == iDay) {
					lbDay.setForeground(Color.ORANGE);
				}
				
				if(day > iDay) {
					lbDay.setForeground(Color.LIGHT_GRAY);
				}

				lbDay.addMouseListener(listener);
			}

			backgroundPanel.add(lbDay);
			iterator.add(Calendar.DAY_OF_YEAR, +1);
			moveX += 50;
		}
		
		/*txtInputMoney = new JTextField("한 달 식비 입력");       
		txtInputMoney.setForeground(Color.gray);
		txtInputMoney.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtInputMoney.getText().isEmpty()) {
					txtInputMoney.setForeground(Color.gray);
					txtInputMoney.setText("한 달 식비 입력");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtInputMoney.getText().equals("한 달 식비 입력")) {
					txtInputMoney.setForeground(Color.black);
					txtInputMoney.setText("");
				}
				
			}
		});
		txtInputMoney.setBounds(35, 600, 350, 45);
		
        frame.add(txtInputMoney);*/
        txtInputMoney = custom.setTextField("Input", "한 달 식비 입력", 35, 550, 350, 45);
		btnBack = custom.setBtnYellow("btnBack", "식단짜기", 605);
		
		
		
	}
/*	
	
	public static void main(String[] args) {
		new SelectDate();
	}*/
}
