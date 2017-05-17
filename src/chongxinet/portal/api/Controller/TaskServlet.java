package chongxinet.portal.api.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chongxinet.portal.api.Entity.Task;
import chongxinet.portal.api.Service.TaskService;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/index")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskServlet() {
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
		// 获得任务类型
		String type = request.getParameter("type");
		if (type == null) {
			type = "all";
		}
		// 通过类型查询出相应的任务
		List<Task> tasks = new TaskService().getTasks(type);
		request.getSession().setAttribute("foods", tasks);
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
