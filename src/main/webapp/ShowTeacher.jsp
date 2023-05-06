<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.school.connection.*"%>
    <%@page import="com.school.dao.*"%>
    <%@page import="com.school.model.*"%>
     <%@page import="com.school.servlet.*"%>
     <%@page import="java.util.*"%>
     
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %> 
	<center><table width="50%" border="1">
<tr>
<th>Teacher ID</th>
<th>Name</th>
<th>Experience</th>
</tr>
<%
TeacherOperation so=new TeacherOperation();
List<Teacher> call=so.showAll();
for(Teacher t:call){
%>
<tr>
<td><%=t.gettID() %></td>
<td><%=t.getTeacherName() %></td>
<td><%=t.getExperience() %></td>
</tr>
<%} %>
	</table></center>


</body></html>