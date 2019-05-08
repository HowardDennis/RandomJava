package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.catalina.servlets.DefaultServlet;

public class HelloServlet extends DefaultServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.getWriter().write("<!DOCTYPE html><html><head></head><body><h1>Hello Interwebs!</h1></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    String data = buffer.toString();
		response.getWriter().write("Here's your stuff back: " + data);	
	}
}
