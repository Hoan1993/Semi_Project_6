package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

import util.MakeHiddenId;

public class BoardFindIdOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String findId = "";
		String url = "";

		String certifiNum = request.getParameter("certifiNum");
		String certifiNumAnswer = request.getParameter("certifiNumAnswer").trim();
		String phone2 = request.getParameter("phone2");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		System.out.println("===============================");
		System.out.println(certifiNum+", "+certifiNumAnswer+", "+phone2);
		System.out.println("===============================");
		
	
		ActionForward forward = new ActionForward();
		
		int phoneNum = Integer.parseInt(phone2);
		
		MemberVO mVo = mDao.getInfoByPhone(phoneNum);
		
		if(certifiNum.equals(certifiNumAnswer)) {
			findId = mDao.getIdByPhoneNumber(phoneNum);
			System.out.println("니 아이디 ==> "+mVo.getMem_email());
			MakeHiddenId hId = new MakeHiddenId();
			String hiddenId = hId.makeHiddenId(mVo.getMem_email());
			
			request.setAttribute("userid", mVo.getMem_name());
			request.setAttribute("hiddenId", hiddenId);
			
			url =  "board_resultYourId.do";
			
			forward.setRedirect(false);
			forward.setPath(url);
			
		} else {
			url = "board_findId.do";
			
			forward.setRedirect(true);
			forward.setPath(url);
			
			request.setAttribute("IdFailed", "hi");

		}
		
		return forward;
		
	}

}
