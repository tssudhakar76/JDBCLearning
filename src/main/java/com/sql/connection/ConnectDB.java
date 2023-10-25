/**
 * 
 */
package com.sql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class ConnectDB {
	
	public static Connection getConnection(String driver, String url, String userName, String pwd) throws Exception {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Invalid Driver");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Connection failed");
		}
		return connection;		
	}
}
