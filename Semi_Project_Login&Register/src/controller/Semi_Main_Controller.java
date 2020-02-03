package controller;



import model.Food_DAO;
import model.Food_VO;
import model.MemberVO;
import view.DetailView;
import view.Main_View;



public class Semi_Main_Controller {
	private static Food_DAO fDao = null;
	private static Main_View view = null;
	
	  public Semi_Main_Controller(Main_View view){
	        this.view = view;
	        fDao = Food_DAO.getInstance();
	    }
	
	public void showdetailView(MemberVO mVo, Food_VO fVo1, Main_View frame) {
		view.dispose();
		DetailView dv = new DetailView(mVo, fVo1);
		dv.setVisible(true);
		
		//dv.setVisible(true);
		//dv.setLocationRelativeTo(null);
	}
}