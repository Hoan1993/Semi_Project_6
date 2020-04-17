package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReportWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String url = null;
		
		ReportVO vo = new ReportVO();
		vo.setReport_type("뉴스/기사");
		vo.setReport_title("(FORM) 뉴스/기사 신고입니다.");
		System.out.println("test : "+request.getParameter("email"));
		
		vo.setReport_writer(request.getParameter("email"));
		vo.setReport_content(request.getParameter("report"));
		
		ReportDAO dao = ReportDAO.getInstance();
		int result = dao.reportNew(vo);
		
		if(result == 0) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('신고가 실패하였습니다.')");
			out.println("</script>");
		}
		
		return null;
	}

}
