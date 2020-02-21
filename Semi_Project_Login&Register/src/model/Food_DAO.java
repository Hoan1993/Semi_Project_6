package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import util.DBManager;

public class Food_DAO {
	private Food_DAO() {

	}
	
	private static Food_DAO instance = new Food_DAO();
	
	public static Food_DAO getInstance() {
		return instance;
	}

	public static int calcCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		String sql = "select count(bno) from food_table2";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		

		return result;
	}


	/*public static ImageIcon imageFromDB(int ranNum) {
		byte [] barr = null;
		ImageIcon iconTest = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select image from food_table where bno=?");
			pstmt.setInt(1, ranNum);
			rs = pstmt.executeQuery();
			

			if (rs.next()) {// now on 1st row			
				Blob b  = rs.getBlob(1);
				barr = b.getBytes(1,(int)b.length());
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
				iconTest = new ImageIcon(image);
				
				
			} 

	
			DBManager.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return iconTest;
	}*/
	
	public static Food_VO imageFromDB(int ranNum) {
		Food_VO fVo = null;
		
		byte [] barr = null;
		byte [] barr2 = null;
		ImageIcon iconTest = null;
		ImageIcon iconTest2 = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from food_table2 where bno=?");
			pstmt.setInt(1, ranNum);
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

	
			DBManager.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fVo;
	}
	
	public int insertFoodInfoToDB(String userid, int day, int randomRecom) {
		String sql = "insert into mycaltest values(?,?,?)";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, day);
			pstmt.setInt(3, randomRecom);
			result = pstmt.executeUpdate();
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
		
	}

	public Food_VO getInfoByDay(String userid, int selectDay) {
		// mycaltest 안에서 selectDay에 있는 foodnum을 가져옴.
		// 그거에 해당하는 foodnum을 fodd_table2에서 가져옴.
		String sql = "select * from food_table2 where bno=(select foodnum from mycaltest where mydate=? and userid=?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Food_VO fVo = new Food_VO();
		byte [] barr = null;
		/*byte [] barr2 = null;*/
		ImageIcon iconTest = null;
		ImageIcon iconTest2 = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectDay);
			pstmt.setString(2, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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

	public int countTableRows() {
		String sql = "select count(*) from mycaltest";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
		
	}

	public void deleteTable(String userid) {
		String sql = "delete from mycaltest where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public int getPriceByRandomNum(int randomRecom) {
		String sql = "select price from food_table2 where bno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, randomRecom);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("price");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
		
	}
	// 이 부분은 반드시 memberDAO로 옮겨야 한다.
	public void insertBudgetToDB(int inputPrice, String userid) {
		String sql = "update member_c set budget=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputPrice);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public void inputBalance(String userid, int inputPrice) {
		String sql = "update member_c set balance=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputPrice);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	
}








