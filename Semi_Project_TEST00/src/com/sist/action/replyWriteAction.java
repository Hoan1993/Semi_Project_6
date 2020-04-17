package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.sist.model.MemberVO;
import com.sist.model.ReplyDAO;
import com.sist.model.ReplyVO;

public class replyWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String reply_cont=request.getParameter("reply_cont");
		
		int article_no=Integer.parseInt(request.getParameter("article_no"));
		int com_no=Integer.parseInt(request.getParameter("com_no"));
		
		 HttpSession session=request.getSession();		
	      MemberVO mVoc = (MemberVO) session.getAttribute("loginUser");
	      PrintWriter out = response.getWriter();
	      if(mVoc != null) {
	    	  String reply_name = mVoc.getMem_name(); // 멤버테이블의 회원 이름
		      String relpy_writer = mVoc.getMem_email(); // 멤버테이블의 회원 이메일
	      
			// dto에 넣기
			ReplyVO vo = new ReplyVO();
			vo.setArticle_no(article_no);
			vo.setCom_no(com_no);
			vo.setReply_cont(reply_cont);
			vo.setReply_write(relpy_writer);
			vo.setReply_name(reply_name);
			ReplyDAO dao = ReplyDAO.getInstance();
			int res=dao.insertreply(vo);
			
			System.out.println(mVoc.getMem_name());
			System.out.println("reply no:"+article_no);
			
			if(res>0) {		         
		         out.println("<script>");
		         out.println("alert('댓글 추가 성공')");
		         out.println("location.href='article.do?no="+article_no+"'");
		         out.println("</script>");
		      }else {
		         out.println("<script>");
		         out.println("alert('댓글 업로드 실패')");
		         out.println("history.back()");
		         out.println("</script>");
		      }
	      }else {
			out.println("<script>");
			out.println("alert('댓글은 로그인 후 이용가능합니다.')");
			out.println("history.back()");
			out.println("</script>");
			
	      }
		return null;
	}

}
