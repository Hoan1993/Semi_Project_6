package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.CommentDAO;
import com.sist.model.CommentVO;
import com.sist.model.MemberVO;

import util.MakeHiddenId;

public class WriteCommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {		
		String com_cont=request.getParameter("comt_cont"); // 댓글 내용
		int article_no=Integer.parseInt(request.getParameter("no"));
		
		
		  HttpSession session=request.getSession();		
	      MemberVO mVoc = (MemberVO) session.getAttribute("loginUser");
	      
	     //	String test_no= (String) session.getAttribute("test_no");
	     // int article_no = (int) session.getAttribute("article_no");
	      
	     // System.out.println(article_no+" dsfjsdlfsdlkfjl"+test_no);
	      
	      PrintWriter out = response.getWriter();
	      if(mVoc != null) {// 로그인을 할경우
	    	  String article_name = mVoc.getMem_name(); // 멤버테이블의 회원 이름
		      String article_writer = mVoc.getMem_email(); // 멤버테이블의 회원 이메일
	      
		   // dto에 넣기
		      CommentVO vo= new CommentVO();
		      System.out.println("no:"+article_no);
		      
		      vo.setArticle_no(article_no);
		      vo.setCom_writer(article_writer);// 아이디
		      vo.setCom_name(article_name);		      
		      vo.setCom_cont(com_cont);
		     
		     CommentDAO dao= CommentDAO.getInstance();
		     int res= dao.insertcomt(vo);
		     System.out.println(article_no+" dkdkdk");
		     
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
