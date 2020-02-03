package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static Connection getConnection() { 
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "semi_pro";
	String password = "tiger";
	
	Connection conn= null;
	try {
		Class.forName(driver);
		//System.out.println("jdbc driver 로딩 성공");
		// 지금 프로그램과 연결과
		conn = DriverManager.getConnection(url, user, password);
		//System.out.println("오라클 연결 성공");
	} catch (ClassNotFoundException e) {
		System.out.println("jdbc driver 로딩 실패");
	} catch (SQLException e) {
		System.out.println("오라클 연결 실패");
	}
	
	return conn;
}

	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
