package com.asiainfo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.asiainfo.conf.ConfigurationManager;
import com.asiainfo.constant.Constants;



/**
 * JDBC辅助组件
 * @author Administrator
 */
public class JDBCHelper {
	
	// 第一步：在静态代码块中，直接加载数据库的驱动
	static {
		try {
			String driver = ConfigurationManager.getProperty(Constants.JDBC_DRIVER);
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}
	
	// 第二步，实现JDBCHelper的单例化
	private static JDBCHelper instance = null;
	
	/**
	 * 获取单例
	 * @return 单例
	 */
	public static JDBCHelper getInstance() {
		if(instance == null) {
			synchronized(JDBCHelper.class) {
				if(instance == null) {
					instance = new JDBCHelper();
				}
			}
		}
		return instance;
	}
	
	// 数据库连接池
	private LinkedList<Connection> datasource = new LinkedList<Connection>();
	
	/**
	 * 
	 * 第三步：实现单例的过程中，创建唯一的数据库连接池
	 */
	private JDBCHelper() {
		// 首先第一步，获取数据库连接池的大小，就是说，数据库连接池中要放多少个数据库连接
		// 这个，可以通过在配置文件中配置的方式，来灵活的设定
		int datasourceSize = ConfigurationManager.getInteger(
				Constants.JDBC_DATASOURCE_SIZE);
		
		// 然后创建指定数量的数据库连接，并放入数据库连接池中
		for(int i = 0; i < datasourceSize; i++) {
			String url = ConfigurationManager.getProperty(Constants.JDBC_URL);
			String user = ConfigurationManager.getProperty(Constants.JDBC_USER);
			String password = ConfigurationManager.getProperty(Constants.JDBC_PASSWORD);
			try {
				Connection conn = DriverManager.getConnection(url, user, password);
				datasource.push(conn);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		}
	}
	
	/**
	 * 第四步，提供获取数据库连接的方法
	 * 有可能，你去获取的时候，这个时候，连接都被用光了，你暂时获取不到数据库连接
	 * 所以我们要自己编码实现一个简单的等待机制，去等待获取到数据库连接
	 */
	public synchronized Connection getConnection() {
		while(datasource.size() == 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		}
		return datasource.poll();
	}
	
	/**
	 * 第五步：开发增删改查的方法
	 * 1、执行增删改SQL语句的方法
	 * 2、执行查询SQL语句的方法
	 * 3、批量执行SQL语句的方法
	 */
	
	/**
	 * 执行增删改SQL语句
	 * @param sql 
	 * @param params
	 * @return 影响的行数
	 */
	public int executeUpdate(String sql, Object[] params) {
		int rtn = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);  
			}
			
			rtn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			if(conn != null) {
				datasource.push(conn);  
			}
		}
		
		return rtn;
	}
	
	/**
	 * 执行查询SQL语句
	 * @param sql
	 * @param params
	 * @param callback
	 */
	public void executeQuery(String sql, Object[] params, 
			QueryCallback callback) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);   
			}
			
			rs = pstmt.executeQuery();
			
			callback.process(rs);  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				datasource.push(conn);  
			}
		}
	}
	
	/**
	 * 批量执行SQL语句
	 * @param sql
	 * @param paramsList
	 * @return 每条SQL语句影响的行数
	 */
	public int[] executeBatch(String sql, List<Object[]> paramsList) {
		int[] rtn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			// 第一步：使用Connection对象，取消自动提交
			conn.setAutoCommit(false);  
			pstmt = conn.prepareStatement(sql);
			
			// 第二步：使用PreparedStatement.addBatch()方法加入批量的SQL参数
			for(Object[] params : paramsList) {
				for(int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);  
				}
				pstmt.addBatch();
			}
			
			// 第三步：使用PreparedStatement.executeBatch()方法，执行批量的SQL语句
			rtn = pstmt.executeBatch();
			
			// 最后一步：使用Connection对象，提交批量的SQL语句
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();  
		}
		
		return rtn;
	}
	
	/**
	 * 静态内部类：查询回调接口
	 * @author Administrator
	 *
	 */
	public static interface QueryCallback {
		
		/**
		 * 处理查询结果
		 * @param rs 
		 * @throws Exception
		 */
		void process(ResultSet rs) throws Exception;
		
	}
	
}
