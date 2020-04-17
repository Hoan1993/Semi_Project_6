package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

import findIdByPhoneNumber.Config;
import util.MakeCertifiNum;

public class BoardTestPhoneAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String certifiNum = "";
		String url = "";
		String phone = "";
		
		String mem_name = request.getParameter("phone");
		phone = request.getParameter("phone");
		
		int mem_phoneInt = Integer.parseInt(phone);
		
		System.out.println(mem_name+", "+phone);
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		/*int mem_phoneInt = Integer.parseInt(mem_phone);*/
		
		int result = mDao.checkMember(mem_name, mem_phoneInt);
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
			
			
			System.out.println("들어왔습니다.");
			url = "board_checkCertiNum.do";
			request.setAttribute("mVo", mVo);
			
			HttpSession session = request.getSession();
			session.setAttribute("findIdSucceed", "success");
			
			/*session2.setAttribute("phone2", phone);
			session2.setAttribute("certifiNum", certifiNum);*/
			
			System.out.println("전화번호 좀 "+phone);
			
			request.setAttribute("phone2", phone);
			request.setAttribute("certifiNum", certifiNum);
			System.out.println("전화번호 좀 "+phone);
			
			forward.setRedirect(false);
			forward.setPath(url);
			
			
			
		} else {
			url = "board_findId.do";
			HttpSession session = request.getSession();
			session.setAttribute("findIdFailed", "fail");
				
			forward.setRedirect(true);
			forward.setPath(url);
		}
		
		
		return forward;
	}

}
