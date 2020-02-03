package controller;

import javax.swing.JOptionPane;

import model.MemberDAO;
import view.FindIdView;
import view.LoginView;


public class FindIdController {
	private FindIdView view;
    private MemberDAO model;

    String[] buttons = {"확인"};

    
    public FindIdController(FindIdView findidView){
        this.view = findidView;

        model = MemberDAO.getInstance();
        
    }

	public void findId(String name, String email) {
		String result = model.findUserid(email);
		// 이메일이 있는 것. 따라서 이 이메일로 id를 보내야 한다. result에 아이디가 들어있다. 
		if(result != null) { 
			//JOptionPane.showMessageDialog(null, "등록하신 메일로 아이디를 보내 드렸습니다.");
			JOptionPane.showMessageDialog(null, "아이디는 "+result+"입니다.");
			// 여기서는 로그인 창으로 이동해야 한다.
			view.dispose();
			LoginView lgview = new LoginView();
			lgview.setVisible(true);
		} else {
			// 굳이 회원가입 창으로 자동 이동하게 할 필요는 없음.
			// 그냥 계속 시도하게 함.
			/*JOptionPane.showMessageDialog(null, "회원가입이 되어 있지 않습니다.");*/
			
			
			JOptionPane.showOptionDialog( null, "회원가입이 되어 있지 않습니다.",
					"어림도 없지", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					buttons,"확인");

			
		}
		
	}
    
    
}
