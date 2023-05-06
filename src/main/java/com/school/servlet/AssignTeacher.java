package com.school.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dao.TeacherOperation;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AssignTeacher")
public class AssignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teacherId = request.getParameter("txtTeacherId");
		String[] classIds = request.getParameterValues("classId");

		try {
			TeacherOperation to = new TeacherOperation();
			to.assignTeacher(teacherId, classIds);
			response.sendRedirect("Home.jsp");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
