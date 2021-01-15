package com.selenium;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		int id=Integer.parseInt(request.getParameter("employeeId"));
		String fname=request.getParameter("firstName");
		String lname=request.getParameter("lastName");
		String adress=request.getParameter("address");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String zipcode=request.getParameter("zipCode");
		String department=request.getParameter("department");
		
		EmpDetails e= new EmpDetails();
		e.setEmployeeId(id);
		e.setFirstName(fname);
		e.setLastName(lname);
		e.setAddress(adress);
		e.setState(state);
		e.setCountry(country);
		e.setZipCode(zipcode);
		e.setDepartment(department);
		
		int status=EmpImplementation.insertion(e);
		if(status>0) {
			System.out.println("registration Sucessfully");
			request.getRequestDispatcher("InsertValues.html").include(request, response);
		}
		else
		{
			System.out.println("Error");
		}
			
			
		
	}

}
