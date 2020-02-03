package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Food_VO;
import model.MemberDAO;
import model.MemberVO;
import view.Main_View;
import view.UpdateMemberView;
import view.UpdateSecurityCheckView;

public class UpdateMemberController {

	private static UpdateMemberView view;
    private MemberDAO model;

    public UpdateMemberController() {

	}
    
    public UpdateMemberController(UpdateMemberView view){
        this.view = view;
        model = MemberDAO.getInstance();
    }
	
	
	public void update(MemberVO mVo) {
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result =mDao.updateMember(mVo);
		
		if(result == 1) {
			JOptionPane.showMessageDialog(null, "회원 정보 변경 성공");
		     	
	            view.dispose();
	            Food_VO fVo = new Food_VO();
	            Main_View mView = new Main_View(mVo, fVo);
//	            mView.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//	            mView.setUndecorated(false);
	            //view.setVisible(false);
	            mView.setVisible(true);
			
		} else {
			JOptionPane.showMessageDialog(null, "회원 정보 변경 실패");
			JOptionPane.showMessageDialog(null, mVo.getName()+","+mVo.getUserid()+","+
			mVo.getUserpwd()+","+mVo.getAddress()+","+mVo.getEmail());
		}
		
		
		
	}
	
}
