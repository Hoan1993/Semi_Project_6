package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.MemberDAO;
import model.MemberVO;
import view.JoinView;
import view.LoginView;

public class JoinController {
	private JoinView view;
	private MemberDAO model;

	public JoinController(JoinView joinView) {
		this.view = joinView;

		model = MemberDAO.getInstance();

	}

	public void useridCheck(String userid, JTextField txtUserid) {
		int result = model.idCheck(userid);

		if (result == 1) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
			txtUserid.setText("");
			txtUserid.requestFocus();
		} else if (userid == null || userid.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "아이디를 입력하지 않으셨습니다.");
			txtUserid.setText("");
			txtUserid.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
		}

	}

	public void join(MemberVO mVo, JTextField txtUserid, JTextField txtUserEmail) {
		int result = model.insertMember(mVo);
		if (result == 1) {
			JOptionPane.showMessageDialog(null, "회원가입을 축하합니다.");
			LoginView lgview = new LoginView();
		/*	lgview.setExtendedState(JFrame.MAXIMIZED_BOTH);
			lgview.setUndecorated(false);*/
			view.dispose();
			// view.setVisible(false);
			lgview.setVisible(true);
		} else if (result == 0) {
			if (model.idCheck(mVo.getUserid()) == 1) {
				JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다. 다른 아이디를 쓰세요.");
				txtUserid.setText("");
				txtUserid.requestFocus();
			} else {
				JOptionPane.showMessageDialog(null, "이미 사용중인 이메일입니다. 다른 이메일을 쓰세요.");
				txtUserEmail.setText("");
				txtUserEmail.requestFocus();
			}
			/* view.setVisible(true); */
		} else {
			JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다. ");
//			view.setVisible(true);
		}
	}

}