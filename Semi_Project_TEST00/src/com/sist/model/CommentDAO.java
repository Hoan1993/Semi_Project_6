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

public class CommentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	private CommentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static CommentDAO instance = new CommentDAO();
	
	public static CommentDAO getInstance() {
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
	
	public  void close(Connection conn, Statement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end
	
	// 댓글 창에 넣은 글을 데이터에 저장(추가)
		public int insertcomt(CommentVO vo) {
			int result=0, count=1;
			
			try {
				conn=openConn();
				sql="select max(com_no) from comment0";
				pstmt= conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt(1)+1;
				}
				sql="insert into comment0 values(?, ?, ?, ?, ?, default, default, default, sysdate)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getArticle_no());
				pstmt.setInt(2, count);
				pstmt.setString(3, vo.getCom_writer());
				pstmt.setString(4, vo.getCom_name());				
				pstmt.setString(5, vo.getCom_cont());
				
				result=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			
			return result;
		}// end
	// 해당 기사의 댓글 리스트 가져오는 메서드
		public List<CommentVO> CommentList(int article_no, int page, int rowsize){
			List<CommentVO>  list= new ArrayList<CommentVO>();
			// 해당 페이지에서 시작 번호 
			int startNo =(page * rowsize)-(rowsize -1);
			// 해당 페이지에서 끝 번호
			int endNo =(page*rowsize);
			try {
				conn=openConn();			
				sql= "select * from" // p는 board1의 별칭
						// board1 테이블에서 row_number() over()함수를 사용하여 순번을 매겨준다. rnum은 매겨준 순번의 컬럼이름.
					+ "(select p.*, row_number() over(PARTITION by article_no order by com_no desc) rnum from comment0 p) "
					+ "where article_no=? and rnum >=? and rnum <=?";
				pstmt= conn.prepareStatement(sql);
				pstmt.setInt(1, article_no);
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);				
				rs=pstmt.executeQuery();
				// ARTICLE_NO, COM_NO, COM_WRITER, COM_NAME, COM_TITLE, COM_CONT, COM_HIT, COM_UP, COM_DOWN, COM_DATE
				while(rs.next()) {	
					CommentVO vo = new CommentVO();
					vo.setArticle_no(rs.getInt("article_no"));
					vo.setCom_no(rs.getInt("com_no"));
					vo.setCom_writer(rs.getString("com_writer"));
					vo.setCom_name(rs.getString("com_name"));					
					vo.setCom_cont(rs.getString("com_cont"));
					vo.setCom_hit(rs.getInt("com_hit"));
					vo.setCom_up(rs.getInt("com_up"));
					vo.setCom_down(rs.getInt("com_down"));
					vo.setCom_date(rs.getString("com_date"));
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
		// 댓글 삭제 메서드
		public int ComDelete(int no) {
			int result=0;
			
			try {
				conn=openConn();
				sql="select * from comment0 where com_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					sql="delete from comment0 where com_no=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, no);
					result=pstmt.executeUpdate();
				}else {
					result = -1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			return result;
		}// end
	
		// 댓글 좋아요 DB에 넣기 메서드
		public void updateComUp(int no) {
			
			
			try {
				conn=openConn();
				sql="update comment0 set com_up = com_up +1 where com_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
		}// end
		
		// DB에 있는 댓글 좋아요 받기 메서드
		public int selectComUp(int no) {
			int result=0;
			try {
				conn=openConn();
				sql="select com_up from comment0 where com_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result=rs.getInt("com_up");
				}
				System.out.println(result);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			return result;
		}// end
		// 댓글 싫어요 DB에 넣기 메서드
		public void updateComDown(int no) {
			
			
			try {
				conn=openConn();
				sql="update comment0 set com_down = com_down +1 where com_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
		}// end
		// DB에 있는 댓글 싫어요 받기 메서드
		public int selectComDown(int no) {
			int result=0;
			try {
				conn=openConn();
				sql="select com_down from comment0 where com_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result=rs.getInt("com_down");
				}
				System.out.println(result);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			return result;
		}// end
		// comment 테이블의 해당기사의  댓글의 수를 조회하는 메서드
		public int getListComment(int no) {
			int count=0;
			
			try {
				conn=openConn();
				sql="select count(*) from comment0 where article_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					
					count=rs.getInt(1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			return count;
		}// end
}
