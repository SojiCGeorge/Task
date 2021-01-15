package com.selenium;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<EmpDetails> list=EmpImplementation.selectAll();
		out.println("<table>");
		out.println("<tr><th>Employee Id</th><th>FirstName</th><th>LastName</th><th>Address</th><th>State</th><th>Country</th><th>Zipcode</th><th>Department</th><th>Edit</th><th>Delete</th></tr>");
		for(EmpDetails e:list) {
			out.println("<tr><td>"+e.getEmployeeId()+"</td><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getAddress()+"</td><td>"+e.getState()+"</td><td>"+e.getCountry()+"</td><td>"+e.getZipCode()+"</td><td>"+e.getDepartment()+"</td><td><a href='Edit?employeeId="+e.getEmployeeId()+"'>Edit</a></td<td><a href='Delete?employeeId="+e.getEmployeeId()+"'>delete</a></td</tr>");
		}
		out.println("</table>");
		
	}
	}