package chongxinet.portal.api.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import chongxinet.portal.api.Utils.AlibabaUtils;


/**
 * 用户Dao
 * 
 * @author kayse
 * 
 */
public class UserDao {
	/**
	 * 通过用户名密码判断用户是否存在
	 */
	public boolean isExistsUser(String username, String password) {
		boolean b = false;
		Connection con = null;
		try {
			// 获取一个连接
			con = AlibabaUtils.getConnection();
			// 创建一个preparedStatement，防止SQL注入问题
			PreparedStatement pstmtUser = con
					.prepareStatement("select * from users where username=? and password=?");
			PreparedStatement pstmtAdmin = con
					.prepareStatement("select * from admin where name=? and password=?");
			// 设置sql参数
			pstmtUser.setString(1, username);
			pstmtUser.setString(2, password);
			pstmtAdmin.setString(1, username);
			pstmtAdmin.setString(2, password);
			// 执行sql语句返回一个结果集
			ResultSet rsUser = pstmtUser.executeQuery();
			ResultSet rsAdmin = pstmtAdmin.executeQuery();
			// 如果结果集有数据就将b设为true
			if (rsUser.next() || rsAdmin.next()) {
				b = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			AlibabaUtils.closeConnection(con);
		}
		return b;

	}

	/**
	 * 插入用户
	 */
	public boolean successInsert(String username, String password,
			String email, String phone) {
		Connection con = null;
		// n等于0说明没插入成功否则插入成功
		boolean b = false;
		try {
			// 获取一个连接
			con = AlibabaUtils.getConnection();
			// 创建一个preparedStatement，防止SQL注入问题
			PreparedStatement pstmt = con
					.prepareStatement("insert into users(username,password,email,phone) values(?,?,?,?)");
			// 设置sql参数
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			// 执行sql语句返回一个结果集
			if (pstmt.executeUpdate() != 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			AlibabaUtils.closeConnection(con);
		}
		return b;

	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean isExistsUser(String username) {
		boolean b = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 获得连接
			con = AlibabaUtils.getConnection();
			// 创建preparedStatement
			pstmt = con
					.prepareStatement("select * from users where username=?");
			// 设置文字
			pstmt.setString(1, username);
			// 执行sql
			rs = pstmt.executeQuery();
			// 如果查询出来有结果，表示有此用户
			if (rs.next()) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AlibabaUtils.closeConnection(con);
		}
		return b;
	}

}
