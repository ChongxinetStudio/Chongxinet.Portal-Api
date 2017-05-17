package chongxinet.portal.api.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chongxinet.portal.api.Entity.Task;
import chongxinet.portal.api.Utils.AlibabaUtils;


/**
 * ��ƷDao
 * 
 * @author kayse
 * 
 */
public class TaskDao {
	Connection con = null;

	/**
	 * ͨ��
	 */
	public List<Task> getTasks(String type) {
		List<Task> tasks = new ArrayList<Task>();
		try {
			// ��ȡһ������
			con = AlibabaUtils.getConnection();
			// ����һ��preparedStatement����ֹSQLע������
			PreparedStatement pstmt = null;
			if (type.equals("all")) {
				pstmt = con.prepareStatement("select * from tasks");
			} else {
				pstmt = con
						.prepareStatement("select * from tasks where type=?");
				// ����sql����
				pstmt.setString(1, type);
			}
			// ִ��sql��䷵��һ�������
			ResultSet rs = pstmt.executeQuery();
			// �������������ݾͽ�b��Ϊtrue
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTaskTitle(rs.getString("task-title"));
				task.setTaskType(rs.getString("task-type"));
				task.setTaskDescription(rs.getString("task-description"));
				task.setMember(rs.getString("task-member"));
				task.setStartDate(rs.getString("task-sdate"));
				task.setEndDate(rs.getString("task-edate"));
				task.setTaskPrice(rs.getDouble("task-price"));
				// /���۲�ѯ
				tasks.add(task);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر���Դ
			AlibabaUtils.closeConnection(con);
		}
		return tasks;

	}

}
