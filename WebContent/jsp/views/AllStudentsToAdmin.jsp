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
<h2 align="center">Administrator</h2>
<h3 align="right">Welcome! <s:property value="%{#session.userName}"/> <a href="<s:url action="AdminLogOut"/>">(logout)</a></h3>
</div>
<div style="float:left;width:15%; height: 672px;background=#333333">

<p align="left"><a href="<s:url action="AdminPage"/>">Admin page</a></p>

<p align="left"><a href="<s:url action="AllStudent"/>">View Student Details</a></p>


<p align="left"><a href="<s:url action="AllowedCompany"/>">View Allowed Company Details</a></p>

<p align="left"><a href="<s:url action="NotAllowedCompany"/>">View Not Allowed Company Details</a></p>

<p align="left"><a href="<s:url action="HaddleCv"/>">To Allow And Reject CV</a></p>

<p align="left"><a href="<s:url action="NewStudetProfiles"/>">Enter students to system</a></p>



<p align="left"><a href="<s:url action="ToRemoveStudetProfiles"/>">Remove students From system</a></p>
</div>
<div style="float:left;width:85%; height: 668px;background:silver">
<h3 align="center">All Student's Details</h3>
<table border="1" align="center">
<tr >
    <th width="220">Name In Full</th>
    <th width="220">Name With Initials</th>
    <th width="50">Gender</th>
    <th width="100">Mobile No 1</th>
    <th width="100">Mobile No 2</th>
    <th width="100">Telephone</th>
    <th width="100">Email</th>
    <th width="100">Year of Admission</th>

       <th width="150">View full profile</th>

    
    
    
</tr>
<s:iterator value="list" var="student">
    <tr>
        <td><s:property value="nameInFull"/> </td>
        <td><s:property value="nameWithInitials"/> </td>
        <td><s:property value="gender"/> </td>
        <td><s:property value="mobile1"/> </td>
        <td><s:property value="mobile2"/> </td>
        <td><s:property value="telephone"/></td>
         <td><s:property value="email"/></td>
        <td><s:property value="yearOfAdmission"/></td>

        
        <td><s:form method="post" action="StudentCvToAdmin" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="Company User Name" name="studentUserName" value="%{studentUserName}"></s:hidden></td>        
        <td><s:submit value="View" ></s:submit></td> 
        </s:form></td>
  
    </tr>
</s:iterator>
</table>
</div>

</body>

</html>
