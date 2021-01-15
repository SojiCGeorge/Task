package com.selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpImplementation {
	
	public static Connection databaseConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetails","root","");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
		
	}
	
	public static int insertion(EmpDetails e) {
		int status=0;
		try {
			Connection con=EmpImplementation.databaseConnection();
			PreparedStatement ps=con.prepareStatement("insert into details(employeeId,first_name,last_name,address,state,country,zip_code,department) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, e.getEmployeeId());
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setString(4, e.getAddress());
			ps.setString(5, e.getState());
			ps.setString(6, e.getCountry());
			ps.setString(7, e.getZipCode());
			ps.setString(8, e.getDepartment());
			status= ps.executeUpdate();
		con.close();	
		}
		
		catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}
	public static List<EmpDetails> selectAll() {
		List<EmpDetails> data=new ArrayList<EmpDetails>();
		try {
			Connection con=EmpImplementation.databaseConnection();
			PreparedStatement ps = con.prepareStatement("select * from details");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmpDetails e=new EmpDetails();
				e.setEmployeeId(Integer.parseInt(rs.getString(1)));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setState(rs.getString(5));
				e.setCountry(rs.getString(6));
				e.setZipCode(rs.getString(7));
				e.setDepartment(rs.getString(8));
				data.add(e);
			}
		
		con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return data;	
	}
	
	public static EmpDetails selectById(int id) {
		EmpDetails e= new EmpDetails();
		try {
			Connection con=EmpImplementation.databaseConnection();
			PreparedStatement ps=con.prepareStatement("select * from details where employeeId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e.setEmployeeId(rs.getInt(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setState(rs.getString(5));
				e.setCountry(rs.getString(6));
				e.setZipCode(rs.getString(7));
				e.setDepartment(rs.getString(8));	
			}
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return e;
	}
	public static int update(EmpDetails e) {
		int status=0;
		try {
			Connection con=EmpImplementation.databaseConnection();
			PreparedStatement ps=con.prepareStatement("update details set first_name=?,last_name=?,address=?,state=?,country=?,zip_code=?,department=? where employeeId=?");
			ps.setString(1, e.getFirstName());
			ps.setString(2, e.getLastName());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getState());
			ps.setString(5, e.getCountry());
			ps.setString(6, e.getZipCode());
			ps.setString(7, e.getDepartment());
			ps.setInt(8, e.getEmployeeId());
			status= ps.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}
	
	public static int delete(int id) {
		int status=0;
		try {
			Connection con=EmpImplementation.databaseConnection();
			PreparedStatement ps=con.prepareStatement("delete from details where employeeId=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}
}
