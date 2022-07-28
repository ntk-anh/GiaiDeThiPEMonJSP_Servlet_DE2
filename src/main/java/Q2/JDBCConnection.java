package Q2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getConnection() throws SQLException {
		final String database="jdbc:mysql://localhost:3306/quanlyauthor";
		final String username="root";
		final String password="123456789";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("connect successfully!");
		} catch (ClassNotFoundException e) {

			System.err.println("connect failure!");
			e.printStackTrace();
		}
		return DriverManager.getConnection(database,username,password);
	}
}
