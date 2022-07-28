 package Q1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {

	String query;
	Connection con;
	PreparedStatement statement;
	ResultSet result;

	public List<Employee> layDanhSachEmployee(String id) throws ClassNotFoundException, SQLException {
		List<Employee> list=new ArrayList<>();
		query = "select * from employee where createdby=?";
		con = JDBCConnection.getConnection();
		statement = con.prepareStatement(query);
		statement.setString(1, id);
		result = statement.executeQuery();
		while (result.next()) {
			list.add(new Employee(result.getInt(1), 
					result.getString(2),
					result.getInt(3),
					result.getDate(4)));
		}
		return list;
	}
}
