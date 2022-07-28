package Q2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class AddController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AuthorDAO dao=new AuthorDAO();
		try {
			List<Author>list=dao.getAuthorsList();
			req.setAttribute("list",list);
			req.getRequestDispatcher("Show.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String title=req.getParameter("title");
		String date=req.getParameter("date");
		String[] author=req.getParameterValues("author");//dl là 1 mảng
		
		
		ArticleDAO dao=new ArticleDAO();
		dao.insertArticle(id, title, date);
		for (String o : author) {
			dao.insertArticleAuthor( o,id);
		}
		resp.sendRedirect("add");
	}
}
