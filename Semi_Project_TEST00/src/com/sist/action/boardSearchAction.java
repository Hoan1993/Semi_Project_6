package com.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;

public class boardSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String find = request.getParameter("find").trim();
		
		int rowsize=10;
		int block=2;
		int totalRecord=0;
		int allPage=0;
		int page=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int startNo=(page*rowsize)-(rowsize-1);
		int endNo=(page*rowsize);
		
		int startBlock=(((page-1)/block)*block)+1;
		int endBlock=(((page-1)/block)*block)+block;
		
		ArticleDAO dao = ArticleDAO.getInstance();
		totalRecord=dao.searchArticleCount(find);
		
		allPage=(int)Math.ceil(totalRecord/(double)rowsize);
		
		if(endBlock>allPage) {
			endBlock=allPage;
		}
		
		List<ArticleVO> list = dao.searchArticleList(find, page, rowsize);
		
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		request.setAttribute("find", find);
		request.setAttribute("list", list);
		
		int nrowsize=10;
		int nblock=2;
		int ntotalRecord=0;
		int nallPage=0;
		int npage=1;
		
		if(request.getParameter("npage")!=null){
			npage=Integer.parseInt(request.getParameter("npage"));
		}
		
		int nstartNo=(npage*nrowsize)-(nrowsize-1);
		int nendNo=(npage*nrowsize);
		
		int nstartBlock=(((npage-1)/nblock)*nblock)+1;
		int nendBlock=(((npage-1)/nblock)*nblock)+nblock;
		
		ntotalRecord=dao.searchNArticleCount(find);
		
		nallPage=(int)Math.ceil(ntotalRecord/(double)nrowsize);
		
		if(nendBlock>nallPage) {
			nendBlock=nallPage;
		}
		
		List<ArticleVO> nlist = dao.searchNArticleList(find, npage, nrowsize);
		request.setAttribute("npage", npage);
		request.setAttribute("nrowsize", nrowsize);
		request.setAttribute("nblock", nblock);
		request.setAttribute("ntotalRecord", ntotalRecord);
		request.setAttribute("nallPage", nallPage);
		request.setAttribute("nstartNo", nstartNo);
		request.setAttribute("nendNo", nendNo);
		request.setAttribute("nstartBlock", nstartBlock);
		request.setAttribute("nendBlock", nendBlock);
		request.setAttribute("namelist", nlist);
		
		int trowsize=10;
		int tblock=2;
		int ttotalRecord=0;
		int tallPage=0;
		int tpage=1;
		
		if(request.getParameter("tpage")!=null){
			tpage=Integer.parseInt(request.getParameter("tpage"));
		}
		
		int tstartNo=(tpage*trowsize)-(trowsize-1);
		int tendNo=(tpage*trowsize);
		
		int tstartBlock=(((tpage-1)/tblock)*tblock)+1;
		int tendBlock=(((tpage-1)/tblock)*tblock)+tblock;
		
		ttotalRecord=dao.searchTirticleCount(find);
		
		tallPage=(int)Math.ceil(ttotalRecord/(double)trowsize);
		
		if(tendBlock>tallPage) {
			tendBlock=tallPage;
		}
		
		List<ArticleVO> tlist = dao.searchTirticleList(find, tpage, trowsize);
		request.setAttribute("tpage", tpage);
		request.setAttribute("trowsize", trowsize);
		request.setAttribute("tblock", tblock);
		request.setAttribute("ttotalRecord", ttotalRecord);
		request.setAttribute("tallPage", tallPage);
		request.setAttribute("tstartNo", tstartNo);
		request.setAttribute("tendNo", tendNo);
		request.setAttribute("tstartBlock", tstartBlock);
		request.setAttribute("tendBlock", tendBlock);
		request.setAttribute("titlelist", tlist);
		
		int crowsize=10;
		int cblock=2;
		int ctotalRecord=0;
		int callPage=0;
		int cpage=1;
		
		if(request.getParameter("cpage")!=null){
			cpage=Integer.parseInt(request.getParameter("cpage"));
		}
		
		int cstartNo=(cpage*crowsize)-(crowsize-1);
		int cendNo=(cpage*crowsize);
		
		int cstartBlock=(((cpage-1)/cblock)*cblock)+1;
		int cendBlock=(((cpage-1)/cblock)*cblock)+cblock;
		
		ctotalRecord=dao.searchCorticleCount(find);
		
		callPage=(int)Math.ceil(ctotalRecord/(double)crowsize);
		
		if(cendBlock>callPage) {
			cendBlock=callPage;
		}
		
		List<ArticleVO> clist = dao.searchCorticleList(find, cpage, crowsize);
		request.setAttribute("cpage", cpage);
		request.setAttribute("crowsize", crowsize);
		request.setAttribute("cblock", cblock);
		request.setAttribute("ctotalRecord", ctotalRecord);
		request.setAttribute("callPage", callPage);
		request.setAttribute("cstartNo", cstartNo);
		request.setAttribute("cendNo", cendNo);
		request.setAttribute("cstartBlock", cstartBlock);
		request.setAttribute("cendBlock", cendBlock);
		request.setAttribute("contlist", clist);
		
		ActionForward forward = new ActionForward();
		String url = "searchListForm.do";
		forward.setRedirect(false);
		forward.setPath(url);
		
		
		return forward;
	}

}
