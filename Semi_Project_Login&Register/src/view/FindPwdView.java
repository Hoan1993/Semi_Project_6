package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.FindPwdController;
import util.RoundedButton;

import javax.swing.UIManager;

public class FindPwdView extends JFrame {
	//private static FindPwdView view = new FindPwdView();
	
    private static final long serialVersionUID = 3566038652320101414L;
    private JTextField txtUserid;
    private JTextField txtPwdAnswer;
    private JButton btnLogin;
    
    private String text = "로그인 화면으로 이동";
    private JLabel hyperlink = new JLabel(text);

    public FindPwdView() {
    	getContentPane().setBackground(Color.WHITE);
        setTitle("비밀번호 찾기");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*setExtendedState(JFrame.MAXIMIZED_BOTH); */
        setUndecorated(false);
        setBounds(0, 0, 410, 600);
        
        setLocationRelativeTo(null);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        
        ImageIcon icon = new ImageIcon("C:\\\\NCS\\\\Semi_Project\\\\Semi_Project_Login&Register\\\\image\\\\id,pwd.png");
        /*Image im = icon.getImage();
        Image im2 = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(im2);*/
        getContentPane().setLayout(null);
        JLabel img = new JLabel(new ImageIcon("C:\\NCS\\Semi_Project\\Semi_Project_Login&Register\\image\\id,pwd.png"));
        img.setBounds(11, 30, 375, 205);
        img.setBackground(Color.WHITE);                             // 라벨 배경색 지정
        contentPane.add(img);
        

        JLabel lblUsername = new JLabel("<아이디, 비밀번호 확인 질문, 답변>");
        lblUsername.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setBounds(26, 265, 180, 25);
        contentPane.add(lblUsername);

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
        txtUserid.setBounds(41, 286, 310, 30);
        contentPane.add(txtUserid);
        
     // 비밀번호 확인 질문.
        /*JLabel lblPwdQ = new JLabel("비밀번호 질문 :");
        lblPwdQ.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblPwdQ.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPwdQ.setBounds(-11, 321, 120, 25);
        contentPane.add(lblPwdQ);*/
        
        // 콤보 박스
        String [] job = {"기억에 남는 추억의 장소는?", 
        		"자신의 인생 좌우명은?", "자신의 보물 제1호는?", 
        		"가장 기억에 남는 선생님 성함은?", "타인이 모르는 자신만의 신체비밀이 있다면?",
        		"추억하고 싶은 날짜가 있다면?", "받았던 선물 중 기억에 남는 독특한 선물은?",
        		"유년시설 가장 생각나는 친구 이름은?", "인상 깊게 읽은 책 이름은?"};
        
        JComboBox<String> jcb = new JComboBox<>(job);
        jcb.setBackground(new Color(255, 255, 204));
        jcb.setFont(new Font("바탕", Font.PLAIN, 12));
        jcb.setBounds(41, 321, 310, 30);
        getContentPane().add(jcb);
        jcb.setSelectedIndex(2);
        

        /*String [] job = {"기억에 남는 추억의 장소는?", 
        		"자신의 인생 좌우명은?", "자신의 보물 제1호는?", 
        		"가장 기억에 남는 선생님 성함은?", "타인이 모르는 자신만의 신체비밀이 있다면?",
        		"추억하고 싶은 날짜가 있다면?", "받았던 선물 중 기억에 남는 독특한 선물은?",
        		"유년시설 가장 생각나는 친구 이름은?", "인상 깊게 읽은 책 이름은?"};
        
		JComboBox<String> jcb = new JComboBox<>(job);
        //pwdCombo = new JComboBox();
		jcb.setBounds(117, 303, 200, 25);
		contentPane.add(jcb);

		jcb.setSelectedIndex(1);
		*/
		// 비밀번호 확인 답변
		/*JLabel lblPwdAnswer = new JLabel("비밀번호 답변 :");
		lblPwdAnswer.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblPwdAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPwdAnswer.setBounds(-11, 356, 120, 25);
        contentPane.add(lblPwdAnswer);*/
        
        txtPwdAnswer = new JTextField("비밀번호확인답변");
        txtPwdAnswer.setForeground(Color.gray);
        txtPwdAnswer.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPwdAnswer.getText().isEmpty()) {
					txtPwdAnswer.setForeground(Color.gray);
					txtPwdAnswer.setText("비밀번호확인답변");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPwdAnswer.getText().equals("비밀번호확인답변")) {
					txtPwdAnswer.setForeground(Color.black);
					txtPwdAnswer.setText("");
				}
				
			}
		});
        txtPwdAnswer.setBounds(41, 356, 310, 30);
        contentPane.add(txtPwdAnswer);
        
       
        // 비밀번호 찾기
        FindPwdController controller = new FindPwdController(this);
        btnLogin = new RoundedButton("비밀번호찾기");
        btnLogin.setBackground(new Color(255, 204, 0));
        btnLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
               controller.findPwd(txtUserid.getText(), jcb.getSelectedIndex(), txtPwdAnswer.getText());
            }
        });
        btnLogin.setBounds(41, 445, 310, 31);
        contentPane.add(btnLogin);
        
        Font f2 = new Font("바탕", Font.ITALIC, 12);
        hyperlink.setFont(f2);
		hyperlink.setForeground(UIManager.getColor("Button.darkShadow"));
		//hyperlink.setFont(new Font("바탕", Font.PLAIN, 12));
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {              
                	hyperlink.setText(text);
                	LoginView view = new LoginView();
                    /*view.setExtendedState(JFrame.MAXIMIZED_BOTH);*/
                    view.setUndecorated(false);
                    dispose();         
                    view.setVisible(true);
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
        
        hyperlink.setBounds(235, 480, 330, 25);
        contentPane.add(hyperlink);
        
        
        
    }
    
}