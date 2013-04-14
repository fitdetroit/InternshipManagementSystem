<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">@import url(css/main.css);</style> <style> .errorMessage { color:red; }</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

<h2 align="center">Student Profile Updating Form</h2>
<h3 align="right">Welcome! <s:property value="%{#session.userName}"/> <a href="<s:url action="StudentLogOut"/>">(logout)</a></h3>
<br/>
<table align="center">
<tr><td><h4 >Your personal Details</h4></td></tr>
<tr><td><s:form method="post" action="UpdateStudent" enctype="multipart/form-data" validate="true">
<tr><td><s:hidden label="Student User Name" name="studentUserName" value="%{#session.userName}"></s:hidden></td> </tr> 
<tr><td><s:textfield label="Name In Full" name="nameInFull" value="%{nameInFull}"></s:textfield></td> </tr>
<tr><td><s:textfield label="Name With Initials" name="nameWithInitials" value="%{nameWithInitials}"></s:textfield></td> </tr>
<tr><td><s:select list="{'Male','Female'}" label="Gender" name="gender" value="%{gender}"></s:select> </td></tr>
<tr><td><s:select list="{'single','married'}" label="maritalStatus" name="maritalStatus" value="%{maritalStatus}"></s:select> </td></tr>
<tr><td><s:textfield  label="Date of Birth"  name="dateOfBirth" value="%{dateOfBirth}"></s:textfield> </td></tr>
<tr><td><s:textfield label="Permanent Address" name="permanentAddress" value="%{permanentAddress}"></s:textfield></td> </tr>
<tr><td><s:textfield label="Mobile No 1" name="mobile1" value="%{mobile1}"></s:textfield></td> </tr>
<tr><td><s:textfield label="Mobile No 2" name="mobile2" value="%{mobile2}"></s:textfield></td> </tr>
<tr><td><s:textfield label="Telephone" name="telephone" value="%{telephone}"></s:textfield></td> </tr>
<tr><td><s:textfield label="Email" name="email" value="%{email}"></s:textfield></td> </tr>
<tr><td><s:textfield label="School" name="school" value="%{school}"></s:textfield></td> </tr>
<tr><td><s:textfield label="A/L Subject 1" name="alSubject1" value="%{alSubject1}"></s:textfield> <s:select list="{'A','B','C','S','F'}" label="Result" name="alResult1" value="%{alResult1}"></s:select> </td></tr>
<tr><td><s:textfield label="A/L Subject 2" name="alSubject2" value="%{alSubject2}"></s:textfield> <s:select list="{'A','B','C','S','F'}" label="Result" name="alResult2" value="%{alResult2}"></s:select> </td></tr>
<tr><td><s:textfield label="A/L Subject 3" name="alSubject3" value="%{alSubject3}"></s:textfield> <s:select list="{'A','B','C','S','F'}" label="Result" name="alResult3" value="%{alResult3}"></s:select> </td></tr>
<tr><td><s:select list="{'Information Technology','Information Technology and Management'}" label="Digree Title" name="digreeTitle" value="%{digreeTitle}"></s:select> </td></tr>
<tr><td><s:textfield  label="Year Of Admission"  name="yearOfAdmission" value="%{yearOfAdmission}"></s:textfield> </td></tr>
<tr><td><s:textfield  label="GPA semester 1"  name="gpaSemester1" value="%{gpaSemester1}"></s:textfield> </td></tr>
<tr><td><s:textfield  label="GPA semester 2"  name="gpaSemester2" value="%{gpaSemester2}"></s:textfield> </td></tr>
<tr><td><s:textfield  label="GPA semester 3"  name="gpaSemester3" value="%{gpaSemester3}"></s:textfield> </td></tr>
<tr><td><s:textarea  label="Working Expirience"  name="workingExperience" value="%{workingExperience}"></s:textarea> </td></tr>
<tr><td><s:textarea  label="Projects"  name="projects"></s:textarea> </td></tr>
<tr><td><s:password name="password" label="New password" value="%{password}"/></td></tr>
<tr><td><s:password name="conPassword" label="Conform New password" value="%{conPassword}"/></td></tr>
<tr><td><s:hidden label="Student Hidden password" name="password2" value="%{password2}"></s:hidden></td> </tr> 

<tr><td align="center"><s:submit label="Save"></s:submit></td></tr>

</s:form>
</td></tr>
</table>
</body>
</html>