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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.JoinController;
import controller.UpdateMemberController;
import model.Food_VO;
import model.MemberVO;
import util.RoundedButton;

import javax.swing.UIManager;

public class UpdateMemberView extends JFrame{
	
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
    // userid를 가져왔다.
    public UpdateMemberView(MemberVO mVo) {
    	getContentPane().setFont(new Font("Calibri", Font.PLAIN, 12));
    	getContentPane().setBackground(Color.WHITE);
    	 	
        setTitle("회원정보변경 페이지");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        /*setExtendedState(JFrame.MAXIMIZED_BOTH); */
        setUndecorated(false);
        
        Container contentPane = this.getContentPane();     
        setBounds(0, 0, 410, 600);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);
        
        /*ImageIcon icon = new ImageIcon("C:\\\\NCS\\\\Semi_Project\\\\Semi_Project_Login&Register\\\\image\\\\Update.png");*/
        /*Image im = icon.getImage();
        Image im2 = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(im2);*/
        getContentPane().setLayout(null);
        JLabel img = new JLabel(new ImageIcon("C:\\NCS\\Semi_Project\\Semi_Project_Login&Register\\image\\Update.png"));
        img.setBounds(11, 8, 375, 205);
        img.setBackground(Color.WHITE);                             // 라벨 배경색 지정
        contentPane.add(img);
        
        	     
        /*JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setBounds(16, 221, 120, 25);
        contentPane.add(lblUsername);*/

        txtUsername = new JTextField();
        txtUsername.setBounds(41, 221, 310, 25);
        txtUsername.setText(mVo.getName());
        txtUsername.setEditable(false);
        contentPane.add(txtUsername);

       /* JLabel lblUserid = new JLabel("Userid :");
        lblUserid.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblUserid.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUserid.setBounds(16, 256, 120, 25);
        contentPane.add(lblUserid);*/
        
   
        txtUserid = new JTextField();
        txtUserid.setBounds(41, 256, 310, 25);
        txtUserid.setText(mVo.getUserid());
        txtUserid.setEditable(false);
        contentPane.add(txtUserid);
                
       /* JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setBounds(16, 291, 120, 25);
        contentPane.add(lblPassword);*/
        
        txtPassword1 = new JPasswordField("비밀번호");
        txtPassword1.setForeground(Color.gray);
        txtPassword1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(new String(txtPassword1.getText()).isEmpty()) {
					txtPassword1.setForeground(Color.gray);
					txtPassword1.setText("비밀번호");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(new String(txtPassword1.getText()).equals("비밀번호")) {
					txtPassword1.setForeground(Color.black);
					txtPassword1.setText("");
				}
				
			}
		});
        txtPassword1.setBounds(41, 291, 310, 25);
        contentPane.add(txtPassword1);
        
      /*  JLabel lblPassword2 = new JLabel("PWDCheck:");
        lblPassword2.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblPassword2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword2.setBounds(16, 326, 120, 25);
        contentPane.add(lblPassword2);*/
        
        txtPassword2 = new JPasswordField("비밀번호");
        txtPassword2.setForeground(Color.gray);
        txtPassword2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(new String(txtPassword2.getText()).isEmpty()) {
					txtPassword2.setForeground(Color.gray);
					txtPassword2.setText("비밀번호");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(new String(txtPassword2.getText()).equals("비밀번호")) {
					txtPassword2.setForeground(Color.black);
					txtPassword2.setText("");
				}
				
			}
		});
        txtPassword2.setBounds(41, 326, 310, 25);
        contentPane.add(txtPassword2);
        
  /*      JLabel lblAddress = new JLabel("Address :");
        lblAddress.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAddress.setBounds(16, 361, 120, 25);
        contentPane.add(lblAddress);*/
        
        txtUserAddress = new JTextField(mVo.getAddress());
        txtUserAddress.setForeground(Color.gray);
        txtUserAddress.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserAddress.getText().isEmpty()) {
					txtUserAddress.setForeground(Color.gray);
					txtUserAddress.setText(mVo.getAddress());
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUserAddress.getText().equals(mVo.getAddress())) {
					txtUserAddress.setForeground(Color.black);
					txtUserAddress.setText("");
				}
				
			}
		});
        txtUserAddress.setBounds(41, 361, 310, 25);
        /*txtUserAddress.setText(mVo.getAddress());*/
        contentPane.add(txtUserAddress);
        	        
   /*     JLabel lblUserEmail = new JLabel("Email :");
        lblUserEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUserEmail.setBounds(16, 396, 120, 25);
        contentPane.add(lblUserEmail);*/
        
        txtUserEmail = new JTextField(mVo.getEmail());
        txtUserEmail.setForeground(Color.gray);
        txtUserEmail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserEmail.getText().isEmpty()) {
					txtUserEmail.setForeground(Color.gray);
					txtUserEmail.setText(mVo.getEmail());
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUserEmail.getText().equals(mVo.getEmail())) {
					txtUserEmail.setForeground(Color.black);
					txtUserEmail.setText("");
				}
				
			}
		});
        txtUserEmail.setBounds(41, 396, 310, 25);
        /*txtUserEmail.setText(mVo.getEmail());*/
        contentPane.add(txtUserEmail);
        
        
    UpdateMemberController controller = new UpdateMemberController(this);   
	//btnJoin = new JButton("정보변경");
	btnJoin = new RoundedButton("정보변경");
	btnJoin.setFont(new Font("바탕", Font.PLAIN, 14));
	btnJoin.setBackground(new Color(255, 204, 0));
	btnJoin.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				// 유효성 검사를 해 주는 길고 긴 코드. null 값이나 공백이 들어갔는지 확인.
				// 여기서 su1.requestFocus(); 이걸 써서 입력하지 않은걸 입력받을 것임.
			
		
				
				if(txtPassword1.getText() == null || txtPassword1.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호는 필수 입력 사항입니다.");	
					txtPassword1.requestFocus();
				}
				else if(txtPassword2.getText() == null || txtPassword2.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인은 필수 입력 사항입니다.");	
					txtPassword2.requestFocus();				
				}  else if(txtUserAddress.getText() == null || txtUserAddress.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "주소를 입력해주세요.");	
					txtUserAddress.requestFocus();
				} 	else if(txtUserEmail.getText() == null || txtUserEmail.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "이메일은 필수 입력 사항입니다.");	
					txtUserEmail.requestFocus();
				} 
				
				if(!txtPassword1.getText().equals(txtPassword2.getText())) {
					JOptionPane.showMessageDialog(null, "비밀번호를 정확히 다시 써 주세요.");
					txtPassword1.setText("");
					txtPassword2.setText("");
					txtPassword1.requestFocus();
				}
				
				if(		txtPassword1.getText() != null && !txtPassword1.getText().trim().isEmpty() &&
						txtUserEmail.getText() != null && !txtUserEmail.getText().trim().isEmpty() &&
						txtUserAddress.getText() != null && !txtUserAddress.getText().trim().isEmpty()) {
							
					// 필수입력 사항이 정상적으로 입력되었을 때만, 아래 코드를 실행.
					MemberVO mVoc = new MemberVO();
					mVoc.setName(mVo.getName());
					mVoc.setUserid(mVo.getUserid());
					mVoc.setUserpwd(txtPassword1.getText());
					mVoc.setAddress(txtUserAddress.getText());
					mVoc.setEmail(txtUserEmail.getText());
					mVoc.setPwdq(mVo.getPwdq());
					mVoc.setPwda(mVo.getPwda());
					
					controller.update(mVoc);					
				} 
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "회원정보변경에 실패하였습니다!!!");
			}
		}
	});
	btnJoin.setBounds(41, 445, 310, 31);
	contentPane.add(btnJoin);
	
	
	//cancel = new JButton("취소");
	cancel = new RoundedButton("취소");
	cancel.setFont(new Font("바탕", Font.PLAIN, 14));
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
	
	cancel.setBounds(41, 480, 310, 31);
	contentPane.add(cancel);
	
	
	Font f1 = new Font("바탕", Font.ITALIC, 12);
	hyperlink.setFont(f1);
	hyperlink.setForeground(UIManager.getColor("Button.darkShadow"));
	//hyperlink.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

    hyperlink.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
            	
               /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
            	hyperlink.setText(text);
            	
            	Food_VO fVo = new Food_VO();
            	Main_View view = new Main_View(mVo, fVo);
               /* view.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
    
    hyperlink.setBounds(235, 502, 150, 50);
    //setLayout(new FlowLayout());
    contentPane.add(hyperlink);
	
	
	
}
}