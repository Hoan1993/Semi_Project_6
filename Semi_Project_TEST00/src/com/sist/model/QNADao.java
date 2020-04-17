package com.sist.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class QNADao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	private QNADao() {
		// TODO Auto-generated constructor stub
	}
	
	private static QNADao instance = new QNADao();
	
	public static QNADao getInstance() {
		return instance;
	}

	public int searchQNACount() {
		int result = 0;
		sql = "select count(*) from qna";
		
		conn = DBManager.openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
	
	
	
	public List<ArticleVO> searchArticleMyList(String article_writer, int page, int rowsize) {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);

		try {
			conn = DBManager.openConn();
			sql = "select * from (select p.*, row_number() over(order by article_no desc) rnum "
					+ "from article0 p where article_writer = ?) where rnum >=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article_writer);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				vo.setArticle_file1(rs.getString("article_file1"));
				vo.setArticle_hit(rs.getInt("article_hit"));
				vo.setArticle_date(rs.getString("article_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<QNAVO> searchQNAByPage(int page, int rowsize) {
		List<QNAVO> list = new ArrayList<QNAVO>();
		
		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);

		try {
			conn = DBManager.openConn();
			sql = "select * from (select p.*, row_number() over(order by num desc) rnum "
					+ "from qna p) where rnum >=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QNAVO qVo = new QNAVO();
				
				qVo.setNum(rs.getInt(1));
				qVo.setEmail(rs.getString(2));
				qVo.setTitle(rs.getString(3));
				qVo.setContent(rs.getString(4));
				qVo.setReadcount(rs.getInt(5));
				qVo.setWritedate(rs.getString(6));
			
				list.add(qVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}

	public void insertBoard(QNAVO qVo) {
		sql = "insert into qna values(qna_seq.nextval, ?, ?, ?, default, default)";
		
		conn = DBManager.openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qVo.getEmail());
			pstmt.setString(2, qVo.getTitle());
			pstmt.setString(3, qVo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public void updateCount(int num) {
		sql = "update qna set readcount = readcount+1 where num=?";
		conn = DBManager.openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		
	}

	public QNAVO selectOneRecordByNum(int num) {
		sql = "select * from qna where num=?";
		QNAVO qVo = null;
		conn = DBManager.openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qVo = new QNAVO();
				qVo.setNum(rs.getInt(1));
				qVo.setEmail(rs.getString(2));
				qVo.setTitle(rs.getString(3));
				qVo.setContent(rs.getString(4));
				qVo.setReadcount(rs.getInt(5));
				qVo.setWritedate(rs.getString(6));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return qVo;
	}
	
	public void deleteQNA(int num) {
		sql = "delete from qna where num=?";
		conn = DBManager.openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
	}

	public void updateBoard(QNAVO qVo) {
		sql = "update qna set title=?, content=? where num=?";
		
		conn = DBManager.openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qVo.getTitle());
			pstmt.setString(2, qVo.getContent());
			pstmt.setInt(3, qVo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
	}
	
	
}
