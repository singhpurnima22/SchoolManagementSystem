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
	<center><table width="30%" border="1" >
<tr>
<th>Subject ID</th>
<th>Name</th>
<th>Standard</th>
</tr>
<%
SubjectOperation so=new SubjectOperation();
List<Subject> sall=so.showAll();
for(Subject s:sall){
%>
<tr>
<td><%=s.getSubId() %></td>
<td><%=s.getSubName() %></td>
<td><%=s.getClassobj()!=null?s.getClassobj().getStandard():""%></td>

</tr>
<%} %>
	</table></center>

</body></html>