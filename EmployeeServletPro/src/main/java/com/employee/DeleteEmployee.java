package com.employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    Statement st;
    public DeleteEmployee() {
    	super();
	    try 
	    {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb?allowPublicKeyRetrieval=true&useSSL=false","root","root");
        }
        catch(Exception e)
        {
        System.out.println(e.getMessage());
        }
    }
}