package chongxinet.portal.api.Service;

import chongxinet.portal.api.Dao.UserDao;

/**
 * ͨ���û��������ж��û��Ƿ����
 */
public class UserService {
	private UserDao dao = new UserDao();

	/**
	 * �ж��û����������Ӧ���û��Ƿ����
	 */
	public boolean isExistsUser(String username, String password) {

		return this.dao.isExistsUser(username, password);

	}

	/**
	 * �����û�
	 */
	public boolean successInsert(String username, String password,
			String email, String phone) {

		return this.dao.successInsert(username, password, email, phone);

	}

	public boolean isExistsUser(String username) {
		// TODO Auto-generated method stub
		return this.dao.isExistsUser(username);
	}

}
