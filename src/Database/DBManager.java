package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static Connection conn = null;
	private final static String utente= "sa";
	private final static String passw= "";
	private final static String DatabasePath= "./test";
	private final static String URL= "jdbc:h2:" + DatabasePath;
	private DBManager() {}
	
	public static Connection getConnection() throws SQLException {
		
		if(conn == null) {
			conn = DriverManager.getConnection(URL, utente, passw);
		}
		
		return conn;
	}
	
	
	public static void closeConnection() throws SQLException {

		if(conn != null) {
			conn.close();
			conn = null;
		}
	}
}
