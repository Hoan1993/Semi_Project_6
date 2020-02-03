package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.Semi_Main_Controller;
import model.Food_DAO;
import model.Food_VO;
import model.MemberVO;
import sendingEmailToUs.SwingEmailSender;
import util.RoundedButton;

public class Main_View extends JFrame {

	//private static Main_View view = new Main_View();
	
	BufferedImage img = null;

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private static String userid = null;
	
	// 0130. 여기서부터 추가된 코드.
	private JPanel contentPane;
	private byte barr[];
	
	private static Food_VO fVo1 = new Food_VO();
	private static Food_VO fVo2 = new Food_VO();
	private static Food_VO fVo3 = new Food_VO();
	private static Food_VO fVo4 = new Food_VO();
	private static Food_VO fVo5 = new Food_VO();
	private static Food_VO fVo6 = new Food_VO();
	
	private static Main_View frame = null; 
	/**
	 * Launch the application.
	 */
	
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_View frame = new Main_View();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			        frame.setUndecorated(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Main_View() {
		
	}
	
	public Main_View(MemberVO mVo, Food_VO fVo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		setLocationRelativeTo(null);
		setLocationRelativeTo(null);
		
		setTitle("오늘뭐먹지");
//		contentPane = new JPanel();
/*//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);*/
//		contentPane.setLayout(null);
		
		/*getContentPane().setBackground(Color.GRAY);*/
		
		//setBounds(100, 100, 956, 631);
		
       
	/*	getContentPane().setLayout(null);*/
		
/*		JLabel lblNewLabel = new JLabel("오늘뭐먹지?");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(12, 10, 410, 15);
		getContentPane().add(lblNewLabel);*/
		
		// 부가메뉴
		
		JMenuBar bar2 = new JMenuBar();
		JMenu jm2 = new JMenu("  ≡  ");
		
		JMenuItem jmia0 = new JMenuItem("새로고침");
		jmia0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//MemberVO mVo = new MemberVO();
				dispose();
	            Food_VO fVo = new Food_VO();
	            Main_View toMain = new Main_View(mVo, fVo);
	            toMain.setVisible(true);
			}
		});
		
		JMenuItem jmia1 = new JMenuItem("음식월드컵게임");
		jmia1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "음식 월드컵 32강 시작");
				
			}
		});
		
		JMenuItem jmia2 = new JMenuItem("음식스케쥴러");
		jmia2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "입력금액에 맞는 한 달 식단을 짜 드립니다.");
				
			}
		});
		jm2.add(jmia0);
		jm2.add(jmia1);
		jm2.add(jmia2);
		
//		getContentPane().add(jm1);
		getContentPane().add(bar2);
		bar2.add(jm2);
//		jm1.setBounds(600, 29, 96, 27);
//		jm1.setVisible(true);
		bar2.setBounds(12, 29, 38, 27);
		bar2.setVisible(true);

		// 검색 받는 부분
		textField = new JTextField();
		textField.setBounds(55, 31, 280, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		// 서치 버튼.
		//JButton btnNewButton = new JButton("Search");
		JButton btnNewButton = new RoundedButton("O");
		btnNewButton.setBackground(SystemColor.activeCaption);
		//btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(340, 29, 40, 27);
		getContentPane().add(btnNewButton);
		
		// 마이페이지. 로그아웃 기능과 회원정보변경 기능을 제공한다.
		JMenuBar bar = new JMenuBar();
		JMenu jm1 = new JMenu("^ _ ^");
		
		
		JMenuItem jmi1 = new JMenuItem("로그아웃");
		jmi1.addActionListener(new ActionListener() {
			//MainController controller = new MainController(view);
			@Override
			public void actionPerformed(ActionEvent e) {
				// 간단한 작업은 굳이 controller를 거치지 않음.
				//JOptionPane.showMessageDialog(null, "로그아웃을 눌렀음");
				JOptionPane.showMessageDialog(null, mVo.getName()+"님 안녕히 가세요.");
				dispose();
				LoginView lgView = new LoginView();
				lgView.setVisible(true);
				
			}
		});
		
/*		JMenuItem jmi2 = new JMenuItem("회원정보변경");
		jmi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "회원정보변경 눌렀음");
				dispose();
				UpdateSecurityCheckView view = new UpdateSecurityCheckView(mVo);
				//UpdateMemberView updateView = new UpdateMemberView(mVo);
				view.setVisible(true);
			
			}
		});*/
		
		JMenuItem jmi2_1 = new JMenuItem("마이페이지");
		jmi2_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyPageView view = new MyPageView(mVo);
				//UpdateMemberView updateView = new UpdateMemberView(mVo);
				view.setVisible(true);
			
			}
		});
		
		JMenuItem jmi3 = new JMenuItem("고객불편사항");
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "<오늘뭐먹지>팀에게 불편사항/개선점을 전해주세요.");
			      try {
			            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			         
			        SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                new SwingEmailSender(mVo).setVisible(true);
			            }
			        });
						     
				//dispose();
				//UpdateSecurityCheckView view = new UpdateSecurityCheckView(mVo);
				//UpdateMemberView updateView = new UpdateMemberView(mVo);
				//view.setVisible(true);
			
			}
		});
		
		jm1.add(jmi1);
/*		jm1.add(jmi2);*/
		jm1.add(jmi2_1);
		jm1.addSeparator();
		jm1.add(jmi3);
		
//		getContentPane().add(jm1);
		getContentPane().add(bar);
		bar.add(jm1);
//		jm1.setBounds(600, 29, 96, 27);
//		jm1.setVisible(true);
		bar.setBounds(384, 29, 38, 27);
		bar.setVisible(true);
		
		// 배경화면 넣는 부분
/*		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(1920, 1080);
		layeredPane.setLayout(null);*/
		
/*		try {
			//String back_image1 = "C:\\Users\\sist\\Desktop\\image\\test.png";
			//String back_image2 = "C:\\Users\\sist\\Desktop\\image\\back_ground_image2.png";
			String back_image2 = "image/back_ground_image2.png";
			img = ImageIO.read(new File(back_image2));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}
		myPanel panel = new myPanel();*/
		//getContentPane().setSize(getWidth(), getHeight());
	/*	panel.setSize(1920, 1080);
		//panel.setMaximumSize(getMaximumSize());
		layeredPane.add(panel);*/
		
		setLayout(null);
/*		
		add(layeredPane);*/
	
		ImageIcon iconTest1 = null;
		ImageIcon iconTest2 = null;
		ImageIcon iconTest3 = null;
		ImageIcon iconTest4 = null;
		ImageIcon iconTest5 = null;
		ImageIcon iconTest6 = null;
		
		int [] randoms = new int[6];
		
		int countNum = Food_DAO.calcCount();
		
		for(int i=0; i<randoms.length; i++) {
			randoms[i] = (int)(Math.random()*countNum)+1;
			for(int j=0; j<i; j++) {
				if(randoms[i] == randoms[j]) {
					i--;
				}
			}
		}
	
		for(int i=0; i<randoms.length; i++) {
			System.out.println(randoms[i]+" ");
		}
		
		
		fVo1 = Food_DAO.imageFromDB(randoms[0]);
		fVo2 = Food_DAO.imageFromDB(randoms[1]);
		fVo3 = Food_DAO.imageFromDB(randoms[2]);
		fVo4 = Food_DAO.imageFromDB(randoms[3]);
		fVo5 = Food_DAO.imageFromDB(randoms[4]);
		fVo6 = Food_DAO.imageFromDB(randoms[5]);
		
		iconTest1 = fVo1.getIcon();
		iconTest2 = fVo2.getIcon();
		iconTest3 = fVo3.getIcon();
		iconTest4 = fVo4.getIcon();
		iconTest5 = fVo5.getIcon();
		iconTest6 = fVo6.getIcon();
		
		
		JButton btnNewButton_0 = new JButton("New button", iconTest1);
		
		/*Semi_Main_Controller controller = new Semi_Main_Controller(this);*/
		Semi_Main_Controller controller = new Semi_Main_Controller(this);
		btnNewButton_0.addMouseListener(new MouseAdapter() {
			   @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                	
	                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
	                /*	btnNewButton.setIcon(new ImageIcon(img));*/
	                	controller.showdetailView(mVo, fVo1, frame);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            }
	 
	            @Override
	            public void mouseExited(MouseEvent e) {
	            	ImageIcon iconTest1 = fVo1.getIcon();
	            	btnNewButton_0.setIcon(iconTest1);
	            }
	 
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	ImageIcon iconTest_1 = fVo1.getIcon2();
	            	btnNewButton_0.setIcon(iconTest_1);
	            }
			
		});
/*		btnNewButton_0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showdetailView(mVo, fVo1, frame);
				
			}
		});*/
		btnNewButton_0.setBounds(12, 62, 410, 286);
		getContentPane().add(btnNewButton_0);
		
		
		
		JButton btnNewButton_1 = new JButton("New button", iconTest2);
		
		//Semi_Main_Controller controller = new Semi_Main_Controller();
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			   @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                	
	                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
	                /*	btnNewButton.setIcon(new ImageIcon(img));*/
	                	controller.showdetailView(mVo, fVo2, frame);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            }
	 
	            @Override
	            public void mouseExited(MouseEvent e) {
	            	ImageIcon iconTest2 = fVo2.getIcon();
	            	btnNewButton_1.setIcon(iconTest2);
	            }
	 
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	ImageIcon iconTest_2 = fVo2.getIcon2();
	            	btnNewButton_1.setIcon(iconTest_2);
	            }
			
		});
		
/*		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showdetailView(mVo, fVo2, frame);
				
			}
		});*/
		btnNewButton_1.setBounds(12, 358, 202, 151);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button", iconTest3);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			   @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                	
	                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
	                /*	btnNewButton.setIcon(new ImageIcon(img));*/
	                	controller.showdetailView(mVo, fVo3, frame);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            }
	 
	            @Override
	            public void mouseExited(MouseEvent e) {
	            	ImageIcon iconTest3 = fVo3.getIcon();
	            	btnNewButton_2.setIcon(iconTest3);
	            }
	 
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	ImageIcon iconTest_3 = fVo3.getIcon2();
	            	btnNewButton_2.setIcon(iconTest_3);
	            }
			
		});
		
		
/*		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showdetailView(mVo, fVo3, frame);
				
			}
		});*/
		btnNewButton_2.setBounds(225, 358, 197, 151);
		getContentPane().add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("New button", iconTest4);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			   @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                	
	                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
	                /*	btnNewButton.setIcon(new ImageIcon(img));*/
	                	controller.showdetailView(mVo, fVo4, frame);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            }
	 
	            @Override
	            public void mouseExited(MouseEvent e) {
	            	ImageIcon iconTest4 = fVo4.getIcon();
	            	btnNewButton_3.setIcon(iconTest4);
	            }
	 
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	ImageIcon iconTest_4 = fVo4.getIcon2();
	            	btnNewButton_3.setIcon(iconTest_4);
	            }
			
		});
		
		
/*		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showdetailView(mVo, fVo4, frame);
				
			}
		});*/
		btnNewButton_3.setBounds(12, 519, 202, 161);
		getContentPane().add(btnNewButton_3);
		
		
		
		JButton btnNewButton_4 = new JButton("New button", iconTest5);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			   @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                	
	                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
	                /*	btnNewButton.setIcon(new ImageIcon(img));*/
	                	controller.showdetailView(mVo, fVo5, frame);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            }
	 
	            @Override
	            public void mouseExited(MouseEvent e) {
	            	ImageIcon iconTest5 = fVo5.getIcon();
	            	btnNewButton_4.setIcon(iconTest5);
	            }
	 
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	ImageIcon iconTest_5 = fVo5.getIcon2();
	            	btnNewButton_4.setIcon(iconTest_5);
	            }
			
		});
		
		
/*		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showdetailView(mVo, fVo5, frame);
				
			}
		});*/
		btnNewButton_4.setBounds(225, 519, 197, 74);
		getContentPane().add(btnNewButton_4);
		

		JButton btnNewButton_5 = new JButton("New button", iconTest6);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			   @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                	
	                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
	                /*	btnNewButton.setIcon(new ImageIcon(img));*/
	                	controller.showdetailView(mVo, fVo6, frame);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            }
	 
	            @Override
	            public void mouseExited(MouseEvent e) {
	            	ImageIcon iconTest6 = fVo6.getIcon();
	            	btnNewButton_5.setIcon(iconTest6);
	            }
	 
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	ImageIcon iconTest_6 = fVo6.getIcon2();
	            	btnNewButton_5.setIcon(iconTest_6);
	            }
			
		});
/*		btnNewButton_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showdetailView(mVo, fVo6, frame);
				
			}
		});*/
		btnNewButton_5.setBounds(225, 606, 197, 74);
		getContentPane().add(btnNewButton_5);
		
	
	
	
	
	}
	
/*	class myPanel extends JPanel {
		*//**
		 * 
		 *//*
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
	
			g.drawImage(img, 0, 0, 1920, 1080, null);
					
		}
	}*/

}
