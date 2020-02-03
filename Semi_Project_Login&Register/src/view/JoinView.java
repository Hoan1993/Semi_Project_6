package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.JoinController;
import model.MemberVO;
import util.RoundedButton;

import javax.swing.UIManager;


public class JoinView extends JFrame{
	
	   private static final long serialVersionUID = 3566038652320101414L;
	    private JTextField txtUsername;
	    private JTextField txtUserid;
	    private JTextField txtPassword1;
	    private JTextField txtPassword2;
	    private JTextField txtUserAddress;
	    private JTextField txtUserEmail;
	    private JTextField txtPwdAnswer;
	    
	    private JButton btnJoin;
	    private JButton cancel;
	    
	    private String text = "로그인 화면으로 이동";
	    private JLabel hyperlink = new JLabel(text);
	    
	    public JoinView() {
	    	
	    	getContentPane().setBackground(Color.WHITE);
	        setTitle("회원가입 페이지");
	        setResizable(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        /*setExtendedState(JFrame.MAXIMIZED_BOTH); */
	        setBounds(0, 0, 410, 600);
	        setUndecorated(false);

	        setLocationRelativeTo(null);
	        
	        Container contentPane = this.getContentPane();
	        contentPane.setLayout(null);
	        	     
	        ImageIcon icon = new ImageIcon("C:\\\\NCS\\\\Semi_Project\\\\Semi_Project_Login&Register\\\\image\\\\Join.png");
	        /*Image im = icon.getImage();
	        Image im2 = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	        ImageIcon icon2 = new ImageIcon(im2);*/
	        getContentPane().setLayout(null);
	        JLabel img = new JLabel(new ImageIcon("C:\\NCS\\Semi_Project\\Semi_Project_Login&Register\\image\\Join.png"));
	        img.setBounds(12, 18, 380, 45);
	        img.setBackground(Color.WHITE);                             // 라벨 배경색 지정
	        contentPane.add(img);
	        
	        
	/*        JLabel lblUsername = new JLabel("Username:");
	        lblUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
	        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUsername.setBounds(-37, 99, 120, 25);
	        contentPane.add(lblUsername);*/

	        //txtUsername = new JTextField();
	        JLabel lblUsername = new JLabel("<이름과 아이디>");
	        //lblUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
	        lblUsername.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
	        lblUsername.setBounds(41, 65, 80, 50);
	        contentPane.add(lblUsername);
	        
	        txtUsername = new JTextField("이름");       
	        txtUsername.setForeground(Color.gray);
	        txtUsername.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(txtUsername.getText().isEmpty()) {
						txtUsername.setForeground(Color.gray);
						txtUsername.setText("이름");
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					if(txtUsername.getText().equals("이름")) {
						txtUsername.setForeground(Color.black);
						txtUsername.setText("");
					}
					
				}
			});
	        
	        txtUsername.setBounds(41, 99, 310, 30);
	        contentPane.add(txtUsername);

/*	        JLabel lblUserid = new JLabel("Userid :");
	        lblUserid.setFont(new Font("Calibri", Font.PLAIN, 12));
	        lblUserid.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUserid.setBounds(-37, 132, 120, 25);
	        contentPane.add(lblUserid);*/
	        
	   
	        txtUserid = new JTextField("아이디");
	        
	        txtUserid.setForeground(Color.gray);
	        txtUserid.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(txtUserid.getText().isEmpty()) {
						txtUserid.setForeground(Color.gray);
						txtUserid.setText("아이디");
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					if(txtUserid.getText().equals("아이디")) {
						txtUserid.setForeground(Color.black);
						txtUserid.setText("");
					}
					
				}
			});
	        
	        txtUserid.setBounds(41, 132, 260, 30);
	        contentPane.add(txtUserid);
	        
	        //JButton btnIdCheck = new JButton("중복체크");
	        JButton btnIdCheck = new RoundedButton("중복체크");
	        btnIdCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	        btnIdCheck.setBackground(new Color(255, 204, 0));
	        btnIdCheck.setHorizontalAlignment(SwingConstants.RIGHT);
	        
	        btnIdCheck.setBounds(305, 132, 46, 30);
	        contentPane.add(btnIdCheck);
	        
	        JoinController controller = new JoinController(this);
	        btnIdCheck.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.useridCheck(txtUserid.getText(), txtUserid);
					
				}
			});
	        
	        JLabel lblPassword = new JLabel("<비밀번호와 비밀번호확인>");
	        lblPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
	        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblPassword.setBounds(33, 145, 135, 50);
	        contentPane.add(lblPassword);
	        
	        txtPassword1 = new JPasswordField("비밀번호");
	        
	        txtPassword1.setForeground(Color.gray);
	        txtPassword1.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(txtPassword1.getText().isEmpty()) {
						txtPassword1.setForeground(Color.gray);
						txtPassword1.setText("비밀번호");
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					if(txtPassword1.getText().equals("비밀번호")) {
						txtPassword1.setForeground(Color.black);
						txtPassword1.setText("");
					}
					
				}
			});
	        
	        txtPassword1.setBounds(41, 180, 310, 30);
	        contentPane.add(txtPassword1);
	        
/*	        JLabel lblPassword2 = new JLabel("PWDCheck:");
	        lblPassword2.setFont(new Font("Calibri", Font.PLAIN, 12));
	        lblPassword2.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblPassword2.setBounds(-37, 211, 120, 25);
	        contentPane.add(lblPassword2);*/
	        
	        txtPassword2 = new JPasswordField("비밀번호");
	        
	        txtPassword2.setForeground(Color.gray);
	        txtPassword2.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(txtPassword2.getText().isEmpty()) {
						txtPassword2.setForeground(Color.gray);
						txtPassword2.setText("비밀번호");
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					if(txtPassword2.getText().equals("비밀번호")) {
						txtPassword2.setForeground(Color.black);
						txtPassword2.setText("");
					}
					
				}
			});
	        
	        txtPassword2.setBounds(41, 213, 310, 30);
	        contentPane.add(txtPassword2);
	        
	        JLabel lblAddress = new JLabel("<주소, 이메일, 비밀번호 질문과 답변>");
	        lblAddress.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
	        lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblAddress.setBounds(-95, 250, 310, 30);
	        contentPane.add(lblAddress);
	        
	        txtUserAddress = new JTextField("주소");
	        
	        txtUserAddress.setForeground(Color.gray);
	        txtUserAddress.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(txtUserAddress.getText().isEmpty()) {
						txtUserAddress.setForeground(Color.gray);
						txtUserAddress.setText("주소");
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					if(txtUserAddress.getText().equals("주소")) {
						txtUserAddress.setForeground(Color.black);
						txtUserAddress.setText("");
					}
					
				}
			});
	        
	        txtUserAddress.setBounds(41, 276, 310, 30);
	        contentPane.add(txtUserAddress);
	        	        
	/*        JLabel lblUserEmail = new JLabel("Email :");
	        lblUserEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
	        lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUserEmail.setBounds(-37, 311, 120, 25);
	        contentPane.add(lblUserEmail);*/
	        
	        txtUserEmail = new JTextField("이메일");
	        txtUserEmail.setForeground(Color.gray);
	        txtUserEmail.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(txtUserEmail.getText().isEmpty()) {
						txtUserEmail.setForeground(Color.gray);
						txtUserEmail.setText("이메일");
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					if(txtUserEmail.getText().equals("이메일")) {
						txtUserEmail.setForeground(Color.black);
						txtUserEmail.setText("");
					}
					
				}
			});
	        
	        txtUserEmail.setBounds(41, 311, 310, 30);
	        contentPane.add(txtUserEmail);
	        
	        // 비밀번호 확인 질문.
/*	        JLabel lblPwdQ = new JLabel("비밀번호 확인 질문 :");
	        lblPwdQ.setForeground(Color.BLACK);
	        lblPwdQ.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	        lblPwdQ.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblPwdQ.setBounds(12, 346, 120, 25);
	        contentPane.add(lblPwdQ);*/
	        
	        
	        
	        // 콤보 박스
	        
	        String [] job = {"기억에 남는 추억의 장소는?", 
	        		"자신의 인생 좌우명은?", "자신의 보물 제1호는?", 
	        		"가장 기억에 남는 선생님 성함은?", "타인이 모르는 자신만의 신체비밀이 있다면?",
	        		"추억하고 싶은 날짜가 있다면?", "받았던 선물 중 기억에 남는 독특한 선물은?",
	        		"유년시설 가장 생각나는 친구 이름은?", "인상 깊게 읽은 책 이름은?"};
	        JComboBox<String> jcb = new JComboBox<>(job);
	        jcb.setFont(new Font("바탕", Font.PLAIN, 12));
	        jcb.setBackground(new Color(255, 255, 204));
	        jcb.setBounds(41, 348, 310, 30);
	        getContentPane().add(jcb);
	        jcb.setSelectedIndex(2);
			
	        /*String [] job = {"기억에 남는 추억의 장소는?", 
	        		"자신의 인생 좌우명은?", "자신의 보물 제1호는?", 
	        		"가장 기억에 남는 선생님 성함은?", "타인이 모르는 자신만의 신체비밀이 있다면?",
	        		"추억하고 싶은 날짜가 있다면?", "받았던 선물 중 기억에 남는 독특한 선물은?",
	        		"유년시설 가장 생각나는 친구 이름은?", "인상 깊게 읽은 책 이름은?"};
	        
			JComboBox<String> jcb = new JComboBox<>(job);
	        //pwdCombo = new JComboBox();
			jcb.setBounds(140, 357, 208, 25);
			contentPane.add(jcb);

			jcb.setSelectedIndex(1);*/

/*			JLabel lblPwdAnswer = new JLabel("비밀번호 확인 답변 :");
			lblPwdAnswer.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lblPwdAnswer.setForeground(Color.BLACK);
			lblPwdAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPwdAnswer.setBounds(12, 381, 120, 25);
	        contentPane.add(lblPwdAnswer);*/
	        
	        
	        txtPwdAnswer = new JTextField("비밀번호 확인 답변");
	        
	        txtPwdAnswer.setForeground(Color.gray);
	        txtPwdAnswer.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(txtPwdAnswer.getText().isEmpty()) {
						txtPwdAnswer.setForeground(Color.gray);
						txtPwdAnswer.setText("비밀번호 확인 답변");
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					if(txtPwdAnswer.getText().equals("비밀번호 확인 답변")) {
						txtPwdAnswer.setForeground(Color.black);
						txtPwdAnswer.setText("");
					}
					
				}
			});
	        
	        txtPwdAnswer.setBounds(41, 381, 310, 30);
	        contentPane.add(txtPwdAnswer);
			
		
		//btnJoin = new JButton("회원가입");
		btnJoin = new RoundedButton("회원가입");
		btnJoin.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnJoin.setBackground(new Color(255, 204, 0));
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					// null 값이나 공백이 들어갔는지 확인.
					// 여기서 su1.requestFocus(); 이걸 써서 입력하지 않은걸 입력받을 것임.
					if (txtUsername.getText() == null || txtUsername.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "이름은 필수 입력 사항입니다.");
						txtUsername.requestFocus();
					} 	else if(!Pattern.matches("^[가-힣]*$", txtUsername.getText())) {
						JOptionPane.showMessageDialog(null, "이름에는 한글만 사용할 수 있습니다.");
						txtUsername.setText("");
						txtUsername.requestFocus();
					}
						else if(txtUserid.getText() == null || txtUserid.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "아이디는 필수 입력 사항입니다.");
						txtUserid.requestFocus();
					} 	else if(!Pattern.matches("^[a-zA-Z0-9]*$", txtUserid.getText())) {
						JOptionPane.showMessageDialog(null, "아이디로는 로마자와 숫자만  쓸 수 있습니다.");
						txtUserid.setText("");
						txtUserid.requestFocus();
					} 
					else if(txtPassword1.getText() == null || txtPassword1.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "비밀번호는 필수 입력 사항입니다.");	
						txtPassword1.requestFocus();
					}
					else if(txtPassword2.getText() == null || txtPassword2.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "비밀번호 확인은 필수 입력 사항입니다.");	
						txtPassword2.requestFocus();				
					} else if(txtUserEmail.getText() == null || txtUserEmail.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "이메일은 필수 입력 사항입니다.");	
						txtUserEmail.requestFocus();
					} else if(!Pattern.matches("^[a-zA-Z0-9]+@[\\D]+$", txtUserEmail.getText())) {
						JOptionPane.showMessageDialog(null, "이메일 형식을 맞춰주세요. 예시) kim1234@naver.com");
						txtUserEmail.setText("");
						txtUserEmail.requestFocus();
					} 
						else if(txtPwdAnswer.getText() == null || txtPwdAnswer.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "비밀번호 확인 답변은 필수 입력 사항입니다.");	
						txtPwdAnswer.requestFocus();
					} 	
					
					if(!txtPassword1.getText().equals(txtPassword2.getText())) {
						JOptionPane.showMessageDialog(null, "비밀번호를 정확히 다시 써 주세요.");
						txtPassword1.setText("");
						txtPassword2.setText("");
						txtPassword1.requestFocus();
					}
					
					if(txtUsername.getText() != null && !txtUsername.getText().trim().isEmpty() &&
							txtUserid.getText() != null && !txtUserid.getText().trim().isEmpty() &&
							txtPassword1.getText() != null && !txtPassword1.getText().trim().isEmpty() &&
							txtUserEmail.getText() != null && !txtUserEmail.getText().trim().isEmpty() &&
							txtPwdAnswer.getText() != null && !txtPwdAnswer.getText().trim().isEmpty()) {
								
						// 필수입력 사항이 정상적으로 입력되었을 때만, 아래 코드를 실행.
						MemberVO mVo = new MemberVO();
						mVo.setName(txtUsername.getText());
						mVo.setUserid(txtUserid.getText());
						mVo.setUserpwd(txtPassword1.getText());
						mVo.setAddress(txtUserAddress.getText());
						mVo.setEmail(txtUserEmail.getText());
						mVo.setPwdq(jcb.getSelectedIndex());
						mVo.setPwda(txtPwdAnswer.getText());
						
						controller.join(mVo, txtUserid, txtUserEmail);					
					} 
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
				}
			}
		});
		btnJoin.setBounds(41, 425, 310, 31);
		contentPane.add(btnJoin);
		
		
		//cancel = new JButton("취소");
		cancel = new RoundedButton("취소");
		cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		cancel.setBackground(new Color(255, 204, 0));
		cancel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
					// 화면에 입력된 내용을 모두 초기화 시키는 버튼
				txtUsername.setText("");
				txtUserid.setText("");
				txtPassword1.setText("");
				txtPassword2.setText("");
				txtUserAddress.setText("");
				txtUserEmail.setText("");
				txtUsername.requestFocus();
					
			}
		});
		
		cancel.setBounds(41, 460, 310, 31);
		contentPane.add(cancel);
		
	
		Font f1 = new Font("바탕", Font.ITALIC, 12);
        hyperlink.setFont(f1);
		hyperlink.setForeground(UIManager.getColor("Button.darkShadow"));
		//hyperlink.setFont(new Font("바탕", Font.PLAIN, 12));
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	
                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
                	hyperlink.setText(text);
                	LoginView lgview = new LoginView();
                    /*lgview.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    lgview.setUndecorated(false);*/
                    dispose();
                    //view.setVisible(false);            
                    lgview.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText(text);
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + text + "</a></html>");
            }
 
        });
        
        hyperlink.setBounds(235, 496, 150, 25);
        //setLayout(new FlowLayout());
        contentPane.add(hyperlink);
        
       
		
		
	}
}
