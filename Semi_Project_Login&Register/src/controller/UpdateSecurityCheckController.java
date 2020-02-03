package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.MemberDAO;
import model.MemberVO;
import view.JoinView;
import view.LoginView;
import view.Main_View;
import view.UpdateMemberView;
import view.UpdateSecurityCheckView;

public class UpdateSecurityCheckController {

    private static UpdateSecurityCheckView view;
    private MemberDAO model;

    public UpdateSecurityCheckController(UpdateSecurityCheckView view){
        this.view = view;
        model = MemberDAO.getInstance();
    }

    public void checkCredentials(String userid, String userpwd, MemberVO mVo){

        if(mVo.getUserid().equals(userid) && mVo.getUserpwd().equals(userpwd)){
            //view.setErrorMessage("Login Success!");
            // 여기서 main으로 이동해야 함. 
            //MemberVO mVo = new MemberVO();
            
            //mVo = model.allInfo(userid);
            UpdateMemberView updateView = new UpdateMemberView(mVo);
            view.dispose();
            /*updateView.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            updateView.setUndecorated(false);*/
            //view.setVisible(false);
            
            updateView.setVisible(true);
            
        }
        else {
            JOptionPane.showMessageDialog(null, "회원정보변경 권한 획득에 실패했습니다.");
        } 
  
    }


	
}
	

