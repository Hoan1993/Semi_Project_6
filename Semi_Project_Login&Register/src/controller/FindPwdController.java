package controller;

import java.util.Random;

import javax.swing.JOptionPane;

import model.MemberDAO;
import util.SendEmail;
import view.FindPwdView;
import view.LoginView;

public class FindPwdController {
	
	private FindPwdView view;
    private MemberDAO model;

    public FindPwdController(FindPwdView findPwdView){
        this.view = findPwdView;
        model = MemberDAO.getInstance();
        
    }
    // 패스워드
	public void findPwd(String userid, int pwdq, String pwda) {
		String result = model.findUserpwd(userid, pwdq, pwda);
		result = RandomPwd();
		model.updateRandomPWD(result, userid);
		String email = model.toSendEmail(userid);
		String name = model.findName(userid);
		// 이메일이 있는 것. 따라서 이 이메일로 id를 보내야 한다. result에 아이디가 들어있다. 
		if(result != null) { 
			//JOptionPane.showMessageDialog(null, "등록하신 메일로 아이디를 보내 드렸습니다.");
			JOptionPane.showMessageDialog(null, "등록하신 메일로 임시 비밀번호를 보내드렸습니다. 로그인 후 회원정보를 변경해주세요.");
			// 이메일로 보내기
			SendEmail send = new SendEmail();
			send.sendEmail(name, email, result);
			
			// 여기서는 로그인 창으로 이동해야 한다.
			view.dispose();
			LoginView lgview = new LoginView();
			lgview.setVisible(true);
		} else {
			// 굳이 회원가입 창으로 자동 이동하게 할 필요는 없음.
			// 그냥 계속 시도하게 함.
			JOptionPane.showMessageDialog(null, "비밀번호를 찾는데 성공하지 못 했습니다.");
			
		}
		
	}
	private String RandomPwd() {
		String result = null;
		Random rnd =new Random();
		StringBuffer buf =new StringBuffer();
		for(int i=0;i<20;i++){

		    // rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.

		    if(rnd.nextBoolean()){

		        buf.append((char)((int)(rnd.nextInt(26))+97));

		    }else{

		        buf.append((rnd.nextInt(10)));

		    }

		}
		result = buf.toString();
		
		return result;
	}
    
    
}
