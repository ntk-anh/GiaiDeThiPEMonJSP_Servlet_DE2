package Q1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class AccountDAO {

	Connection con;
	String query;
	PreparedStatement statement;
	ResultSet result;

	// hàm trả về Account có dữ liệu => login đúng
	// hàm trả về Account k có dữ liệu => login sai
	public Account kiemTraDangNhap(String id, String password) throws ClassNotFoundException, SQLException {
		query = "select * from account where accountid=? and password=?";

		con = JDBCConnection.getConnection();
		if (con != null) {
			System.out.println("ket noi thanh cong");

		} else {
			System.out.println("ket noi that bai");
		}
		statement = con.prepareStatement(query);
		statement.setString(1, id);
		statement.setString(2, password);
		result = statement.executeQuery();
		while (result.next()) {
			return new Account(result.getString(1), result.getString(2));
		}
		return null;
	}
}
