package Q2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthorDAO authorDAO = new AuthorDAO();
		try {// load dữ liệu từ authordao => set dữ liệu cho jsp
			List<Author> listAuthors = authorDAO.getAuthorsList();
			req.setAttribute("listAuthors", listAuthors);

			req.getRequestDispatcher("q2.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthorDAO authorDAO = new AuthorDAO();
		List<Author> listAuthors;
		try {
			listAuthors = authorDAO.getAuthorsList();
			req.setAttribute("listAuthors", listAuthors);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		// lấy id từ jsp => lấy list=>set dữ liệu cho jsp
		String authorID = req.getParameter("author");
		System.out.println(authorID);
		ArticleDAO articleDAO = new ArticleDAO();

		List<Article> listArticles = articleDAO.getList(authorID);
		
		req.setAttribute("listArticles", listArticles);
		req.getRequestDispatcher("q2.jsp").forward(req, resp);

	}
}
