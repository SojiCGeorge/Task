package com.selenium;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id =Integer.parseInt(request.getParameter("employeeId"));
		out.println(id);
		EmpDetails e=EmpImplementation.selectById(id);
		out.println("<h2>Edit Details</h2>");
		out.println("<form action='Edit2' method='get'>");
		out.println("<table>");
		
		out.println("Employee id"+id);
		out.println("<tr><td>Employee Id</td><td><input type='text' name='empId' value='"+e.getEmployeeId()+"'></td></tr>");
		out.println("<tr><td>FirstName</td><td><input type='text' name='fnames' value='"+e.getFirstName()+"'></td></tr>");
		out.println("<tr><td>LastName</td><td><input type='text' name='lnames' value='"+e.getLastName()+"'></td></tr>");
		out.println("<tr><td>Address</td><td><input type='text' name='address' value='"+e.getAddress()+"'></td></tr>");
		out.println("<tr><td>State</td><td><input type='text' name='state' value='"+e.getState()+"'></td></tr>");
		out.println("<tr><td>Country</td><td><input type='text' name='country' value='"+e.getCountry()+"'></td></tr>");
		out.println("<tr><td>zipcode</td><td><input type='text' name='zipcode' value='"+e.getZipCode()+"'></td></tr>");
		out.println("<tr><td>Department</td><td><input type='text' name='department' value='"+e.getDepartment()+"'></td></tr>");
		out.println("<tr><td><input type='submit'value='Edit and save' ></td></tr>");
		out.println("</table>");
		out.println("</form");
		out.println();
		
	}
	
}
