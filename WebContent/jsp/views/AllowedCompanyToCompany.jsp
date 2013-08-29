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
<h2 align="center">Company</h2>
<h3 align="right">Welcome! <s:property value="%{#session.userName}"/> <a href="<s:url action="../LogOut"/>">(logout)</a></h3></div>



<div style="float:left;width:15%; height: 672px;background=#333333">

<p align="left"><a href="<s:url action="CompanyPage"/>">company logged in page</a></p>

<p align="left"><a href="<s:url action="ViewCompany"/>">click here to view company</a></p>

<p align="left"><a href="<s:url action="ViewToUpdateCompany"/>">click here to update company</a></p>

<p align="left"><a href="<s:url action="ViewStudentToCompany"/>">click here view applied students</a></p>

<p align="left"><a href="<s:url action="SelectForInterview"/>">Select Students To interview</a></p>

<p align="left"><a href="<s:url action="SelectedForInterview"/>">Selected Students for interview</a></p>

<p align="left"><a href="<s:url action="company/SelectedForInternship"/>">Selected Students for internship</a></p>

<p align="left"><a href="<s:url action="AllowedCompanyToCompany"/>">View Allowed Company Details</a></p>
</div>



<div style="float:left;width:85%; height: 668px;background:silver">
<h3 align="center">Allowed Company Details</h3>
<table border="1" align="center">
<tr>
    <th width="200">Company Name</th>
    <th width="200">Company Telephone</th>
    <th width="200">Contact Persion Name</th>
    <th width="200">Address</th>
    <th width="200">Company Web</th>
    <th width="200">No of VAcancies</th>
    <th width="150">View full profile</th>

    
    
    
</tr>
<s:iterator value="list" var="student">
    <tr>
        <td><s:property value="companyName"/> </td>
        <td><s:property value="companyTelephone"/> </td>
        <td><s:property value="contactPerson"/> </td>
        <td><s:property value="companyAddress"/> </td>
        <td><s:property value="companyWeb"/> </td>
        <td><s:property value="noOfVacancies"/> </td>
        
       <td><s:form method="post" action="FullCompanyProfileToCompany" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="Company User Name" name="companyUserName" value="%{companyUserName}"></s:hidden></td>        
        <td><s:submit value="View" ></s:submit></td> 
        </s:form></td>
        

        
 
   
    </tr>
</s:iterator>
</table></div>



</body>

</html>
