/**
 * 
 */
package com.sql.learn;

import static com.sql.connection.ConnectDB.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 */
public class DBConnectAppication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ConnectDB connectDB = new ConnectDB();
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/account";
		String user = "postgres";
		String pass = "admin";
		String query = "Select * from employee";
		try {
			Connection connection = getConnection(driver, url, user, pass);
			System.out.println("Connection established");
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("ResultSet size: "+rs.getFetchSize()+"\n");
			while (rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.print(rs.getString(2)+ ", ");
				System.out.print(rs.getString(3)+ ", ");
				System.out.print(rs.getInt(4)+ ", ");
				System.out.print(rs.getLong(5));
				
				System.out.print(rs.getString(6)+ ", ");
				System.out.println(rs.getString(7));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
