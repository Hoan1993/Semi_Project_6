package com.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;

public class BoardPoliAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 페이징 처리
		int rowsize=3;		//	한 페이지당 보여질 게시물의 수
		int block=3;		//	아래에 보여질 페이지의 최대 수 예)[1][2][3]
		int totalRecord=0;	//	DB상의 레코드 전체 수(게시물 수)
		int allPage=0; 		//	전체 페이지 수 = 토탈레코드/로우사이즈 나머지가 발생하면 올림 
		int page=0;
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}else {
			page=1;	//	처음으로 "게시물 목록" 태그를 클릭한 경우
		}
		
		//	해당 페이지에서 시작 번호
		int startNo = (page*rowsize)-(rowsize-1);
		
		//	해당 페이지의 끝 번호
		int endNo = (page*rowsize);
		
		//	해당 페이지의 시작 블럭
		int startBlock = (((page-1)/block)*block)+1;
		
		//	해당 페이지의 마지막 블럭
		int endBlock = (((page-1)/block)*block)+block;
		
		ArticleDAO dao = ArticleDAO.getInstance();
		String type="politics";
		totalRecord = dao.getListCount(type);
//		totalRecord = dao.getListCount(politics);
		
		//	전체 게시물의 수를 한 페이지당 보여질 게시물의 수로 나누어 주어야한다.
		//	이 과정을 거치면 전체 페이지 수가 나온다.
		//	전체 페이지가 나올 때 나머지가 있으면 무조건 올림 해야 한다.
		
		allPage=(int)Math.ceil(totalRecord/(double)rowsize);
		
		// ceil()메서드는 안에 값을 더블형으로 받기 때문에 형변환 해줘야 함.
		if(endBlock>allPage) {
			endBlock = allPage;
		}
		List<ArticleVO> list = dao.getBoardList(page, rowsize, type);
		
		request.setAttribute("page", page);					//	0
		request.setAttribute("rowsize", rowsize);		
		request.setAttribute("block", block);				//	0
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);			//	0
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);		//	0
		request.setAttribute("endBlock", endBlock);			//	0
		request.setAttribute("List", list);	
		
		String url="./board/board_submain.jsp";
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath(url);
		
		
		return forward;
	}

}







