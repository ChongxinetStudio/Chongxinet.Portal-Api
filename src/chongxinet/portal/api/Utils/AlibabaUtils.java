package chongxinet.portal.api.Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * ����Ͱ�druid���ݿ����ӳع���
 * 
 * @author kayse
 * 
 */
public class AlibabaUtils {
	// ����һ�����ݿ����ӳ�
	private static DataSource ds = null;
	// ��̬����飬���������ļ�
	static {
		try {
			// ��������ļ��ܵ���
			InputStream in = AlibabaUtils.class.getClassLoader()
					.getResourceAsStream("druid.properties");
			// ����һ�������ļ���
			Properties p = new Properties();
			// ���������ļ�
			p.load(in);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ������һ������
	 */
	public static Connection getConnection() {
		// ����һ������
		Connection con = null;
		try {
			// �����ӳػ��һ������
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	/**
	 * �ر���Դ
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
