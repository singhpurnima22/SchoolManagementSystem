package com.school.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dao.ClassesOperation;
import com.school.dao.StudentOperation;
import com.school.model.Classes;
import com.school.model.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AssignSubject")
public class AssignSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String classId = request.getParameter("txtclassId");
		String[] subIds = request.getParameterValues("subId");
		// String dob=request.getParameter("datepicker");
		try {
			ClassesOperation co = new ClassesOperation();
			co.assignSubject(classId, subIds);
			response.sendRedirect("Home.jsp");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
