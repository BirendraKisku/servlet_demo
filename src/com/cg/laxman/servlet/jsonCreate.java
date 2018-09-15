package com.cg.laxman.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class jsonCreate
 */
@WebServlet("/jsonCreate")
public class jsonCreate extends HttpServlet {
	
	public static List<Programs> list() throws SQLException, IOException {
		
		
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
		return Programs_Offered;
		}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsonCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Programs> categories=null;
		try {
			categories = jsonCreate.list();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String categoriesJson = new Gson().toJson(categories);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(categoriesJson);
        //RequestDispatcher rd = request.getRequestDispatcher("admin_welcome.jsp");
		//rd.forward(request,response);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("variable", categoriesJson);
        response.sendRedirect("admin_welcome.jsp");
        
		//response.sendRedirect("admin_welcome.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
