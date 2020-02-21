package model;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
				mVo.setBudget(rs.getInt("budget"));
				
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
		String sql = "insert into member_c values(?,?,?,?,?,?,?,?,?)";
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
			pstmt.setInt(8, mVo.getBudget());
			pstmt.setInt(9, mVo.getBalance());
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
				mVo.setBudget(rs.getInt("budget"));
				mVo.setBalance(rs.getInt("balance"));
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

	public void updateRandomPWD(String randomPwd, String userid) {
		String sql = "update member_c set userpwd=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, randomPwd);
			pstmt.setString(2, userid);
			
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt);
		} catch(Exception e) {
			e.printStackTrace();
		} 
	
		
	}

	
	// 스케쥴러를 위한 메서드.
	public int makeSchedule(String userid, int date) {
		String sql = "insert into myCal values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, date);
			pstmt.setInt(3, 1);
			result = pstmt.executeUpdate();
			
			DBManager.close(conn, pstmt);
		} catch(Exception e) {
			//e.printStackTrace();
			result = 0;
		} 
		
		
		return result;		
		
	}

	public Food_VO getFoodInfoByNum(int foodNum) {
		String sql = "select * from food_table2 where bno=?";
		Food_VO fVo = new Food_VO();
		
		byte [] barr = null;
		/*byte [] barr2 = null*/;
		ImageIcon iconTest = null;
		ImageIcon iconTest2 = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, foodNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {// now on 1st row	
				fVo = new Food_VO();
				
				Blob b  = rs.getBlob(2);
				barr = b.getBytes(1,(int)b.length());
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
				iconTest = new ImageIcon(image);
				
				b  = rs.getBlob(3);
				barr = b.getBytes(1,(int)b.length());
				BufferedImage image1 = ImageIO.read(new ByteArrayInputStream(barr));
				iconTest2 = new ImageIcon(image1);
				
				fVo.setBno(rs.getInt("bno"));
				fVo.setIcon(iconTest);
				fVo.setIcon2(iconTest2);
				fVo.setStore_name(rs.getString("store_name"));
				fVo.setFood_name(rs.getString("food_name"));
				fVo.setPrice(rs.getInt("price"));
				fVo.setReview(rs.getString("review"));
				fVo.setAddress(rs.getString("address"));
			} 
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return fVo;
	}
	

	public MyCalVO getMCVOByUserid(String userid, int selectDay) {
		String sql = "select * from myCal_c where userid=? and mydate=?";
		
		/*Food_VO fVo = new Food_VO();*/
		MyCalVO mcVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, selectDay);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {// now on 1st row	
				mcVO = new MyCalVO();
				
				mcVO.setUserId(rs.getString("userid"));
				mcVO.setMyDate(rs.getString("mydate"));
				mcVO.setFoodNum(rs.getInt("bno"));
				
			} 
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mcVO;
	}

	public Food_VO searchInfoByFoodName(String food_name) {
		Food_VO fVo = null;
		String sql = "select * from food_table2 where food_name=?";
		
		byte [] barr = null;
		/*byte [] barr2 = null*/;
		ImageIcon iconTest = null;
		ImageIcon iconTest2 = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		 	conn = DBManager.getConnection();
		 	pstmt = conn.prepareStatement(sql);
		 	pstmt.setString(1, food_name);
		 	rs = pstmt.executeQuery();
		 	
		 	if(rs.next()) {
		 		fVo = new Food_VO();
				
				Blob b  = rs.getBlob(2);
				barr = b.getBytes(1,(int)b.length());
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
				iconTest = new ImageIcon(image);
				
				b  = rs.getBlob(3);
				barr = b.getBytes(1,(int)b.length());
				BufferedImage image1 = ImageIO.read(new ByteArrayInputStream(barr));
				iconTest2 = new ImageIcon(image1);
				
				fVo.setBno(rs.getInt("bno"));
				fVo.setIcon(iconTest);
				fVo.setIcon2(iconTest2);
				fVo.setStore_name(rs.getString("store_name"));
				fVo.setFood_name(rs.getString("food_name"));
				fVo.setPrice(rs.getInt("price"));
				fVo.setReview(rs.getString("review"));
				fVo.setAddress(rs.getString("address"));
		 	}
		 		
		 	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return fVo;
	}
	
}
