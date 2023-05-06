<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
background-image: url("image/img4.jpg");/* The image used */

  background-color: #cccccc; /* Used if the image is unavailable */
  height: 500px; /* You must set a specified height */
  background-position: center; /* Center the image */
  background-repeat: no-repeat; /* Do not repeat the image */
  background-size: cover; 
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	
}

.topnav {
	overflow: hidden;
	background-color: gray;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #04AA6D;
	color: white;
}
.center {
  margin-left: auto;
  margin-right: auto;
}
.link{
color:white;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

</style>
<title>Insert title here</title>
</head>
<body>

<div class="topnav">
		<a href="Home.jsp">Home</a> 
		<a href="About.jsp">About</a> 
		<a href="Contact.jsp">Contact</a> 
		<a href="ShowStudent.jsp">List of Students</a>
  <a href="ShowTeacher.jsp">List of Teachers</a>
  <a href="ShowSubject.jsp">List of Subjects</a>
  <a href="ShowClasses.jsp">List of Classes</a>
  <a href="AddNewClasses.jsp">Add new Classes</a>
  <a href="AddNewStudent.jsp">Add New Student</a>
  <a href="AddNewTeacher.jsp">Add New Teacher</a>
  <a href="AddNewSubject.jsp">Add New Subject</a>
  <a href="AssignSubjestToClass.jsp">Assign Subjects to a Classes</a>
  <a href="AssignTeacherToClass.jsp">Assign Teacher to Classes</a>
  <a href="FinalReport.jsp">School Report</a>
	
	</div>
		<br>
</body>
</html>