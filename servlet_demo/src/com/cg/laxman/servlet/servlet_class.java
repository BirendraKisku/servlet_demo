package com.cg.laxman.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet_class
 */
@WebServlet("/servlet_class")
public class servlet_class extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("This prints out to console in eclipse");
		PrintWriter w=response.getWriter();
		w.println("<h3>This prints on the webpage</h3>");;
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
