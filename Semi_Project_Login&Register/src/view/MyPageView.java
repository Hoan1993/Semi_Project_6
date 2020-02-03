package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.JoinController;
import model.Food_VO;
import model.MemberVO;
import util.RoundedButton;

public class MyPageView extends JFrame {
	
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
	    
	    private String text = "메인 화면으로 이동";
	    private JLabel hyperlink = new JLabel(text);
	    
	    public MyPageView() {
	    	
	    	
	    }
	    
	    
	    public MyPageView(MemberVO mVo) {
	        setTitle("마이 페이지");
	        setResizable(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        getContentPane().setBackground(Color.WHITE);
	        setBounds(0, 0, 410, 600);
	        setLocationRelativeTo(null);
	     /*   setExtendedState(JFrame.MAXIMIZED_BOTH); 
	        setUndecorated(false);*/
	        
	        Container contentPane = this.getContentPane();
	        contentPane.setLayout(null);
	        
	        JLabel img = new JLabel(new ImageIcon("C:\\NCS\\Semi_Project\\Semi_Project_Login&Register\\image\\Update.png"));
	        img.setBounds(28, -21, 338, 351);
	        img.setBackground(Color.WHITE);                             // 라벨 배경색 지정
	        contentPane.add(img);
	        	     
	        JLabel lblUsername = new JLabel("이름  ");
	        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUsername.setBounds(10, 311, 120, 25);
	        contentPane.add(lblUsername);
	        
	        JLabel lblUsername_1 = new JLabel();
	        lblUsername_1.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUsername_1.setBounds(115, 313, 200, 25);
	        lblUsername_1.setText(mVo.getName());
	        contentPane.add(lblUsername_1);
	        
	       /* txtUsername = new JTextField();
	        txtUsername.setBounds(140, 311, 200, 25);
	        txtUsername.setText(mVo.getName());
	        txtUsername.setEditable(false);
	        contentPane.add(txtUsername);*/

	        JLabel lblUserid = new JLabel("아이디  ");
	        lblUserid.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUserid.setBounds(10, 352, 120, 25);
	        contentPane.add(lblUserid);
	        
	        JLabel lblUserid_1 = new JLabel();
	        lblUserid_1.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUserid_1.setBounds(115, 354, 200, 25);
	        lblUserid_1.setText(mVo.getUserid());
	        contentPane.add(lblUserid_1);
	   
	/*        txtUserid = new JTextField();
	        txtUserid.setBounds(140, 352, 200, 25);
	        txtUserid.setText(mVo.getUserid());
	        txtUserid.setEditable(false);
	        contentPane.add(txtUserid);*/
	        	        
	        JLabel lblAddress = new JLabel("주소  ");
	        lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblAddress.setBounds(10, 393, 120, 25);
	        contentPane.add(lblAddress);
	        
	        JLabel lblAddress_1 = new JLabel();
	        lblAddress_1.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblAddress_1.setBounds(115, 395, 200, 25);
	        lblAddress_1.setText(mVo.getAddress());
	        contentPane.add(lblAddress_1);
	        
	      /*  txtUserAddress = new JTextField();
	        txtUserAddress.setBounds(140, 393, 200, 25);
	        txtUserAddress.setText(mVo.getAddress());
	        txtUserAddress.setEditable(false);
	        contentPane.add(txtUserAddress);*/
	        	        
	        JLabel lblUserEmail = new JLabel("이메일  ");
	        lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUserEmail.setBounds(10, 434, 120, 25);
	        contentPane.add(lblUserEmail);
	        
	        JLabel lblUserEmail_1 = new JLabel();
	        lblUserEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUserEmail_1.setBounds(115, 436, 200, 25);
	        lblUserEmail_1.setText(mVo.getEmail());
	        contentPane.add(lblUserEmail_1);
	        
	/*        txtUserEmail = new JTextField();
	        txtUserEmail.setBounds(140, 434, 200, 25);
	        txtUserEmail.setText(mVo.getEmail());
	        txtUserEmail.setEditable(false);
	        contentPane.add(txtUserEmail);*/
	        
	        // 비밀번호 확인 질문.
	        
		
		//btnJoin = new JButton("정보변경");
		btnJoin = new RoundedButton("정보변경");
		btnJoin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnJoin.setBackground(new Color(255, 204, 0));
		btnJoin.setFocusable(true);
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					dispose();
					UpdateSecurityCheckView view = new UpdateSecurityCheckView(mVo);
					//UpdateMemberView updateView = new UpdateMemberView(mVo);
					view.setVisible(true);
				
			}
		});
		btnJoin.setBounds(42, 475, 310, 31);
		contentPane.add(btnJoin);
				
		Font f1 = new Font("바탕", Font.ITALIC, 12);
		//hyperlink.setForeground(Color.BLUE.darker());
		hyperlink.setForeground(UIManager.getColor("Button.darkShadow"));
		hyperlink.setFont(f1);
		hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

		hyperlink.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
             try {
             	
                /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
             	hyperlink.setText(text);
             	
             	 Food_VO fVo = new Food_VO();
             	 Main_View view = new Main_View(mVo, fVo);
                 /*view.setExtendedState(JFrame.MAXIMIZED_BOTH);
                 view.setUndecorated(false);*/
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
     
     hyperlink.setBounds(240, 500, 150, 50);
     //setLayout(new FlowLayout());
     contentPane.add(hyperlink);
		
		
		
	}
}