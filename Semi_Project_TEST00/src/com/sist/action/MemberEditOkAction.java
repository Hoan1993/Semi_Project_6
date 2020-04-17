package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;
import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

public class MemberEditOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// member테이블
		
		System.out.println("membereditokaction 회원정보 업데이트 정보를 가져오나?");
		
		
		String writer = request.getParameter("writer");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String article_media = request.getParameter("article_media");
		
		System.err.println(writer+" "+name+" "+pwd+" "+phone+" "+article_media);
		System.out.println("membereditokaction 회원정보 업데이트 정보를 가져오나?");
		
		MemberVO mvo = new MemberVO();
		mvo.setMem_email(writer);
		mvo.setMem_name(name);
		mvo.setMem_pwd(pwd);
		mvo.setMem_phone(phone);
		
		
		MemberDAO mao = MemberDAO.getInstance();
		int res = mao.updateMember2(mvo);
		
		System.out.println("여기까지도 문제 없습니다.");
		
		// article테이블
		ArticleVO avo = new ArticleVO();
		avo.setArticle_writer(writer);
		avo.setArticle_name(name);
		avo.setArticle_media(article_media);
		
		ArticleDAO aao = ArticleDAO.getInstance();
		int res2 = aao.updateArticle2(avo);
		
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(res>0 && res2> 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			out.println("<script>");
			out.println("alert('회원정보 수정에 성공했습니다.')");
			out.println("location.href='board_pro.do?email="+writer+"'");
			out.println("</script>");
			String url = "board_pro.do?email="+writer+"";
			forward.setRedirect(false);
			forward.setPath(url);
		}else {
			out.println("<script>");
			out.println("alert('회원정보 수정에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
