package com.ensialligence.web.rest.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException{
	
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		//req.getRequestDispatcher("path").forward(req, resp);
	
	}

}
