package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpDetails
 */
@WebServlet("/EmpDetails")
public class EmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    Statement st;
   
    public EmpDetails() {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{  
			st=con.createStatement();  
			ResultSet rs=st.executeQuery("select * from employee"); 
			PrintWriter pw=response.getWriter();
			pw.print("<html><body><table border=1><tr><th>eid</th><th>ename</th><th>age</th><th>salary</th></tr>");
		 
		while(rs.next())  
		{
		pw.print("<tr><td>"+rs.getInt(1)+"</td>");
		pw.print("<td>"+rs.getString(2)+"</td>");
		pw.print("<td>"+rs.getInt(3)+"</td>");
		pw.print("<td>"+rs.getFloat(4)+"</td></tr>");
	//	System.out.println("Eid: "+rs.getInt(1)+"Ename: "+rs.getString(2)+"age: "+rs.getInt(3)+"salary"+rs.getFloat(4));
		}
		pw.print("</table></body></html>");
		//con.close();  
		}
		catch(Exception e){ System.out.println(e);}

	}

	
}
