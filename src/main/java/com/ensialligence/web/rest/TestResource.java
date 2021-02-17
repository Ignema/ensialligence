package com.ensialligence.web.rest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@WebServlet("/")
public class TestResource extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder json = new StringBuilder();
        try {
            File myObj = new File("C:\\Users\\yassi\\OneDrive\\Bureau\\TestApp\\test\\src\\main\\webapp\\test.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                json.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
