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
<th>Student Id</th>
<th>Student Name</th>
<th>Standard</th>
</tr>
<%
StudentOperation so=new StudentOperation();
List<Student> stdall=so.showAll();
for(Student st:stdall){
%>
<tr>
<td><%=st.getStudentId() %></td>
<td><%=st.getStudentName() %></td>
<td><%=st.getClassobj().getStandard() %></td>
</tr>
<%} %>
	</table></center>


</body></html>