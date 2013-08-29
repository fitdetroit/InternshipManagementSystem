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
<h2 align="center">Not Selected Student for Interview </h2>
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
    <th width="150">Select for the Interview</th>


    
    
    
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
        
        <td><s:form method="post" action="StudentCvToCompany" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="student user name" name="studentUserName" value="%{studentUserName}"></s:hidden></td>   
        
        <td><s:submit value="View" ></s:submit></td> 
        </s:form></td>
        
       <td> <s:if test="%{selected==true}">
         <s:form method="post" action="UpdateStateToInterview" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="student user name" name="studentUserName" value="%{studentUserName}"></s:hidden></td> 
         <td><s:hidden label="Company User Name" name="CompanyUserName" value="%{#session.userName}"></s:hidden></td>
          
        <td><s:submit value="select" disabled="true"></s:submit><p>(this student already selected)</p></td>    
        
        </s:form>
        
        </s:if>
        <s:else>      
        <s:form method="post" action="UpdateStateToInterview" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="student user name" name="studentUserName" value="%{studentUserName}"></s:hidden></td> 
         <td><s:hidden label="Company User Name" name="CompanyUserName" value="%{#session.userName}"></s:hidden></td>
          
        <td><s:submit value="select" ></s:submit></td>    
        
        </s:form>
        </s:else>
        </td>

  
    </tr>
</s:iterator>
</table>
</div>



</body>

</html>
