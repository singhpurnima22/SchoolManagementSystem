<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.school.dao.*"%>
    <%@page import="com.school.model.*"%>
    <%@page import="java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %> 
	<form action="AssignTeacher" method="post">
	<%
	TeacherOperation to = new TeacherOperation();
	List<Teacher> tList =to.showAll();
	request.setAttribute("teacherlist", tList);
	

%>
<table width="50%"  >

<tr>
<th>Teacher: </th>
<td>
  <select name="txtTeacherId">
			<c:forEach items="${teacherlist}" var="a">
				<option value="${a.tID}">${a.teacherName}</option>
			</c:forEach></select></td></tr></br>
			<tr><td></td></tr>
			<tr><td></td></tr>

<th>Subjects: </th>
<td>
	<table border="1">
					<tr>
						<th> </th>
						<th>Subject ID</th>
						<th>Name</th>
						<th>Standard</th>
					</tr>
					<%
					SubjectOperation so = new SubjectOperation();
					List<Subject> sall = so.getSubjectWithClass();
					for (Subject s : sall) {
					%>
					<tr>
						<td><input type="checkbox" name="classId" value="<%=s.getClassobj().getClassID()%>"></td>
						<td><%=s.getSubId()%></td>
						<td><%=s.getSubName()%></td>
						<td><%=s.getClassobj().getStandard()%></td>

					</tr>
					<%} %>
				</table> 
				</br></br>
		</td></tr>
			<tr>
<td>

<center><input type="submit"  value="Add" /></td></center>
<td><input type="Reset"  value="clear" /></td>
</tr>

</table>


		
	</div><br><br>



</form>
</body>
</html>