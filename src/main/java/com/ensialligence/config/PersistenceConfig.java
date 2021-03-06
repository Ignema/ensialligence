package com.ensialligence.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PersistenceConfig {
	
    static Properties properties;

    public PersistenceConfig(){
    	
        this.properties = new Properties();
        try {
            properties.load(PersistenceConfig.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect(){
        try {
        	
            Class.forName(properties.getProperty("jdbcPath"));
            String url = properties.getProperty("url") ;
            String sqldir = System.getProperty("user.dir")+"/"+properties.getProperty("SQLDirectory");
            
            Connection connection = DriverManager.getConnection(url, properties.getProperty("username"), properties.getProperty("password"));
            
            Statement statement = connection.createStatement();
            executeFile(statement, sqldir+"ArticleTable.sql");
            executeFile(statement, sqldir+"CommentaireTable.sql");
            executeFile(statement, sqldir+"FriendTable.sql");
            executeFile(statement, sqldir+"JaimeTable.sql");
            executeFile(statement, sqldir+"MessageTable.sql");
            executeFile(statement, sqldir+"UtilisateurTable.sql");
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    private static void executeFile(Statement statement, String fileName) {
        try (
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            statement.executeUpdate(stringBuilder.toString());
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}