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
<p align="center">(registed Student)</p>
<h3 align="right">Welcome! <s:property value="%{#session.userName}"/> <a href="<s:url action="../LogOut"/>">(logout)</a></h3>
</div>



<div style="float:left;width:15%; height: 672px;background=#333333">


<p align="left"><a href="<s:url action="ViewStudent"/>">click here to view profile</a></p>

<p align="left"><a href="<s:url action="ViewStudentCV"/>">click here to view cv</a></p>

<p align="left"><a href="<s:url action="ViewToUpdateStudent"/>">click here to update profile</a></p>

<p align="left"><a href="<s:url action="ViewCompanyProfile"/>">click here to view Company Profiles</a></p>
</div>



<div style="float:left;width:85%; height: 1400px;background:silver">
<h2 align="center">Student Profile Updating Form</h2>

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
<tr ><td><s:textfield  label="p1 projectTitle"  name="projectTitle1" ></s:textfield> </td><td><s:textfield  label="p1 projectDescription"  name="projectDescription1" ></s:textfield> </td><td><s:textfield label="p1 rojectYear"  name="projectYear1" ></s:textfield> </td></tr>
<tr ><td><s:textfield  label="p2 projectTitle"  name="projectTitle2" ></s:textfield> </td><td><s:textfield  label="p2 projectDescription"  name="projectDescription2" ></s:textfield> </td><td><s:textfield label="p2 rojectYear"  name="projectYear2" ></s:textfield> </td></tr>
<tr><td><s:hidden label="project id 1" name="projectId1" value="%{projectId1}"></s:hidden></td> </tr> 
<tr><td><s:hidden label="project id 1" name="projectId2" value="%{projectId2}"></s:hidden></td> </tr> 
<tr><td><s:textfield  label="Qther qulification 1"  name="otherQulification1" value="%{otherQulification1}" ></s:textfield> </td></tr>
<tr><td><s:textfield  label="Qther qulification 2"  name="otherQulification2" value="%{otherQulification2}" ></s:textfield> </td></tr>
<tr><td><s:hidden label="Qther qulification 1 id" name="otherQulificationId1" value="%{otherQulificationId1}"></s:hidden></td> </tr> 
<tr><td><s:hidden label="Qther qulification 12 id" name="otherQulificationId2" value="%{otherQulificationId2}"></s:hidden></td> </tr>
<tr><td><s:password name="password" label="New password" value="%{password}"/></td></tr>
<tr><td><s:password name="conPassword" label="Conform New password" value="%{conPassword}"/></td></tr>
<tr><td><s:hidden label="Student Hidden password" name="password2" value="%{password2}"></s:hidden></td> </tr> 
<tr><td><br></td></tr>
<tr><td align="center"><s:submit label="Save" align="center"></s:submit></td></tr>

</s:form>
</td></tr>
</table></div>



</body>

</html>
