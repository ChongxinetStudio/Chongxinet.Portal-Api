package chongxinet.portal.api.Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 阿里巴巴druid数据库连接池工具
 * 
 * @author kayse
 * 
 */
public class AlibabaUtils {
	// 创建一个数据库连接池
	private static DataSource ds = null;
	// 静态代码块，加载配置文件
	static {
		try {
			// 获得配置文件管道流
			InputStream in = AlibabaUtils.class.getClassLoader()
					.getResourceAsStream("druid.properties");
			// 创建一个配置文件类
			Properties p = new Properties();
			// 加载配置文件
			p.load(in);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取并返回一个连接
	 */
	public static Connection getConnection() {
		// 创建一个连接
		Connection con = null;
		try {
			// 从连接池获得一个连接
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	/**
	 * 关闭资源
	 * 
	 * @param con
	 */
	public static void closeConnection(Connection con) {
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
