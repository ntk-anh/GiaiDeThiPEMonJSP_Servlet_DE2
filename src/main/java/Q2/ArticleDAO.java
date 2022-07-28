package Q2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ArticleDAO {

	String query;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	//lấy ra 1 list article
	public List<Article> getList(String id){
		List<Article> list=new ArrayList<>();
		query="select article.articleid, articlename, articledate\r\n"
				+ "from article \r\n"
				+ "join author_article on article.articleid=author_article.articleid\r\n"
				+ "where authorid=?";
		try {
			con=JDBCConnection.getConnection();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			ps=con.prepareStatement(query);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			ps.setString(1, id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				list.add(new Article(rs.getInt(1),rs.getString(2),rs.getDate(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void insertArticle(String id,String title,String date) {
		query="insert into article values (?,?,?)";
		try {
			con=JDBCConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, title);
			ps.setString(3, date);
			ps.executeUpdate();
		} catch (Exception e) {

		}
		
	}
	public void insertArticleAuthor(String id,String id2) {
		query="insert into author_article values(?,?)";
		try {
			con=JDBCConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, id2);
			ps.executeUpdate();
		} catch (Exception e) {

		}
		
	}
	public static void main(String[] args) throws SQLException {
		ArticleDAO a=new ArticleDAO();
		List<Article>list=a.getList("1000");
		for (Article o : list) {
			System.out.println(o.getId());
		}
	}
}
