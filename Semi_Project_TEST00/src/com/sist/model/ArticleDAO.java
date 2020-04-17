package com.sist.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import com.sun.xml.internal.ws.wsdl.writer.document.OpenAtts;

import util.DBManager;

public class ArticleDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	private ArticleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static ArticleDAO instance = new ArticleDAO();
	
	public static ArticleDAO getInstance() {
		return instance;
	}
	
	public ArticleVO articleCont(int article_no) {
			ArticleVO vo = new ArticleVO();
		
		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				vo.setArticle_file1(rs.getString("article_file1"));
				vo.setArticle_file1(rs.getString("article_file1"));
				vo.setArticle_file1(rs.getString("article_file1"));
				vo.setArticle_file1(rs.getString("article_file1"));
				vo.setArticle_date(rs.getString("article_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return vo;
	}

	public int articleHit(int article_no) {
		int result = 0;
			
		try {
			conn = DBManager.openConn(); // 조회수 증가
			sql = "update article0 set article_hit=+1 where article_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}

	public int insertNewArticle(ArticleVO aVo) {
		int result=  0;
		
		sql = "insert into article0 "
				+ "values(article_no_seq.nextval, ?, ?, '조선일보', ?, '한국', ?,?,?, '', '', '', default, sysdate)";
		
		
		try {
			conn = DBManager.openConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aVo.getArticle_writer());
			pstmt.setString(2, aVo.getArticle_name());
			pstmt.setString(3, aVo.getArticle_gen1());
			pstmt.setString(4, aVo.getArticle_title());
			pstmt.setString(5, aVo.getArticle_cont());
			pstmt.setString(6, aVo.getArticle_file1());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	
		return result;
	}

	public ArticleVO selectOneArticleByNum(int article_no) {
		sql = "select * from article0 where article_no = ?";
		
		conn = DBManager.openConn();
		ArticleVO aVo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				aVo = new ArticleVO();
				aVo.setArticle_no(rs.getInt(1));
				aVo.setArticle_writer(rs.getString(2));
				aVo.setArticle_name(rs.getString(3));
				aVo.setArticle_media(rs.getString(4));
				aVo.setArticle_gen1(rs.getString(5));
				aVo.setArticle_gen2(rs.getString(6));
				aVo.setArticle_title(rs.getString(7));
				aVo.setArticle_cont(rs.getString(8));
				aVo.setArticle_file1(rs.getString(9));
				aVo.setArticle_file2(rs.getString(10));
				aVo.setArticle_file3(rs.getString(11));
				aVo.setArticle_file4(rs.getString(12));
				aVo.setArticle_hit(rs.getInt(13));
				aVo.setArticle_date(rs.getString(14));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		
		
		return aVo;
	}

	public ArticleVO getArticleByNum(int article_no1) {
		sql = "select * from article0 where article_no = ?";
		
		conn = DBManager.openConn();
		ArticleVO aVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article_no1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				aVo = new ArticleVO();
				aVo.setArticle_no(rs.getInt(1));
				aVo.setArticle_writer(rs.getString(2));
				aVo.setArticle_name(rs.getString(3));
				aVo.setArticle_media(rs.getString(4));
				aVo.setArticle_gen1(rs.getString(5));
				aVo.setArticle_gen2(rs.getString(6));
				aVo.setArticle_title(rs.getString(7));
				aVo.setArticle_cont(rs.getString(8));
				aVo.setArticle_file1(rs.getString(9));
				aVo.setArticle_file2(rs.getString(10));
				aVo.setArticle_file3(rs.getString(11));
				aVo.setArticle_file4(rs.getString(12));
				aVo.setArticle_hit(rs.getInt(13));
				aVo.setArticle_date(rs.getString(14));		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
			
		return aVo;
	}

	public int updateArticle(ArticleVO aVo) {
		sql = "update article0 set article_writer=?, article_gen1=?, article_title=?, article_cont=?, article_file1=? where article_no=?";
		
		
		int result = 0;
		try {
			conn = DBManager.openConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aVo.getArticle_writer());
			pstmt.setString(2, aVo.getArticle_gen1());
			pstmt.setString(3, aVo.getArticle_title());
			pstmt.setString(4, aVo.getArticle_cont());
			pstmt.setString(5, aVo.getArticle_file1());
			pstmt.setInt(6, aVo.getArticle_no());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	
	// 회원정보가 변경되었음으로, 그 사람이 쓴 기사의 정보도 변경되어야 한다.
	public int updateArticle2(ArticleVO aVo) {
		int result = 0;
		sql = "update article0 set article_name=?, article_media=? where article_writer=?";
		
		conn = DBManager.openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aVo.getArticle_name());
			pstmt.setString(2, aVo.getArticle_media());
			pstmt.setString(3, aVo.getArticle_writer());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
		
	}
	
	
	public List<ArticleVO> articleSide() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		
		try {
			conn = DBManager.openConn();
			sql = "select * from (select * from article0 order by article_no desc) where rownum<4";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(Integer.parseInt(rs.getString("article_no")));
				vo.setArticle_title(rs.getString("article_title"));
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
	
	public int searchArticleCount(String find) {
		int count = 0;

		try {
			conn = DBManager.openConn();
			sql = "select count(*) from article0 where article_name like ? or article_title like ? or "
					+ "article_cont like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + find + "%");
			pstmt.setString(2, "%" + find + "%");
			pstmt.setString(3, "%" + find + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public List<ArticleVO> searchArticleList(String find, int page, int rowsize) {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);

		try {
			conn = DBManager.openConn();

			sql = "select * from (select p.*, row_number() over (order by article_hit desc) rnum "
					+ "from article0 p where article_name like ? or article_title like ? or article_cont like ?) "
					+ "where rnum >=? and rnum<=?";
			// order by article_hit desc
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + find + "%");
			pstmt.setString(2, "%" + find + "%");
			pstmt.setString(3, "%" + find + "%");
			pstmt.setInt(4, startNo);
			pstmt.setInt(5, endNo);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				
				
				String article_sentence = extractSentenceFromHTML(rs.getString("article_cont"));
				
				vo.setArticle_cont(article_sentence);
								
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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
	
	public int searchNArticleCount(String name) {// name
		int count = 0;

		try {
			conn = DBManager.openConn();
			sql = "select count(*) from article0 where article_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public List<ArticleVO> searchNArticleList(String name, int page, int rowsize) {

		List<ArticleVO> list = new ArrayList<ArticleVO>();

		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);

		try {
			conn = DBManager.openConn();
			sql = "select * from (select p.*, row_number() over(order by article_no desc) rnum "
					+ "from article0 p where article_name like ?) where rnum >=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			System.out.println("sql");
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				
				
				String article_sentence = extractSentenceFromHTML(rs.getString("article_cont"));
				
				vo.setArticle_cont(article_sentence);
								
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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
	
	public int searchTirticleCount(String title) {// title
		int count = 0;

		try {
			conn = DBManager.openConn();
			sql = "select count(*) from article0 where article_title like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public List<ArticleVO> searchTirticleList(String title, int page, int rowsize) {

		List<ArticleVO> list = new ArrayList<ArticleVO>();

		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);

		try {
			conn = DBManager.openConn();
			sql = "select * from (select p.*, row_number() over(order by article_no desc) rnum "
					+ "from article0 p where article_title like ?) where rnum >=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			System.out.println("sql");
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				
				String article_sentence = extractSentenceFromHTML(rs.getString("article_cont"));
				
				vo.setArticle_cont(article_sentence);
								
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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
	
	public int searchCorticleCount(String cont) {// title
		int count = 0;

		try {
			conn = DBManager.openConn();
			sql = "select count(*) from article0 where article_cont like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + cont + "%");

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public List<ArticleVO> searchCorticleList(String cont, int page, int rowsize) {

		List<ArticleVO> list = new ArrayList<ArticleVO>();

		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);

		try {
			conn = DBManager.openConn();
			sql = "select * from (select p.*, row_number() over(order by article_no desc) rnum "
					+ "from article0 p where article_cont like ?) where rnum >=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + cont + "%");
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			System.out.println("sql");
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				
				
				String article_sentence = extractSentenceFromHTML(rs.getString("article_cont"));
				
				vo.setArticle_cont(article_sentence);
								
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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
	
	public List<ArticleVO> getselectHit() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 order by article_hit desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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
	
	public List<ArticleVO> getPoliticsList() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_gen1 = 'politics' and rownum <= 5 order by article_hit desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
				
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
	
	
	// 경제만
	public List<ArticleVO> getEconomyList() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_gen1 ='economy' and rownum <= 5 order by article_hit desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
			
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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

	// 사회만
	public List<ArticleVO> getSocietyList() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_gen1 = 'society' and rownum <= 5 order by article_hit desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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

	// 사회만
	public List<ArticleVO> getCultureList() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_gen1 = 'culture' and rownum <= 5 order by article_hit desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));

				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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

	// 세계만
	public List<ArticleVO> getWorldList() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_gen1 ='world' and rownum <=5 order by article_hit desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				
				// article_cont에서 첫번째 이미지를 썸네일로 담아줄 것임
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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

	// 과학만
	public List<ArticleVO> getScienceList() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_gen1 = 'science'and rownum <= 5 order by article_hit desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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

	// 스포츠만
	public List<ArticleVO> getSportsList() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_gen1 = 'sports'and rownum <= 5 order by article_hit desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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
	
	
	public List<ArticleVO> getlatelyList() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where rownum <= 9 order by article_date desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				
				tempImage =extractImageFromCont(rs.getString("article_cont"));
				/*vo.setArticle_file1(rs.getString("article_file1"));*/
				
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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
	
	public String extractImageFromCont(String article_cont) {
		int startPoint = 0;
		int endPoint = 0;
		
		
		if(article_cont.indexOf("upload/") > -1) {
			System.out.println("들어왔어요!!");
			startPoint = article_cont.indexOf("upload/");
			System.out.println(startPoint);
			startPoint = startPoint+7;
			System.out.println(startPoint);
		}
			
		
		if(article_cont.indexOf(".jpg") >-1) {
			System.out.println("endPoint 테스트에요");
			endPoint = article_cont.indexOf(".jpg");
			System.out.println(endPoint);
			endPoint = endPoint+4;
			System.out.println(endPoint);
		} else if(article_cont.indexOf(".gif") >-1) {
			endPoint = article_cont.indexOf(".gif");
			endPoint = endPoint + 4;
		} else if(article_cont.indexOf(".png") > -1) {
			endPoint = article_cont.indexOf(".png");
			endPoint = endPoint + 4;
		} else if(article_cont.indexOf(".jpeg") > -1) {
			endPoint = article_cont.indexOf(".jpeg");
			endPoint = endPoint + 5;
		}
				
		
		
	    String result = article_cont.substring(startPoint, endPoint);
	    
	    System.out.println(result+"그래서 나온게");
	    
	    return result;
	
	}

	public ArticleVO getArticlePro(String writer) {
		ArticleVO vo = new ArticleVO();

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_writer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				vo.setArticle_cont(rs.getString("article_cont"));
				vo.setArticle_file1(rs.getString("article_file1"));
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
				vo.setArticle_date(rs.getString("article_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return vo;
	}
	
	public int searchMyArticleCount(String article_writer) {
		int count = 0;

		try {
			conn = DBManager.openConn();
			sql = "select count(*) from article0 where article_writer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article_writer);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
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
	
	public int articleDelete(int article_no) {
		int result = 0;

		try {
			conn = DBManager.openConn();
			sql = "select * from article0 where article_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sql = "delete from article0 where article_no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, article_no);
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

/*	public int getListCount(String type) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	 public int getListCount(String type) {
			int count = 0;

			try {
				conn = DBManager.openConn();
				sql = "select count(*) from article0 where article_gen1 = ? order by article_hit desc ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, type);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);

			}
			return count;
		}

/*	public List<ArticleVO> getBoardList(int page, int rowsize, String type) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	public List<ArticleVO> getBoardList(int page, int rowsize, String type) {
		// 시작번호 끝 번호 3개의 자료형을 가져와야 하기 때문에 리스트도 받아온다.
		List<ArticleVO> list = new ArrayList<ArticleVO>();

		// 해당 페이지에서 시작 번호
		int startNo = (page * rowsize) - (rowsize - 1);
		// 해당 페이지의 끝 번호
		int endNo = (page * rowsize);

		try {
			conn = DBManager.openConn();
			// row_number() over : 특정 컬럼을 기준으로 행 번호를 부여할 때 사용하는 함수
			sql = "select * from (select p.*, row_number() over(order by article_no desc) rnum "
					+ "from article0 p where article_gen1 = ?) where rnum >=? and rnum <=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			String tempImage = null;
			while (rs.next()) {
				tempImage = null;
				ArticleVO vo = new ArticleVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setArticle_writer(rs.getString("article_writer"));
				vo.setArticle_name(rs.getString("article_name"));
				vo.setArticle_media(rs.getString("article_media"));
				vo.setArticle_gen1(rs.getString("article_gen1"));
				vo.setArticle_gen2(rs.getString("article_gen2"));
				vo.setArticle_title(rs.getString("article_title"));
				
				String article_sentence = extractSentenceFromHTML(rs.getString("article_cont"));
				
				vo.setArticle_cont(article_sentence);
				
				tempImage = extractImageFromCont(rs.getString("article_cont"));
				vo.setArticle_file1(tempImage);
				
				vo.setArticle_file2(rs.getString("article_file2"));
				vo.setArticle_file3(rs.getString("article_file3"));
				vo.setArticle_file4(rs.getString("article_file4"));
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

	private String extractSentenceFromHTML(String article_cont) {

		int endPoint = 0;
		
	
		if(article_cont.indexOf("<img") > -1) {
			endPoint = article_cont.indexOf("<img");
		} 
		
		// 예외 처리 필요. 이미지가 처음에 올 떄. (일단은 나중에 생각)
		
		String result = article_cont.substring(0, endPoint);
		
		return result;
	}
	
	
}
