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
	<form action="AssignSubject" method="post">
	<%
	SubjectOperation so = new SubjectOperation();
	List<Subject> subList =so.showAll();
	request.setAttribute("subjectlist", subList);
	
	ClassesOperation co=new ClassesOperation();
	List<Classes> clsList=co.showAll();
	request.setAttribute("clslist", clsList);

%>
<table width="50%"  >

<tr>
<th>Standard: </th>
<td>
  <select name="txtclassId">
			<c:forEach items="${clslist}" var="a">
				<option value="${a.classID}">${a.standard}</option>
			</c:forEach></select></td></tr>
			<tr>
			<tr>
<th>Subjects: </th>
<td>
	<c:forEach items="${subjectlist}" var="a">
		<input type="checkbox" name="subId" value="${a.subId}"> ${a.subName}
		</br>
	</c:forEach>   
</td></tr>
			<tr>
<td><center><input type="submit"  value="Add" /></td></center>
<td><input type="Reset"  value="clear" /></td>
</tr>

</table>


		
	</div><br><br>



</form>
</body>
</html>