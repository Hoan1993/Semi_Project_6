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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.FindIdController;
import util.RoundedButton;

import javax.swing.UIManager;


public class FindIdView extends JFrame{

	
    private static final long serialVersionUID = 3566038652320101414L;
    private JTextField txtUsername;
    private JTextField txtUserEmail;
    private JButton btnLogin;
    
    private String text = "로그인 화면으로 이동";
    private JLabel hyperlink = new JLabel(text);

    public FindIdView() {
    	getContentPane().setBackground(new Color(255, 255, 255));
        setTitle("아이디 찾기");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*setExtendedState(JFrame.MAXIMIZED_BOTH); */
        setBounds(0, 0, 410, 600);
        setUndecorated(false);
        
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
        
        

        /*JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setBounds(-11, 286, 120, 25);
        contentPane.add(lblUsername);*/
        
        JLabel lblUsername = new JLabel("<이름과 이메일>");
        //lblUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblUsername.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
        lblUsername.setBounds(41, 282, 80, 50);
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
        
        txtUsername.setBounds(41, 316, 310, 30);
        contentPane.add(txtUsername);

  /*      JLabel lblUserEmail = new JLabel("Email:");
        lblUserEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUserEmail.setBounds(-11, 319, 120, 25);
        contentPane.add(lblUserEmail);*/

        txtUserEmail = new JTextField();
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
        txtUserEmail.setBounds(41, 353, 310, 30);
        contentPane.add(txtUserEmail);

        // 아이디 찾기
        FindIdController controller = new FindIdController(this);
        btnLogin = new RoundedButton("아이디찾기");
        btnLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnLogin.setBackground(new Color(255, 204, 0));
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
               controller.findId(txtUsername.getText(), txtUserEmail.getText());
            }
        });
        btnLogin.setBounds(41, 415, 310, 31);
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
                    //view.setVisible(false);            
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
        
        hyperlink.setBounds(235, 445, 330, 25);
        contentPane.add(hyperlink);
      
    }
    
}
    
