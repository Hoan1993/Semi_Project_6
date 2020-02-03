package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LoginController;
import util.RoundedButton;

import javax.swing.Icon;
import javax.swing.UIManager;

public class LoginView extends JFrame {
	private static LoginView view = new LoginView();
	
    private static final long serialVersionUID = 3566038652320101414L;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblErrorMessage;
    
    private String text1 = "아이디 찾기";
    private JLabel hyperlink1 = new JLabel(text1);
    
    private String text2 = "암호 찾기";
    private JLabel hyperlink2 = new JLabel(text2);

    public LoginView() {
    	
    	setFont(new Font("바탕", Font.PLAIN, 12));	
    	getContentPane().setBackground(Color.WHITE);
        setTitle("가만안둬조");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*setExtendedState(JFrame.MAXIMIZED_BOTH); */
        setUndecorated(false);
        
        setBounds(0, 0, 410, 600);
        setLocationRelativeTo(null);
        Container contentPane = this.getContentPane();
        
        
        //ImageIcon icon = new ImageIcon("image\\Login.png");
        /*Image im = icon.getImage();
        Image im2 = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(im2);*/
        getContentPane().setLayout(null);
       
        JLabel img = new JLabel(new ImageIcon("C:\\NCS\\Semi_Project\\Semi_Project_Login&Register\\image\\Login.png"));
        img.setBounds(26, 15, 338, 351);
        img.setBackground(Color.WHITE);                             // 라벨 배경색 지정
        contentPane.add(img);

        txtUsername = new JTextField("아이디");       
        txtUsername.setForeground(Color.gray);
        txtUsername.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().isEmpty()) {
					txtUsername.setForeground(Color.gray);
					txtUsername.setText("아이디");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("아이디")) {
					txtUsername.setForeground(Color.black);
					txtUsername.setText("");
				}
				
			}
		});
        txtUsername.setBounds(41, 333, 310, 30);
        contentPane.add(txtUsername);

        txtPassword = new JPasswordField("비밀번호");
        txtPassword.setForeground(Color.gray);
        txtPassword.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(new String(txtPassword.getPassword()).isEmpty()) {
					txtPassword.setForeground(Color.gray);
					txtPassword.setText("비밀번호");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(new String(txtPassword.getPassword()).equals("비밀번호")) {
					txtPassword.setForeground(Color.black);
					txtPassword.setText("");
				}
				
			}
		});
        txtPassword.setBounds(41, 368, 310, 30);
        contentPane.add(txtPassword);

        // 로그인 버튼
        LoginController controller = new LoginController(this);
        btnLogin = new RoundedButton("로그인");
        btnLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnLogin.setBounds(41, 414, 310, 31);
        btnLogin.setBackground(new Color(255, 204, 0));
        btnLogin.setFocusable(true);
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.checkCredentials(txtUsername.getText(), new String(txtPassword.getPassword()));
            }
        });
        contentPane.add(btnLogin);
        
        
        JButton btnJoin= new RoundedButton("회원가입");
        btnJoin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnJoin.setBounds(41, 450, 310, 31);
        btnJoin.setBackground(new Color(255, 204, 0));
       /* btnJoin.addActionListener(new ActionListener());*/
        btnJoin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	JoinView join = new JoinView();
            	dispose();
    			//view.setVisible(false);
    			join.setVisible(true);	
            }
        });
        contentPane.add(btnJoin);
        
        
        // 아이디 찾기 하이퍼링크
        Font f1 = new Font("바탕", Font.ITALIC, 12);
        //hyperlink1.setForeground(Color.BLUE.darker());
		hyperlink1.setBounds(225, 486, 80, 25);
		hyperlink1.setForeground(UIManager.getColor("Button.darkShadow"));
		hyperlink1.setFont(f1);
        hyperlink1.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink1.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	
                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
                	hyperlink1.setText(text1);
                	FindIdView view = new FindIdView();
                	/*view.setExtendedState(JFrame.MAXIMIZED_BOTH);*/
                    view.setUndecorated(false);
                    dispose();
                    //view.setVisible(false);            
                    view.setVisible(true);
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
        contentPane.add(hyperlink1);
        
        
        // 암호 찾기.
        Font f2 = new Font("바탕", Font.ITALIC, 12);
        hyperlink2.setFont(f2);
        /*hyperlink2.setForeground(Color.BLUE.darker());*/
		hyperlink2.setBounds(295, 486, 80, 25);
		hyperlink2.setForeground(UIManager.getColor("Button.darkShadow"));
		//hyperlink2.setFont(new Font("바탕", Font.PLAIN, 12));
		
        hyperlink2.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink2.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	
                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
                	hyperlink2.setText(text2);
                	FindPwdView view = new FindPwdView();
                    /*view.setExtendedState(JFrame.MAXIMIZED_BOTH);*/
                    view.setUndecorated(false);
                    dispose();
                    
                    //view.setVisible(false);            
                    view.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink2.setText(text2);
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink2.setText("<html><a href=''>" + text2 + "</a></html>");
            }
 
        });
        //setLayout(new FlowLayout());
        contentPane.add(hyperlink2);
        
        lblErrorMessage = new JLabel("");
        lblErrorMessage.setBounds(12, 385, 330, 25);
        lblErrorMessage.setHorizontalAlignment(SwingConstants.RIGHT);
        lblErrorMessage.setForeground(Color.RED);
        lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblErrorMessage);
    }
    
/*    class JoinListener implements ActionListener {
    	   	
		@Override
		public void actionPerformed(ActionEvent e) {
			JoinView join = new JoinView();
			view.setVisible(false);
			join.setVisible(true);	
				
		}
    }*/
    
    public void setErrorMessage(String errorMessage) {
        lblErrorMessage.setText(errorMessage);
    }
}