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
 * Servlet implementation class SaveEmp
 */
@WebServlet("/SaveEmp")
public class SaveEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    Statement st;
    public SaveEmp() {
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

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
	    int id,age;
	    String name;
	    float sal;
	    try
	    {
	    st=con.createStatement();  
		id=Integer.parseInt(req.getParameter("eid"));
    	name=req.getParameter("ename");
	    age=Integer.parseInt(req.getParameter("age"));
	    sal=Float.parseFloat(req.getParameter("salary"));
	    System.out.println(id+","+name+","+age+","+sal);
	    st.executeUpdate("update employee set ename='"+name+"',age="+age+",salary="+sal+" where eid="+id);
	    con.commit();
	   // System.out.println("record is updated suc...");
	    pw.print("record is updated suc...");
	    }
	catch(Exception e)
	{
		
	}

}
}