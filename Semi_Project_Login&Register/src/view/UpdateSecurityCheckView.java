package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LoginController;
import controller.UpdateSecurityCheckController;
import model.Food_VO;
import model.MemberVO;
import util.RoundedButton;

import javax.swing.UIManager;
/*import view.LoginView.JoinListener;*/

public class UpdateSecurityCheckView extends JFrame{
	private static UpdateSecurityCheckView view;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblErrorMessage;
    
/*    private String text1 = "아이디 찾기";
    private JLabel hyperlink1 = new JLabel(text1);*/
    
    private String text2 = "메인화면으로 이동";
    private JLabel hyperlink2 = new JLabel(text2);

    public UpdateSecurityCheckView(MemberVO mVo) {
    	getContentPane().setBackground(Color.WHITE);
    	
        setTitle("권한 확인 페이지");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       /* setExtendedState(JFrame.MAXIMIZED_BOTH); */
//        setUndecorated(false);
        setBounds(0, 0, 410, 600);
        setLocationRelativeTo(null);
      /*  setBounds(0, 0, 410, 600);*/
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        
        /*ImageIcon icon = new ImageIcon("C:\\\\NCS\\\\Semi_Project\\\\Semi_Project_Login&Register\\\\image\\\\UpdateSC.png");*/
        /*Image im = icon.getImage();
        Image im2 = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(im2);*/
        getContentPane().setLayout(null);
        JLabel img = new JLabel(new ImageIcon("C:\\NCS\\Semi_Project\\Semi_Project_Login&Register\\image\\UpdateSC.png"));
        img.setBounds(9, 44, 375, 205);
        img.setBackground(Color.WHITE);                             // 라벨 배경색 지정
        contentPane.add(img);
        

        JLabel lblUsername = new JLabel("<아이디와 비밀번호>");
        lblUsername.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setBounds(20, 370, 120, 25);
        contentPane.add(lblUsername);

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
        txtUsername.setBounds(41, 393, 310, 30);
        contentPane.add(txtUsername);

        /*JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setBounds(-11, 323, 120, 25);
        contentPane.add(lblPassword);*/

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
        txtPassword.setBounds(41, 428, 310, 30);
        contentPane.add(txtPassword);

        // 로그인 버튼
        UpdateSecurityCheckController controller = new UpdateSecurityCheckController(this);
        //btnLogin = new JButton("본인확인");
        btnLogin = new RoundedButton("본인확인");
        btnLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnLogin.setBackground(new Color(255, 204, 0));
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	JOptionPane.showMessageDialog(null, mVo.getName()+"님 정보변경");
                controller.checkCredentials(txtUsername.getText(), new String(txtPassword.getPassword()), mVo);
            }
        });
        // 42, 475, 310, 30
        btnLogin.setBounds(41, 475, 310, 31);
        contentPane.add(btnLogin);
        
     
        // 메인창으로 돌아가기
        Font f2 = new Font("바탕", Font.ITALIC, 12);
        hyperlink2.setFont(f2);
		hyperlink2.setForeground(UIManager.getColor("Button.darkShadow"));
		//hyperlink2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        hyperlink2.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink2.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	
                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
                	hyperlink2.setText(text2);
                	Food_VO fVo = new Food_VO();
                	Main_View view = new Main_View(mVo, fVo);
                    /*view.setExtendedState(JFrame.MAXIMIZED_BOTH);*/
                	view.setLocationRelativeTo(null);
                    /*view.setUndecorated(false);*/
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
        
        hyperlink2.setBounds(235, 510, 100, 25);
        //setLayout(new FlowLayout());
        contentPane.add(hyperlink2);
        
       /* lblErrorMessage = new JLabel("");
        lblErrorMessage.setHorizontalAlignment(SwingConstants.RIGHT);
        lblErrorMessage.setForeground(Color.RED);
        lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblErrorMessage.setBounds(12, 410, 330, 25);
        contentPane.add(lblErrorMessage);*/
    }
}