package com.selenium;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit2
 */
@WebServlet("/Edit2")
public class Edit2 extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("empId"));
		String fname=request.getParameter("fnames");
		String lname=request.getParameter("lnames");
		String adress=request.getParameter("address");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String zipcode=request.getParameter("zipcode");
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
		int status=EmpImplementation.update(e);
		if(status>0) {
			System.out.println("Sucesfully");
			response.sendRedirect("InsertValues.html");
		}
		else {
			System.out.println("error");
		}
	}
}
