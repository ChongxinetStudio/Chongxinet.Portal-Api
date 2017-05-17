package chongxinet.portal.api.Service;

import chongxinet.portal.api.Dao.UserDao;

/**
 * 通过用户名密码判断用户是否存在
 */
public class UserService {
	private UserDao dao = new UserDao();

	/**
	 * 判断用户名和密码对应的用户是否存在
	 */
	public boolean isExistsUser(String username, String password) {

		return this.dao.isExistsUser(username, password);

	}

	/**
	 * 插入用户
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
