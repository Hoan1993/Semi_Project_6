package com.sist.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReplyDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	private ReplyDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static ReplyDAO instance = new ReplyDAO();
	
	public static ReplyDAO getInstance() {
		return instance;
	}

	public Connection openConn() {
		
		try {

			// 1. JNDI 서버 객체 생성
			InitialContext ic = new InitialContext();
			// 2. lookup() 메서드를 이용하여 매칭되는 커넥션을 찾는다.
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			// 3. DataSource 객체를 이용하여 커넥션 객체를 하나 가져온다.
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}

	public void close(Connection conn, Statement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end
		
	// 대댓글 추가하기
	public int insertreply(ReplyVO vo) {
		int result=0, count=1;
		
		try {
			conn=openConn();
			sql="select max(reply_no) from reply0";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1)+1;
			}
			sql="insert into reply0 values(?,?,?,?,?,?, sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getArticle_no());
			pstmt.setInt(2, vo.getCom_no());
			pstmt.setInt(3, count);
			pstmt.setString(4, vo.getReply_write());
			pstmt.setString(5, vo.getReply_name());
			pstmt.setString(6, vo.getReply_cont());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}// end
	// 해당 기사의 대댓글 리스트 가져오는 메서드
	public List<ReplyVO> replyList(int article_no){
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		
		try {
			conn=openConn();// 여기서 해당 댓글 조건 까지 넣으면 다음 해당댓글의 대댓글은 못가져옴.(주의)
			sql="select * from reply0 where article_no=? order by reply_no desc";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, article_no);
			
			
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyVO vo = new ReplyVO();
				vo.setArticle_no(rs.getInt("article_no"));
				vo.setCom_no(rs.getInt("com_no"));
				vo.setReply_no(rs.getInt("reply_no"));
				vo.setReply_write(rs.getString("reply_write"));
				vo.setReply_name(rs.getString("reply_name"));
				vo.setReply_cont(rs.getString("reply_cont"));
				vo.setReply_date(rs.getString("reply_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	
}
