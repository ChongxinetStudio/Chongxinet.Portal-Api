package chongxinet.portal.api.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chongxinet.portal.api.Entity.Task;
import chongxinet.portal.api.Utils.AlibabaUtils;


/**
 * 商品Dao
 * 
 * @author kayse
 * 
 */
public class TaskDao {
	Connection con = null;

	/**
	 * 通过
	 */
	public List<Task> getTasks(String type) {
		List<Task> tasks = new ArrayList<Task>();
		try {
			// 获取一个连接
			con = AlibabaUtils.getConnection();
			// 创建一个preparedStatement，防止SQL注入问题
			PreparedStatement pstmt = null;
			if (type.equals("all")) {
				pstmt = con.prepareStatement("select * from tasks");
			} else {
				pstmt = con
						.prepareStatement("select * from tasks where type=?");
				// 设置sql参数
				pstmt.setString(1, type);
			}
			// 执行sql语句返回一个结果集
			ResultSet rs = pstmt.executeQuery();
			// 如果结果集有数据就将b设为true
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
				// /评论查询
				tasks.add(task);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			AlibabaUtils.closeConnection(con);
		}
		return tasks;

	}

}
