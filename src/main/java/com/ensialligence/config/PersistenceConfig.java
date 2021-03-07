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

    private static PersistenceConfig single_instance = null;

    static Properties properties;

    private PersistenceConfig(){
    	
        properties = new Properties();
        try {
            properties.load(PersistenceConfig.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static PersistenceConfig getInstance()
    {
        if (single_instance == null)
            single_instance = new PersistenceConfig();

        return single_instance;
    }

    public Connection connect(){
        try {
        	
            Class.forName(properties.getProperty("jdbcPath"));
            String url = properties.getProperty("url") + ":" + properties.getProperty("port") + "/";
            String sqldir = System.getProperty("user.dir")+"/"+properties.getProperty("SQLDirectory");
            
            Connection connection = DriverManager.getConnection(url, properties.getProperty("username"), properties.getProperty("password"));

            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + properties.getProperty("dbName"));

            connection = DriverManager.getConnection(url + properties.getProperty("dbName"), properties.getProperty("username"), properties.getProperty("password"));

            statement = connection.createStatement();
            executeFile(statement, sqldir+"UtilisateurTable.sql");
            executeFile(statement, sqldir+"ArticleTable.sql");
            executeFile(statement, sqldir+"CommentaireTable.sql");
            executeFile(statement, sqldir+"FriendTable.sql");
            executeFile(statement, sqldir+"JaimeTable.sql");
            executeFile(statement, sqldir+"MessageTable.sql");
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