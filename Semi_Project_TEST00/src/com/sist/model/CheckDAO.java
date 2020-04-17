package com.sist.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CheckDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	public CheckDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static CheckDAO instance = new CheckDAO();
	
	public static CheckDAO getInstance() {
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
	// 좋아요 or 싫어요 를 누르면 회원 정보가 저장되는 메서드.
	public int checked(int no, String writer) {
		int result=0;
		
		try {
			
			conn=openConn();
			sql="select * from check0 where check_no=? and check_writer=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, writer);
			rs=pstmt.executeQuery();
			System.out.println("test1 : "+result);
			if(rs.next()) {
				result= -1;
			}else {
				sql = "insert into check0 values (?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.setString(2, writer);			
				result= pstmt.executeUpdate();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			close(conn, pstmt, rs);
		}
		System.out.println("test2 : "+result);
		return result; 

	}// end
}
