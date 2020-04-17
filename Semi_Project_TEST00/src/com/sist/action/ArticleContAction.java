package com.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;
import com.sist.model.CommentDAO;
import com.sist.model.CommentVO;
import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;
import com.sist.model.ReplyDAO;
import com.sist.model.ReplyVO;

public class ArticleContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 로그인한 회원 정보
	    HttpSession session = request.getSession();
	    MemberVO mVoc = (MemberVO) session.getAttribute("loginUser");
		int article_no = Integer.parseInt(request.getParameter("no"));
		
		
		ReplyDAO replydao = ReplyDAO.getInstance();
	      // 댓글 다오?
	    CommentDAO comdao = CommentDAO.getInstance();
	    ArticleDAO dao = ArticleDAO.getInstance();
	    ActionForward forward = new ActionForward();
		
		
	 // 페이징처리
	      int rowsize = 10; // 한페이지당 보여질 게시물의 수
	      int block = 3; // 아래에 보여질 페이지의 최대 수 - 예) [1][2][3]
	      int totalRecord = 0; // DB 상의 레코드 전체 수(게시물의 수)
	      int allPage = 0; // 전체 페이지 수

	      int page = 0;

	      if (request.getParameter("page") != null) {
	         page = Integer.parseInt(request.getParameter("page"));
	      } else {
	         page = 1; // 처음으로 "게시물목록" 태그를 클릭한 경우
	      }
	      // 해당 페이지에서 시작 번호
	      int startNo = (page * rowsize) - (rowsize - 1);
	      // 해당 페이지에서 끝 번호
	      int endNo = (page * rowsize);
	      // 해당 페이지에서 시작 블럭
	      int startBlock = (((page - 1) / block) * block) + 1;
	      // 해당 페이지의 마지막 블럭
	      int endBlock = (((page - 1) / block) * block) + block;
	      
	      
	      totalRecord=comdao.getListComment(article_no);    
	      
	      System.out.println(totalRecord+"여기서까지도 문제없음.");
	      
	      allPage=(int)Math.ceil(totalRecord / (double)rowsize);// Math.ceil 올림 함수
	      if(endBlock > allPage) { // 총페이지수가 마지막 블럭보다 작으면 처리하라.
	         endBlock = allPage;
	      }
	    
	      
	      if(mVoc != null) {// 로그인 한 경우 경로
	          if(dao.articleHit(article_no) > 0 ) {
	             

	             // 대댓 리스트
	             List<ReplyVO> replyList=replydao.replyList(article_no);
	             
	             // 댓글 리스트
	             List<CommentVO> comList=comdao.CommentList(article_no, page, rowsize);   
	             
	             // 기사 글
	             ArticleVO vo = dao.articleCont(article_no);
	             // 로그인 회원 이메일
	             String article_writer = mVoc.getMem_email(); // 멤버테이블의 회원 이메일
	             MemberDAO dao2=MemberDAO.getInstance();
	             MemberVO getMem=dao2.getMember(article_writer);
	             // 페이징 처리 시 사용했던 모든 값들을  키로 저장하자.
	             request.setAttribute("page", page);  // o
	             request.setAttribute("rowsize", rowsize);
	             request.setAttribute("block", block);  //o
	             request.setAttribute("totalRecord", totalRecord);
	             request.setAttribute("allPage", allPage);   //o
	             request.setAttribute("startNo", startNo); 
	             request.setAttribute("endNo", endNo);
	             request.setAttribute("startBlock", startBlock); //o
	             request.setAttribute("endBlock", endBlock); // o
	             request.setAttribute("comList", comList);
	             //
	             request.setAttribute("replyList", replyList);            
	             request.setAttribute("replyCount", replyList.size());
	             request.setAttribute("getMem", getMem);                        
	             request.setAttribute("Cont", vo);
	             
	             forward.setRedirect(false);
	             forward.setPath("./article/article_cont.jsp");
	             
	             
	          }else {
	             forward.setRedirect(false);
	             forward.setPath("index.jsp");
	          };
	          
	       }else { // 로그인을 안하고 사용할 경우 경로
	          if(dao.articleHit(article_no) > 0 ) {
	             
	             // 대댓 리스트
	             List<ReplyVO> replyList=replydao.replyList(article_no);
	             
	             // 댓글 리스트
	             List<CommentVO> comList=comdao.CommentList(article_no, page, rowsize);   
	             // 기사 글
	             ArticleVO vo = dao.articleCont(article_no);
	          
	             // 페이징 처리 시 사용했던 모든 값들을  키로 저장하자.
	             request.setAttribute("page", page);  // o
	             request.setAttribute("rowsize", rowsize);
	             request.setAttribute("block", block);  //o
	             request.setAttribute("totalRecord", totalRecord);
	             request.setAttribute("allPage", allPage);   //o
	             request.setAttribute("startNo", startNo); 
	             request.setAttribute("endNo", endNo);
	             request.setAttribute("startBlock", startBlock); //o
	             request.setAttribute("endBlock", endBlock); // o
	             request.setAttribute("comList", comList);
	             //
	             request.setAttribute("replyList", replyList);         
	             request.setAttribute("Cont", vo);
	             
	             forward.setRedirect(false);
	             forward.setPath("./article/article_cont.jsp");
	             
	             
	          }else {
	             forward.setRedirect(false);
	             forward.setPath("index.jsp");
	          };
	       }//else end  
	      
	      
	      
	      
	     // =================================== // 
/*		if(dao.articleHit(article_no)==1) {
			ArticleVO vo = dao.articleCont(article_no);
			request.setAttribute("Cont", vo);
			forward.setRedirect(false);
			forward.setPath("./article/article_cont.jsp");
		}else {
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		};*/

		return forward;
	}
}