package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

// 오라클 db에 
public class InsertImage {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into food_table2 values(food_num.nextVal, ?,?,?,?,?,?,?)";
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
						
			// FileInputSteam 객체를 이용해, 이미지 파일을 읽어온다. 1바이트 단위로.
			FileInputStream fin = new FileInputStream("C:/semi_image/water1_2.jpg");
			// pstmt가 setBinaryStream이라는 메소드를 제공.
			// fin, fin.available()이라고 써서, 이미지를 db에 넣을 수 있다.
			
			pstmt.setBinaryStream(1, fin, fin.available());
			
			FileInputStream fin1 = new FileInputStream("C:/semi_image/water1.jpg");
			// pstmt가 setBinaryStream이라는 메소드를 제공.
			// fin, fin.available()이라고 써서, 이미지를 db에 넣을 수 있다.
			
			pstmt.setBinaryStream(2, fin1, fin1.available());
			
			pstmt.setString(3, "쌍용강북교육센터 정수기");
			pstmt.setString(4, "물");
			pstmt.setInt(5, 0);
			pstmt.setString(6, "건강에 좋은 물~! 체중감량 효과 있음!");
			pstmt.setString(7, "서울 강남구 테헤란로 132 (역삼동)한독약품 빌딩 8층");
			// pstmt.executeUpdate();
			int i = pstmt.executeUpdate();
			System.out.println(i+" records affected");

			//conn.close();
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		

	}

}
