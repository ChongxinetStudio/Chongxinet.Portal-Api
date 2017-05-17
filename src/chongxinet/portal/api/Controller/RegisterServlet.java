package chongxinet.portal.api.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chongxinet.portal.api.Service.UserService;
import chongxinet.portal.api.Utils.MD5;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/insert")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String newPassword = MD5.GetMD5Code(password);
		// 判断用户名密码是否存在
		UserService service = new UserService();
		boolean b = service.successInsert(username, newPassword, email, phone);
		if (b) {
			response.sendRedirect("/ChongxinSystem/login.html");
		} else {
			response.sendRedirect("/ChongxinSystem/regist.html");

		}
	}

}
