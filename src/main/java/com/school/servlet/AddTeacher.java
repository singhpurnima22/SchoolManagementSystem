package com.school.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dao.TeacherOperation;
import com.school.model.Teacher;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTeacher() {
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
		String exp = request.getParameter("txtexp");

		try {
			Teacher tr = new Teacher();
			tr.setTeacherName(name);
			tr.setExperience(Integer.parseInt(exp));
			TeacherOperation to = new TeacherOperation();
			to.addTeacher(name, Integer.parseInt(exp));
			response.sendRedirect("Home.jsp");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
