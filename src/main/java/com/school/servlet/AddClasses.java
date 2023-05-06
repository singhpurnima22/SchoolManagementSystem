package com.school.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dao.ClassesOperation;
import com.school.model.Classes;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddClasses")
public class AddClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddClasses() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String std = request.getParameter("txtstd");

		try {
			Classes st = new Classes();
			st.setStandard(Integer.parseInt(std));
			ClassesOperation co = new ClassesOperation();
			co.addClasses(Integer.parseInt(std));
			response.sendRedirect("Home.jsp");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
