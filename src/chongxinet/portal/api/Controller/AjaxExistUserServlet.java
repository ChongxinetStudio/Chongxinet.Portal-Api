package chongxinet.portal.api.Controller;

/**
 * 判断用户名是否存在的AjaxServlet�?
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chongxinet.portal.api.Service.UserService;


@WebServlet("/existUser")
public class AjaxExistUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxExistUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得输出�?
		PrintWriter out = response.getWriter();
		// 获得用户�?
		String username = request.getParameter("username");
		// 创建serves对象
		UserService service = new UserService();
		// 通过isExistsUser方法判断用户是否存在
		boolean b = service.isExistsUser(username);
		if (b) {
			out.print("{\"valid\":false}");
		} else {
			out.print("{\"valid\":true}");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
