<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.school.dao.*"%>
    <%@page import="com.school.model.*"%>
    <%@page import="java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %> <br>

	<form action="AddStudent" method="post">
	<%
	ClassesOperation co = new ClassesOperation();
	List<Classes> classList =co.showAll();
	request.setAttribute("classlist", classList);

%>
<table width="50%"  >

<tr>
<th>Student Name:</th>
<td><input type="txt" name="txtname"></td>
</tr>
<tr>
<th>DOB:</th>
<td>Select Date : <input type="date" name="datepicker" value="2023-01-01" required></td>
</tr>

<tr>
<th>Standard: </th>
<td>
  <select name="txtclassId">
			<c:forEach items="${classlist}" var="a">
				<option value="${a.classID}">${a.standard}</option>
			</c:forEach></select></td></tr>
			<tr>
<td><center><input type="submit"  value="Add" /></td></center>
<td><input type="Reset"  value="clear" /></td>
</tr>
			
</table>


		
	</div><br><br>



</form>
</body>
</html>