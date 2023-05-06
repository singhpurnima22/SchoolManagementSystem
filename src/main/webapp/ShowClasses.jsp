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
<th>Class ID</th>
<th>Standard</th>
</tr>
<%
ClassesOperation so=new ClassesOperation();
List<Classes> call=so.showAll();
for(Classes s:call){
%>
<tr>
<td><%=s.getClassID() %></td>
<td><%=s.getStandard() %></td>
</tr>
<%} %>
	</table></center>


</body></html>