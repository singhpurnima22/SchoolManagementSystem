package com.school.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dao.SubjectOperation;
import com.school.model.Subject;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddSubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("txtname");

		try {
			Subject sb = new Subject();
			sb.setSubName(name);
			SubjectOperation so = new SubjectOperation();
			so.addSubject(name);
			response.sendRedirect("Home.jsp");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
