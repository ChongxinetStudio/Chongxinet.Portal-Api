package chongxinet.portal.api.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import chongxinet.portal.api.Utils.AlibabaUtils;


/**
 * �û�Dao
 * 
 * @author kayse
 * 
 */
public class UserDao {
	/**
	 * ͨ���û��������ж��û��Ƿ����
	 */
	public boolean isExistsUser(String username, String password) {
		boolean b = false;
		Connection con = null;
		try {
			// ��ȡһ������
			con = AlibabaUtils.getConnection();
			// ����һ��preparedStatement����ֹSQLע������
			PreparedStatement pstmtUser = con
					.prepareStatement("select * from users where username=? and password=?");
			PreparedStatement pstmtAdmin = con
					.prepareStatement("select * from admin where name=? and password=?");
			// ����sql����
			pstmtUser.setString(1, username);
			pstmtUser.setString(2, password);
			pstmtAdmin.setString(1, username);
			pstmtAdmin.setString(2, password);
			// ִ��sql��䷵��һ�������
			ResultSet rsUser = pstmtUser.executeQuery();
			ResultSet rsAdmin = pstmtAdmin.executeQuery();
			// �������������ݾͽ�b��Ϊtrue
			if (rsUser.next() || rsAdmin.next()) {
				b = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر���Դ
			AlibabaUtils.closeConnection(con);
		}
		return b;

	}

	/**
	 * �����û�
	 */
	public boolean successInsert(String username, String password,
			String email, String phone) {
		Connection con = null;
		// n����0˵��û����ɹ��������ɹ�
		boolean b = false;
		try {
			// ��ȡһ������
			con = AlibabaUtils.getConnection();
			// ����һ��preparedStatement����ֹSQLע������
			PreparedStatement pstmt = con
					.prepareStatement("insert into users(username,password,email,phone) values(?,?,?,?)");
			// ����sql����
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			// ִ��sql��䷵��һ�������
			if (pstmt.executeUpdate() != 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر���Դ
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
			// �������
			con = AlibabaUtils.getConnection();
			// ����preparedStatement
			pstmt = con
					.prepareStatement("select * from users where username=?");
			// ��������
			pstmt.setString(1, username);
			// ִ��sql
			rs = pstmt.executeQuery();
			// �����ѯ�����н������ʾ�д��û�
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
