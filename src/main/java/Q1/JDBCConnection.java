package Q1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static final String url="jdbc:mysql://localhost:3306/quanlytaikhoan";
	private static final String username="root";
	private static final String password="123456789";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,username,password);
	}
}
