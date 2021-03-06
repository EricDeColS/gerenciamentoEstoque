package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/db_estoque";
	private static final String USER = "root";
	private static final String PASS = "root";

	public static Connection getConnection() {
		
			try {
				Class.forName(DRIVER);
				return DriverManager.getConnection(URL, USER, PASS);
				
			} catch (ClassNotFoundException | SQLException e) {
				throw new RuntimeException("Erro de conexão", e);
			}
	
	}
	
	public static void closeConnection(Connection con) {
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("Error"+e);
			}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("Error"+e);
			}
		}
		closeConnection(con);
		
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("Error");
			}
		}
		closeConnection(con, stmt);
	}
	
}
