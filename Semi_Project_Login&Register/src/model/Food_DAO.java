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
	
	
}








