package Q1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/list")
public class EmployeeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lay id
		HttpSession session = req.getSession();
		Account account = (Account) session.getAttribute("account");
		System.out.println(session);
		
		if (account==null) {
			resp.getWriter().append("<h1>Acess Denied</h1>");
		}else {
			// lay danh sach employee
			EmployeeDAO employeeDAO = new EmployeeDAO();
			try {
				List<Employee> list = employeeDAO.layDanhSachEmployee(account.getId());
				
				//đẩy list  vô file jsp
				req.setAttribute("list", list);
				req.setAttribute("id", account.getId());
				req.getRequestDispatcher("employee_list.jsp").forward(req, resp);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
