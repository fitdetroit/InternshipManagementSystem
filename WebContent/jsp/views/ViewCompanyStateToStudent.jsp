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
<h3 align="right">Welcome! <s:property value="%{#session.userName}"/> <a href="<s:url action="LogOut"/>">(logout)</a></h3>
</div>



<div style="float:left;width:15%; height: 672px;background=#333333">


<p align="left"><a href="<s:url action="student/ViewStudent"/>">click here to view profile</a></p>

<p align="left"><a href="<s:url action="student/ViewStudentCV"/>">click here to view cv</a></p>

<p align="left"><a href="<s:url action="student/ViewToUpdateStudent"/>">click here to update profile</a></p>

<p align="left"><a href="<s:url action="student/ViewStateOfCompany"/>">view State of company</a></p>

<p align="left"><a href="<s:url action="student/ViewCompanyProfile"/>">click here to view Company Profiles</a></p>
</div>



<div style="float:left;width:85%; height: 668px;background:silver">

<h4 align="center">Company State Details</h4>

<table align="center" border="1" >
<tr >
    <th width="220">Company Name:</th>
    <th width="220">State of Company</th>
    </tr>

    <s:iterator value="studentCompanyList" >
    <tr>

        <td width="220" ><s:property value="%{pk.company.companyUserName}"/> </td>
        <td width="220"><s:property value="%{state}"/> </td>

 </tr>
</s:iterator>
<s:form method="post" action="UpdateNewApplyCompany" enctype="multipart/form-data" validate="true">
<s:if test="%{newAppliedCompnay1!=null}">
<s:select list="%{studentCanAppliedCompany}"   label=" New Company Name 1" name="newAppliedCompnay1" ></s:select> 
</s:if>
<s:if test="%{newAppliedCompnay2!=null}">
<s:select list="%{studentCanAppliedCompany}"   label="New Company Name 2" name="newAppliedCompnay2"></s:select> 
</s:if>
<s:if test="%{newAppliedCompnay3!=null}">
<s:select list="%{studentCanAppliedCompany}"   label="New Company Name 3" name="newAppliedCompnay3"></s:select> 
</s:if>
<s:if test="%{newAppliedCompnay4!=null}">
<s:select list="%{studentCanAppliedCompany}"   label=" New Company Name 4" name="newAppliedCompnay4"></s:select> 
</s:if>
<s:if test="%{newAppliedCompnay5!=null}">
<s:select list="%{studentCanAppliedCompany}"   label="New Company Name 5" name="newAppliedCompnay5"></s:select> 
</s:if>

<s:if test="%{newAppliedCompnay1!=null}"><s:submit label="Apply" align="center" ></s:submit></s:if>
</s:form>


</table>

</div>



</body>

</html>
