package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SerachEmployee
 */
@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    Statement st;
    public SearchEmployee() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id;
		PrintWriter pw=response.getWriter();
		Map<String, String> result = new HashMap<String, String>(); 
		try
		{
		
	    id=Integer.parseInt(request.getParameter("eid"));
	    	
	    st=con.createStatement();  
		ResultSet rs=st.executeQuery("select * from employee where eid="+id);
		rs.next();
		result.put("id",String.valueOf(rs.getInt(1)));
		result.put("name",rs.getString(2));
		result.put("age",String.valueOf(rs.getInt(3)));
		result.put("salary",String.valueOf(rs.getFloat(4)));
		request.setAttribute("emp",result);  
	    request.getRequestDispatcher("updateemp.jsp").forward(request, response); 
	    	//pw.print(rs.getString(2));
	    	//System.out.println("Eid: "+rs.getInt(1)+"Ename: "+rs.getString(2)+"age: "+rs.getInt(3)+"salary"+rs.getFloat(4));
	    }
	
		catch(Exception e)
		{
			pw.print("invalid emp id");
		}

    }
}
