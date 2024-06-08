package com.employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/insertEmployee")
public class InsertEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    PreparedStatement pst;
    public InsertEmployee() {
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

	
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    
    PrintWriter pw=res.getWriter();
    String eid,ename,age,salary;
    eid=req.getParameter("eid");
    ename=req.getParameter("ename");
    age=req.getParameter("age");
    salary=req.getParameter("salary");
    
    try
    {
    	pst=con.prepareStatement("insert into employee values(?,?,?,?)");
    	pst.setString(1,eid);
    	pst.setString(2,ename);
    	pst.setString(3,age);
    	pst.setString(4,salary);
    	pst.executeUpdate();
    	//pw.println("Record is inserted suc….");
    	RequestDispatcher rd= req.getRequestDispatcher("empdetails.html");
    	rd.forward(req, res);
    }
    catch(Exception e)
    {
    res.sendError(500,e.toString());
    }
    }
    }