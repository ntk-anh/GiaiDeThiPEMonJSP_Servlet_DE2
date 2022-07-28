package Q2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AuthorDAO {

	String query;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public List<Author> getAuthorsList() throws SQLException {
		query = "SELECT * FROM author";
		con = JDBCConnection.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		List<Author> listAuthors=new ArrayList<>();
		while (rs.next()) {
			listAuthors.add(new Author(rs.getInt(1),rs.getString(2)));
		}
		return listAuthors;
	}
	public static void main(String[] args) throws SQLException {
		AuthorDAO authorDAO=new AuthorDAO();
		List<Author>list=authorDAO.getAuthorsList();
		for (Author o : list) {
			System.out.println(o);
		}
	}
}
