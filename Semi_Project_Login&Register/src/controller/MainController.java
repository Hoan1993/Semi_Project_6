package controller;

import javax.swing.JOptionPane;

import model.Food_VO;
import model.MemberDAO;
import model.MemberVO;
import view.DetailView;
import view.DetailViewForSC2;
import view.LoginView;
import view.Main_View;

public class MainController {

    private Main_View view;
    private MemberDAO model;
    private Food_VO fVo;
    public MainController(Main_View view){
        this.view = view;
        model = MemberDAO.getInstance();
    }

	public void search(MemberVO mVo, String text) {
		fVo = new Food_VO();
		fVo = model.searchInfoByFoodName(text);
		
		if(fVo == null) {
			JOptionPane.showMessageDialog(null, text+"는 존재하지 않습니다.");
		} else {
			view.dispose();
			DetailView dfs =new DetailView(mVo, fVo);	
			dfs.setVisible(true);
		} 
		
	}


    
}