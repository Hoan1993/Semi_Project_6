package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

import findIdByPhoneNumber.Config;
import findIdByPhoneNumber.SendSMS;
import util.MakeCertifiNum;

public class BoardCertifiNumForPwdAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String certifiNum = "";
		String url = "";
		String phone = "";
		
		
		String mem_email = request.getParameter("email");
		phone = request.getParameter("phone2");
		
		
		int mem_phoneInt = Integer.parseInt(phone);
		
		System.out.println(mem_email+", "+phone);
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = mDao.checkMemberByEmail(mem_email, mem_phoneInt);
		
		MemberVO mVo = mDao.getInfoByPhone(mem_phoneInt);
		
		System.out.println(mVo.toString());
		MakeCertifiNum mc = new MakeCertifiNum();
		ActionForward forward = new ActionForward();
		
		if(result > 0) {
			certifiNum = mc.makeNum();
			
			Config co = new Config();
			Config.content = "고객님의 인증번호는 [ "+certifiNum+" ] 입니다.";
			Config.receiver = phone;
			
			System.out.println(certifiNum);
			
			
			// 여기서 실제로 sms를 보낸다.
			/*SendSMS sms = new SendSMS();
			SendSMS.sendingSMS();*/
			
			
			System.out.println("비밀번호 찾기 들어왔습니다.");
			url = "board_checkCertiNumForPass.do";
			request.setAttribute("certifiNum", certifiNum);
			request.setAttribute("mVo", mVo);
						
			System.out.println("전화번호 좀 "+phone);
			
			forward.setRedirect(false);
			forward.setPath(url);
			
			
		} else {
			url = "board_findPwd.do";
			HttpSession session = request.getSession();
			session.setAttribute("findIdFailed", "fail");
				
			forward.setRedirect(true);
			forward.setPath(url);
		}
		
		
		return forward;
	}
	

}
