package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.Food_VO;
import model.MemberVO;

import javax.swing.JTextArea;

public class DetailViewForSC2 extends JFrame{
	
	private String text1 = "스케쥴러로 돌아가기?";
    private JLabel hyperlink1 = new JLabel(text1);
	
	public DetailViewForSC2(MemberVO mVo, Food_VO fVo) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("오늘은 이 메뉴");
		setBounds(100, 100, 687, 570);
		setLocationRelativeTo(null);
	
		getContentPane().setLayout(null);
		
		ImageIcon image = null;
		image = fVo.getIcon();
		
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(12, 10, 647, 322);
		getContentPane().add(lblNewLabel);
		
		JLabel store_name = new JLabel("");
		store_name.setText(fVo.getStore_name());
		store_name.setBounds(12, 342, 410, 15);
		getContentPane().add(store_name);
		
		JLabel food_name = new JLabel("");
		food_name.setText(fVo.getFood_name());
		food_name.setBounds(12, 367, 410, 15);
		getContentPane().add(food_name);
		
		JLabel price = new JLabel("");
		price.setText(String.valueOf(fVo.getPrice()));
		price.setBounds(12, 399, 410, 15);
		getContentPane().add(price);
		
		JLabel review = new JLabel("");
		review.setText(fVo.getReview());
		review.setBounds(12, 424, 647, 40);
		getContentPane().add(review);

		JLabel address = new JLabel("");
		address.setText(fVo.getAddress());
		address.setBounds(12, 474, 410, 15);
		getContentPane().add(address);

		Font f1 = new Font("바탕", Font.ITALIC, 12);
        hyperlink1.setFont(f1);
		//hyperlink1.setForeground(Color.BLUE.darker());
        hyperlink1.setForeground(UIManager.getColor("Button.darkShadow"));
		hyperlink1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		hyperlink1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					/* Desktop.getDesktop().browse(new URI("http://www.codejava.net")); */
					hyperlink1.setText(text1);
					//Main_View view = new Main_View(mVo, fVo);
					Button_Calandar app = new Button_Calandar(mVo);
					/*app.setVisible(true);*/
					dispose();
					// view.setVisible(false);
					//view.setVisible(true);
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

		hyperlink1.setBounds(500, 500, 150, 25);
		getContentPane().add(hyperlink1);
		
	}
}