package com.ensialligence.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	
	private static Connection connection;
	
	static {
		try {
			String driverClass = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/socialnetwork?serverTimezone=UTC";
			String user = "root";
			String password = "140320";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to db...");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
