package com.sist.action;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;
import com.sist.model.MemberVO;

public class BoardWriteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url="";
		
		
		
		String article_file1 = "";
		// 첨부파일이 저장될 위치
		//String saveFolder = "C:/NCS/workspace(web)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Web_Project/upload/";
		String saveFolder = "C:/NCS/workspace(web)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Semi_Project_TEST00/upload/";
		
		// 첨부파일이 저장될 위치 
		int fileSize = 10*1024*1024;
		
		MultipartRequest multi  = new MultipartRequest(
				request, 
				saveFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		File upload_file = multi.getFile("file");
		
		if(upload_file != null) {
			String fileName = upload_file.getName();
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String homedir = saveFolder + "/"+year+"-"+month+"-"+day;
			File path1 = new File(homedir);
			
			if(!path1.exists()) {
				path1.mkdirs();
			}
			
			// 파일을 만들자
			String refileName = fileName;
			
			// DB에 저장되는 이름을 따로 준다.
			article_file1 = "/"+year+"-"+month+"-"+day+"/"+refileName;
			
		}
		
		HttpSession session = request.getSession();
		MemberVO mVo = (MemberVO)session.getAttribute("loginUser");
		
		
		String article_writer = mVo.getMem_email(); 
		String [] temp = mVo.getMem_email().split("@");
		String article_name = temp[0];
		String article_gen1 = (String) multi.getParameter("mySelect1");
		String article_title = (String) multi.getParameter("subject");
		//String article_cont = (String) multi.getParameter("content");
		String article_cont = (String) multi.getParameter("test");
		
		
		
		System.out.println(article_writer+" : "+article_gen1+" : "+article_title+" : "+article_cont+ " : "+article_file1);
		
		ArticleVO aVo = new ArticleVO();
		
		aVo.setArticle_writer(article_writer);
		aVo.setArticle_name(article_name);
		aVo.setArticle_title(article_title);
		aVo.setArticle_gen1(article_gen1);
		aVo.setArticle_cont(article_cont);
		aVo.setArticle_file1(article_file1);
		
		
		ArticleDAO aDao = ArticleDAO.getInstance();
		
		int result = aDao.insertNewArticle(aVo);
		
		if(result == 1) {
			url = "./board/index.jsp";
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath(url);
		
		
		return forward;
	}

}
