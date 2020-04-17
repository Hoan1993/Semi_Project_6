package com.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;
import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

public class BoardProAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      String email = request.getParameter("email");
      
      System.out.println("이메일 : "+email);
      MemberDAO mao = MemberDAO.getInstance();
      MemberVO mVo = mao.getMemberPro(email);
      
      
      
      ArticleDAO aao = ArticleDAO.getInstance();
      ArticleVO aVo = aao.getArticlePro(email);
      
      
      request.setAttribute("aPro", aVo);
      request.setAttribute("mPro", mVo);
      // 아래 test
      System.out.println(email);
      int rowsize=4;
      int block=3;
      int totalRecord=0;
      int allPage=0;
      int page=1;
      
      if(request.getParameter("page")!=null) {
         page=Integer.parseInt(request.getParameter("page"));
      }
      
      int startNo = (page*rowsize)-(rowsize-1);
      int endNo = (page*rowsize);
      
      int startBlock=(((page-1)/block)*block)+1;
      int endBlock=(((page-1)/block)*block)+block;
      
      ArticleDAO dao = ArticleDAO.getInstance();
      totalRecord = dao.searchMyArticleCount(email);
      
      allPage = (int)Math.ceil(totalRecord/(double)rowsize);
      
      if(endBlock > allPage) {
         endBlock=allPage;
      }
      
      List<ArticleVO> list = dao.searchArticleMyList(email, page, rowsize);
      
      request.setAttribute("page", page);
      request.setAttribute("rowsize", rowsize);
      request.setAttribute("block", block);
      request.setAttribute("totalRecord", totalRecord);
      request.setAttribute("allPage", allPage);
      request.setAttribute("startNo", startNo);
      request.setAttribute("endNo", endNo);
      request.setAttribute("startBlock", startBlock);
      request.setAttribute("endBlock", endBlock);
      request.setAttribute("article_writer", email);
      request.setAttribute("searchList", list);
      
      String url = "board_profile.do";
      
      ActionForward forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath(url);
      return forward;
   }

}