<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.school.connection.*"%>
    <%@page import="com.school.dao.*"%>
    <%@page import="com.school.model.*"%>
     <%@page import="com.school.servlet.*"%>
     <%@page import="java.util.*"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.ScrollStyle
{
    max-height: 500px;
    overflow-y: scroll;
    width:80%;
}
</style>

<%@ include file="header.jsp" %>

<%
	ClassesOperation co = new ClassesOperation();
	List<Classes> classList =co.showAll();
	request.setAttribute("classlist", classList);

%>
<div  class="ScrollStyle">
<c:forEach items="${classlist}" var="c">
	<div>
		<span STYLE="font-weight:bold;text-decoration:underline">STANDARD: ${c.standard}</span> 
		</br> </br> 
		<span>STUDENTS: </span>
		<center>
			<table width="20%" border="1">
				<tr>
					<th>Student Id</th>
					<th>Student Name</th>
				</tr>
				<c:forEach items="${c.studentList}" var="st">
					<tr>
						<td>${st.studentId}</td>
						<td>${st.studentName}</td>
					</tr>
				</c:forEach>
			</table>
		</center>
		
		</br> </br> 
		<span>TEACHERS: </span>
		<center>
			<table width="20%" border="1">
				<tr>
					<th>Teacher ID</th>
					<th>Name</th>
					<th>Experience</th>
				</tr>
				<c:forEach items="${c.teacherlist}" var="t">
					<tr>
						<td>${t.tID}</td>
						<td>${t.teacherName}</td>
						<td>${t.experience}</td>
					</tr>
				</c:forEach>
			</table>
		</center>
		
		</br> </br> 
		<span>SUBJECTS: </span>
		<center>
			<table width="20%" border="1">
				<tr>
					<th>Subject ID</th>
					<th>Name</th>
				</tr>
				<c:forEach items="${c.subjectlist}" var="s">
					<tr>
						<td>${s.subId}</td>
						<td>${s.subName}</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</div>
</c:forEach>
</div>

</body></html>