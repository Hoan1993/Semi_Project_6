package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

import util.MakeRandomPwd;
import util.SendEmail;
// 비밀번호 찾기 인증 처리 부분.
public class BoardFindPwdOkAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String findPwd = "";
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
			findPwd = mDao.getIdByPhoneNumber(phoneNum);
			System.out.println("당신의 비밀번호 ==> "+mVo.getMem_pwd());
			
			request.setAttribute("username", mVo.getMem_name());
			
			MakeRandomPwd mkpwd = new MakeRandomPwd();
			String temppwd = mkpwd.RandomPwd();
			
			SendEmail send = new SendEmail();
			send.sendEmail(mVo.getMem_name(), mVo.getMem_email(), temppwd);
			
			mDao.updateTempPwd(temppwd, mVo.getMem_email());
			
			url =  "board_resultYourPwd.do";
			
			forward.setRedirect(false);
			forward.setPath(url);
			
		} else {
			url = "board_findPwd.do";
			
			forward.setRedirect(true);
			forward.setPath(url);
			
			request.setAttribute("IdFailed", "hi");

		}
		
		return forward;
	}
	
}
