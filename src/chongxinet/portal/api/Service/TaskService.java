package chongxinet.portal.api.Service;

import java.util.List;

import chongxinet.portal.api.Dao.TaskDao;
import chongxinet.portal.api.Entity.Task;


/**
 * ͨ����Ʒ���Ͳ�ѯ��Ʒ
 */
public class TaskService {
	private TaskDao dao = new TaskDao();

	/**
	 * ��ѯ��Ʒ
	 */
	public List<Task> getTasks(String type) {

		return this.dao.getTasks(type);

	}

}
