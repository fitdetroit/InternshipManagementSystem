<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Internship Management System</title>
<style type="text/css">
	.heading
	{
	color:silver;
	font-family:Cambria;
	font-size:30px;
	}
	.ldm
	{
	font-family:Cambria;
	color:gray;
	text-align:right;
	}
	.tags
	{
	color:white;
	font-family:Cambria;
	font-size:15px;
	background-color:#3E3E3E;
	text-align:right;
	}
	.ankers
	{
	font-family:Cambria;
	font-style:italic;
	font-size:20px;
	color:orange;
	}
	.content1
	{
	color:black;
	font-family:Calibri;
	font-size:15px;
	text-align:left;
	background-color:#808080;
	}
	a:link{color:white;}
	a:visited{color:white;}
	a:hover{color:yellow;}
	a:active{color:gray;}
</style>
</head>

<body bgcolor="gray">



<div style="height: 118px; background:gray" >
<h2 align="center">Internship Management System</h2>
<p align="center">(un registed Student)</p>
<h3 align="right">Welcome! <s:property value="%{#session.userName}"/> <a href="<s:url action="../LogOut"/>">(logout)</a></h3>
</div>



<div style="float:left;width:15%; height: 672px;background=#333333">


<p align="left"><a href="<s:url action="ViewCompanyProfile"/>">click here to view Company Profiles</a></p>

<p align="left"><a href="<s:url action="NewStudent"/>">click here to new register student</a><p>

<p align="left"><a href="<s:url action="ToChangePasswordStudent"/>">click here to change password</a><p>
</div>



<div style="float:left;width:85%; height: 1400px;background:silver">
<h2 align="center">Student Register Form</h2>

<table align="center">
<tr><td><h4 >Your personal Details</h4></td></tr>
<tr><td><s:form method="post" action="RegisterStudent" enctype="multipart/form-data" validate="true">
<tr><td><s:hidden label="Student User Name" name="studentUserName" value="%{#session.userName}"></s:hidden></td> </tr> 
<tr><td><s:textfield label="Name In Full" name="nameInFull"></s:textfield></td> </tr>
<tr><td><s:textfield label="Name With Initials" name="nameWithInitials"></s:textfield></td> </tr>
<tr><td><s:file label="Profile Picture" name="ProfilePicture"/></td> </tr>
<tr><td><s:select list="{'Male','Female'}" label="Gender" name="gender" ></s:select> </td></tr>
<tr><td><s:select list="{'single','married'}" label="maritalStatus" name="maritalStatus" ></s:select> </td></tr>
<tr><td><s:textfield  label="Date of Birth"  name="dateOfBirth"></s:textfield> </td></tr>
<tr><td><s:textfield label="Permanent Address" name="permanentAddress"></s:textfield></td> </tr>
<tr><td><s:textfield label="Mobile No 1" name="mobile1"></s:textfield></td> </tr>
<tr><td><s:textfield label="Mobile No 2" name="mobile2"></s:textfield></td> </tr>
<tr><td><s:textfield label="Telephone" name="telephone"></s:textfield></td> </tr>
<tr><td><s:textfield label="Email" name="email"></s:textfield></td> </tr>
<tr><td><s:textfield label="School" name="school"></s:textfield></td> </tr>
<tr><td><s:textfield label="A/L Subject 1" name="alSubject1"></s:textfield> <s:select list="{'A','B','C','S','F'}" label="Result" name="alResult1" ></s:select> </td></tr>
<tr><td><s:textfield label="A/L Subject 2" name="alSubject2"></s:textfield> <s:select list="{'A','B','C','S','F'}" label="Result" name="alResult2" ></s:select> </td></tr>
<tr><td><s:textfield label="A/L Subject 3" name="alSubject3"></s:textfield> <s:select list="{'A','B','C','S','F'}" label="Result" name="alResult3" ></s:select> </td></tr>
<tr><td><s:select list="{'Information Technology','Information Technology and Management'}" label="Digree Title" name="digreeTitle" ></s:select> </td></tr>
<tr><td><s:textfield  label="Year Of Admission"  name="yearOfAdmission"></s:textfield> </td></tr>
<tr><td><s:textfield  label="GPA semester 1"  name="gpaSemester1"></s:textfield> </td></tr>
<tr><td><s:textfield  label="GPA semester 2"  name="gpaSemester2"></s:textfield> </td></tr>
<tr><td><s:textfield  label="GPA semester 3"  name="gpaSemester3"></s:textfield> </td></tr>
<!--<tr><td><s:textarea  label="Working Expirience"  name="workingExperience" cols="50" rows="10"></s:textarea> </td></tr>-->
<!--  <tr><td><s:textarea  label="Projects"  name="projects" cols="50" rows="10"></s:textarea> </td></tr>-->
<tr ><td><s:textfield  label="p1 projectTitle"  name="projectTitle1" ></s:textfield> </td><td><s:textfield  label="p1 projectDescription"  name="projectDescription1" ></s:textfield> </td><td><s:textfield label="p1 rojectYear"  name="projectYear1" ></s:textfield> </td></tr>
<tr ><td><s:textfield  label="p2 projectTitle"  name="projectTitle2" ></s:textfield> </td><td><s:textfield  label="p2 projectDescription"  name="projectDescription2" ></s:textfield> </td><td><s:textfield label="p2 rojectYear"  name="projectYear2" ></s:textfield> </td></tr>
<tr><td><s:textfield  label="Qther qulification 1"  name="otherQulification1"></s:textfield> </td></tr>
<tr><td><s:textfield  label="Qther qulification 2"  name="otherQulification2"></s:textfield> </td></tr>
<tr><td><s:select list="%{list}"   label="Company Name 1" name="appliedCompany1"></s:select> </td></tr>
<tr><td><s:select list="%{list}"   label="Company Name 2" name="appliedCompany2"></s:select> </td></tr>
<tr><td><s:select list="%{list}"   label="Company Name 3" name="appliedCompany3"></s:select> </td></tr>
<tr><td><s:select list="%{list}"   label="Company Name 4" name="appliedCompany4"></s:select> </td></tr>
<tr><td><s:select list="%{list}"   label="Company Name 5" name="appliedCompany5"></s:select> </td></tr>
<tr><td align="center"><s:submit label="Save" align="center" ></s:submit></td></tr>

</s:form>
</td></tr>
</table></div>



</body>

</html>
