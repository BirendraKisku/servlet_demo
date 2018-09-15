package com.cg.laxman.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@WebServlet("/Check_login")
public class Check_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		
		try {
			
			String role=check_database(user_name,password);
			if(role.equals("")) {
				response.sendRedirect("index.html");
			}else if(role.equals("admin")) {
				
				List<Programs> Programs_Offered = new ArrayList<Programs>();
				
				Connection conn=DataBase_Connection.getInstance().getConnection();
				Statement ps=conn.createStatement();
				ResultSet rs = ps.executeQuery(Queries.view_programs);
				
				
				while(rs.next()){
					Programs p=new Programs();
					p.setProgramName(rs.getString("ProgramName"));
					p.setDescription(rs.getString("Description"));
					p.setApplication_Eligibility(rs.getString("Applicant_Eligibility"));
					p.setDuration(rs.getInt("Duration"));
					p.setDegree_Certificate_Offered(rs.getString("Degree_Certificate_Offered"));
					Programs_Offered.add(p);	
				}
				String Programs_Json = new Gson().toJson(Programs_Offered);
				  //getServletConfig().getServletContext().getServlet("jsonCreate");
				//response.sendRedirect("admin_welcome.jsp");
				response.sendRedirect("jsonCreate");
				//RequestDispatcher rd = request.getRequestDispatcher("jsonCreate");
				//rd.forward(request,response);
			}else if(role.equals("mac")) {
				response.sendRedirect("mac_welcome.jsp");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static String check_database(String name,String pass) throws SQLException, IOException, ClassNotFoundException {
		
		Connection conn=DataBase_Connection.getInstance().getConnection();
		PreparedStatement p=null;		
		ResultSet rs = null;
		String role="";
		try{
			p=conn.prepareStatement(Queries.check_login);
			p.setString(1,name);
			p.setString(2,pass);
			rs=p.executeQuery();
			if(rs.next()) {
				role=rs.getString("role");
			}
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
		
		return role;
	}

}
