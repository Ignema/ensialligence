package com.ensialligence.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SingleConnection {

private static Connection connection;



	public static List<String> Prop() throws IOException {
		List<String> prop = new ArrayList<>();
		Properties property = new Properties();


		FileInputStream fs;
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		fs = new FileInputStream( "C:\\Users\\Lenovo\\Desktop\\MyworkSpace\\JEE_Git\\ensialligence/src/main/resources/app.properties");
		property.load(fs);


		String username = property.getProperty("username");
		String password = property.getProperty("password");
		prop.add(username);
		prop.add(password);
		return prop;
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost/app_jee?serverTimezone=UTC";
			 connection = DriverManager.getConnection(url,Prop().get(0),Prop().get(1));
		}catch(ClassNotFoundException | SQLException | IOException e) {
					e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

	/*public static void main(String[] arges) throws IOException {

	}*/
}
