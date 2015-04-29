package com.ehm.db.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EHMDataConnect {



	/**
	 * @return the dataSource
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Connection getTestDataConn() throws ClassNotFoundException, SQLException {

		Connection dataConn = null;

		Class.forName("com.mysql.jdbc.Driver");
		String URL = "jdbc:mysql://127.0.0.1:3306/EHealthDBTest";
		String User = "root";
		String Password = "test";
		dataConn = DriverManager.getConnection(URL, User, Password);


		return dataConn;
	}

	/**
	 * @return the dataSource
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Connection getDataConn() throws SQLException, ClassNotFoundException {


		Class.forName("com.mysql.jdbc.Driver");
		String URL = "jdbc:mysql://127.0.0.1:3306/EHealthDB";
		String User = "root";
		String Password = "test";
		Connection dataConn = DriverManager.getConnection(URL, User, Password);

		
		return dataConn;
	}

}
