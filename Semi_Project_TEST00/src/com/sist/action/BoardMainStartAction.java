package com.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.action.Action;
import com.sist.action.ActionForward;
import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;

public class BoardMainStartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		
		ArticleDAO dao = ArticleDAO.getInstance();
		
		//	조회수 받아오기
		List<ArticleVO> hit = dao.getselectHit();
		System.out.println("처음에는 잘 들어감? "+hit.get(0).getArticle_title());
		HttpSession session = request.getSession();
		session.setAttribute("hit", hit);
	
		
		
		//	정치 받아오기
		List<ArticleVO> poli = dao.getPoliticsList();
		
		request.setAttribute("poli", poli);
		
		//	경제 받아오기
		List<ArticleVO> econ = dao.getEconomyList();
		
		request.setAttribute("econ", econ);
		
		//	사회 받아오기
		List<ArticleVO> soci = dao.getSocietyList();
		
		request.setAttribute("soci", soci);
		
		//	연예/문화 받아오기
		List<ArticleVO> cult = dao.getCultureList();
		
		request.setAttribute("cult", cult);
		
		//	세계 받아오기
		List<ArticleVO> world = dao.getWorldList();
		
		request.setAttribute("world", world);
		
		//	it/과학 뉴스 받아오기
		List<ArticleVO> scie = dao.getScienceList();
		
		request.setAttribute("scie", scie);
		
		//	스포츠 받아오기
		List<ArticleVO> sports = dao.getSportsList();
			
		request.setAttribute("sports", sports);
		
		//	최신순으로 받아오기
		List<ArticleVO> lately= dao.getlatelyList();
		request.setAttribute("lately", lately);
		
		String url="./board/board_mainTemp.jsp";
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath(url);
		return forward;
	}

}
