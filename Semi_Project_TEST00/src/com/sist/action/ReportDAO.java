package com.sist.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class ReportDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	private ReportDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static ReportDAO instance = new ReportDAO();
	
	public static ReportDAO getInstance() {
		return instance;
	}
	
	public int reportNew(ReportVO vo) {
		int res = 0;
		try {
			conn = DBManager.openConn();
			sql = "insert into report values(report_seq.nextval,?,?,?,default, sysdate,default,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getReport_type());
			pstmt.setString(2, vo.getReport_title());
			pstmt.setString(3, vo.getReport_writer());
			pstmt.setString(4, vo.getReport_content());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return res;
	}
	
	public ReportVO reportCont(int report_no) {
			ReportVO vo = new ReportVO();
		
		try {
			conn = DBManager.openConn();
			sql = "select * from report0 where report_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, report_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return vo;
	}

	public int reportHit(int report_no) {
		int result = 0;
			
		try {
			conn = DBManager.openConn(); // 조회수 증가
			sql = "update report0 set report_hit=+1 where report_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, report_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}

	public List<ReportVO> reportSide() {
		List<ReportVO> list = new ArrayList<ReportVO>();
		
		try {
			conn = DBManager.openConn();
			sql = "select * from (select * from report0 order by report_no desc) where rownum<4";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReportVO vo = new ReportVO();
				vo.setReport_no(Integer.parseInt(rs.getString("report_no")));
				vo.setReport_title(rs.getString("report_title"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return list;
	}
}
