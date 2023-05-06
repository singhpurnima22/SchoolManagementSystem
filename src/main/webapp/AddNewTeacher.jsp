<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %> <br>
	<form action="AddTeacher" method="post">
<table width="50%"  >

<tr>
<th>Teacher Name:</th>
<td><input type="txt" name="txtname"></td>
</tr>
<tr>
<th> Experience:</th>
<td><input type="txt" name="txtexp"></td>
</tr>
<tr>
<td><center><input type="submit"  value="Add" /></td></center>
<td><input type="Reset"  value="clear" /></td>
</tr>
</table>
			
	</div><br><br>



</form>
</body>
</html>