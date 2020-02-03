package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class MemberDAO {
	private MemberDAO() {
		
	}
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public List<MemberVO> selectAllMember() {
		String sql = "select * from member_c";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberVO mVo;
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setUserpwd(rs.getString("userpwd"));
				mVo.setAddress(rs.getString("address"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPwdq(rs.getInt("pwdq"));
				mVo.setPwda(rs.getString("pwda"));
				
				list.add(mVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
		
	}

	public int loginProcess(String userid, String userpwd) {
		String sql = "select * from member_c where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("userpwd") != null && rs.getString("userpwd").equals(userpwd)) {
					result = 1;
				} else {
					result = 0;
				}				
			} else {
				result = -1;
			}

		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}

	
	public int insertMember(MemberVO mVo) {
		String sql = "insert into member_c values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			if(idCheck(mVo.getUserid()) == 1) {
				throw new Exception();
			}
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getUserpwd());
			pstmt.setString(4, mVo.getAddress());
			pstmt.setString(5, mVo.getEmail());
			pstmt.setInt(6, mVo.getPwdq());
			pstmt.setString(7, mVo.getPwda());
			result = pstmt.executeUpdate();
			
			DBManager.close(conn, pstmt);
		} catch(Exception e) {
			//e.printStackTrace();
			result = 0;
		} 
		
		
		return result;
	}

	public int idCheck(String userid) {
		String sql = "select userid from member_c where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
				
			} else {
				result = -1;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;

	}

	public String findUserid(String email) {
		String sql = "select userid from member_c where email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("userid");
				
			} else {
				result = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;

	}

	public String findUserpwd(String userid, int pwdq, String pwda) {
		String sql = "select userpwd from member_c where userid=? and pwdq=? and pwda=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, pwdq);
			pstmt.setString(3, pwda);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("userpwd");	
			} else {
				result = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	// userid로 그 사람의 이메일 주소를 받아온다.
	public String toSendEmail(String userid) {
		//MemberVO mVo = new MemberVO();
		
		String sql = "select email from member_c where userid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		MemberVO mVo;
//		List<MemberVO> list = new ArrayList<MemberVO>();
		String result = null;
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("email");
				
//				list.add(mVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	
	}
	
	public String findName(String userid) {
		String sql = "select name from member_c where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("name");
				
			} else {
				result = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;

	}

	public MemberVO allInfo(String userid) {
		String sql = "select * from member_c where userid=?";
		
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO mVo = new MemberVO();
		
		try {
			
			conn = DBManager.getConnection();
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setUserpwd(rs.getString("userpwd"));
				mVo.setAddress(rs.getString("address"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPwdq(rs.getInt("pwdq"));
				mVo.setPwda(rs.getString("pwda"));				
				//list.add(mVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		return mVo;
	}

	public int securityCheck(String userid, String userpwd, MemberVO mVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateMember(MemberVO mVo) {
		String sql = "update member_c set userpwd=?, address=?, email=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getUserpwd());
			pstmt.setString(2, mVo.getAddress());
			pstmt.setString(3, mVo.getEmail());
			pstmt.setString(4, mVo.getUserid());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public void updateRandomPWD(String randomPwd) {
		String sql = "update member_c set userpwd=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, randomPwd);
	
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	
		
	}
	
}
