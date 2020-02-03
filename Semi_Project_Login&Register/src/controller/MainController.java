package controller;

import model.MemberDAO;
import view.LoginView;
import view.Main_View;

public class MainController {

    private Main_View view;
    private MemberDAO model;

    public MainController(Main_View view){
        this.view = view;
        model = MemberDAO.getInstance();
    }


    
}