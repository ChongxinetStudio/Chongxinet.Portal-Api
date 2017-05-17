package chongxinet.portal.api.Service;

import java.util.List;

import chongxinet.portal.api.Dao.TaskDao;
import chongxinet.portal.api.Entity.Task;


/**
 * 通过商品类型查询商品
 */
public class TaskService {
	private TaskDao dao = new TaskDao();

	/**
	 * 查询商品
	 */
	public List<Task> getTasks(String type) {

		return this.dao.getTasks(type);

	}

}
