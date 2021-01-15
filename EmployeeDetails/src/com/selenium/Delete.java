package com.selenium;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id =Integer.parseInt(request.getParameter("employeeId"));
		int status=EmpImplementation.delete(id);
		if(status>0) {
			System.out.println("Sucesfully");
			response.sendRedirect("InsertValues.html");
		}
		else {
			System.out.println("error");
		}
		
	}
	
}
