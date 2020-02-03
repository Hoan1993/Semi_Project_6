package controller;

import javax.swing.JFrame;

import model.Food_VO;
import model.MemberDAO;
import model.MemberVO;
import view.JoinView;
import view.LoginView;
import view.Main_View;

public class LoginController {

    private LoginView view;
    private MemberDAO model;

    public LoginController(LoginView view){
        this.view = view;
        model = MemberDAO.getInstance();
    }

    public void checkCredentials(String userid, String userpwd){

    	int result = model.loginProcess(userid, userpwd);
        if(result == 1){
            view.setErrorMessage("Login Success!");
            // 여기서 main으로 이동해야 함. 
            MemberVO mVo = new MemberVO();
            
            mVo = model.allInfo(userid);
            Food_VO fVo = new Food_VO();
            Main_View toMain = new Main_View(mVo, fVo);
          /*  toMain.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            toMain.setUndecorated(false);*/
            view.setVisible(false);
            toMain.setVisible(true);
            
        }
        else if(result == 0){
            view.setErrorMessage("Login Failed");
        } 
        else  {
        	 view.setErrorMessage("Login Failed");
        }
    }

	public void joinMember() {
		JoinView join = new JoinView();
        
        view.setVisible(false);
        join.setVisible(true);
		
	}
	
}
