package com.ensialligence.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class PersistenceConfig {
	
	private static Connection connection;
	
	static {
		try {
			String driverClass = "com.mysql.cj.jdbc.Driver";
			String BDD="app_jee";
			String url = "jdbc:mysql://localhost:3306/" + BDD;
			String user = "root";
			String password = "";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to db...");

		} catch(Exception e) {
			System.out.println("erreur de connexion...");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
