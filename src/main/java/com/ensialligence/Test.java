package com.ensialligence;

import org.glassfish.hk2.api.DuplicateServiceException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {


    public static void main(String [] args ) throws IOException {
        Properties property = new Properties();
        FileInputStream fs;
        String username ="";
        fs = new FileInputStream(System.getProperty("user.dir") + "./src/main/webapp/app.properties");
        property.load(fs);
        username = property.getProperty("username");
        System.out.println("-"+username+"-");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
    }
}
