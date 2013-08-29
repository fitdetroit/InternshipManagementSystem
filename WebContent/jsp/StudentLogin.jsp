<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login Page</title>
</head>
<body>
<h2 align="center">Student login page</h2>

	<table align="center">
	<tr><td><h3 align="left">Student</h3></td> </tr>
	<tr><td><s:form method="post" action="student/CheckStudent" >

		<tr><td><s:textfield label="UserName" name="userName" /></td> </tr>
		<tr><td><s:password label="Password" name="password" /></td> </tr>
		<tr><td><s:submit label="Login" value="Login"></s:submit></td> </tr>

	</s:form></td></tr>
	</table>
</body>
</html>