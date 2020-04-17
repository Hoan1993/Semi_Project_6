package com.sist.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.DBManager;

public class FavoriteDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private FavoriteDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static FavoriteDAO instance = new FavoriteDAO();
	
	public static FavoriteDAO getInstance() {
		return instance;
	}
	
	public int favoriteNew(FavoriteVO vo) {
		int res=0;
		try {
			conn = DBManager.openConn();
			sql = "insert into favorite values(favorite_seq.nextval,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getArticle_no());
			pstmt.setString(2, vo.getMem_email());
			pstmt.setString(3, vo.getArticle_title());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return res;
	}
	
	public FavoriteVO favoriteCont(int favorite_no) {
			FavoriteVO vo = new FavoriteVO();
		
		try {
			conn = DBManager.openConn();
			sql = "select * from favorite0 where favorite_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, favorite_no);
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

	public int favoriteHit(int favorite_no) {
		int result = 0;
			
		try {
			conn = DBManager.openConn(); // 조회수 증가
			sql = "update favorite0 set favorite_hit=+1 where favorite_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, favorite_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}

	public List<FavoriteVO> favoriteSide() {
		List<FavoriteVO> list = new ArrayList<FavoriteVO>();
		
		try {
			conn = DBManager.openConn();
			sql = "select * from (select * from favorite0 order by favorite_no desc) where rownum<4";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FavoriteVO vo = new FavoriteVO();
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

	public int favoriteChk(FavoriteVO vo) {
		int res = -1;
		
		try {
			conn = DBManager.openConn();
			sql = "select * from favorite where article_no=? and mem_email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getArticle_no());
			pstmt.setString(2, vo.getMem_email());
			res = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return res;
	}

	public String favoriteList(String email) {
	      JSONObject json = new JSONObject();
	      JSONArray datalist = new JSONArray();
	      int number = 1;
	      String jsonInfo = "SQL 에러";
	      System.out.println("Fav 이메일 : "+email);
	      
	      
	      try {
	         conn = DBManager.openConn();
	         sql = "select * from favorite where mem_email=? order by fav_date";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, email);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {            
	            HashMap<String, Object> map = new HashMap<>();
	            String title = rs.getString("article_title");
	            
	            if(title.length()>20) {
	            	title = title.substring(0, 19) + "...";
	            }

	            map.put("number", number);
	            
	            String article = "<a href='javascript:void(0)' onclick='goAction("
	            		+ rs.getInt("article_no") + ")'>"
	            		+ rs.getString("article_title")
	            		+ "</a>";
	            
	            System.out.println(article);
	            
	            map.put("article", article);   

	            map.put("date", rs.getString("fav_date"));
	            
	            String delete =
	            	"<span class='btn btn-info btn-xs' onclick='favDelete("+
	            	rs.getInt("fav_no")+")'>X</span>";
	            map.put("delete", delete);
	            //JSONObject data = new JSONObject(map);
	            JSONObject data = new JSONObject(map);
	            datalist.add(data);
	            
	            number++;
	         }
	         
	         json.put("data", datalist);
	         jsonInfo = json.toJSONString();
	         datalist.toJSONString();
	         
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt, rs);
	      }
	      return jsonInfo;
	   }

	public int favoriteDel(int no) {
		int res = 0;
		
		try {
			conn = DBManager.openConn();
			sql = "delete from favorite where fav_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			res = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return res;
	}

}