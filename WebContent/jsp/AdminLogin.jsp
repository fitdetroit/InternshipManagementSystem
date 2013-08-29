<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="../assets/css/normalize.min.css">
        <link rel="stylesheet" href="../assets/css/main.css">
		<link rel="stylesheet" href="../assets/css/960.css">

        <script src="../assets/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<style type="text/css">
.page_header{ font-weight:600; color:#333333; margin-left:30px; font-size:1em; }
.login_table{ margin-left:auto; margin-right:auto; margin-top:40px;}
.login_table .td_label{ width:150px; height:50px;}
.login_inputs{ }

</style>
    </head>
    <body>
	
		<div class="header-content">
			<div class="container_12">
			<img src="../assets/img/university_logo.png" class="uni_logo"/><h1 class="header_text">Faculty of Information Technology - University of Moratuwa</h1>
			</div>
		</div>
		<div class="container-main container_12">
			<div class="login_content" style="height:250px; width:600px; margin-left:auto; margin-right:auto; margin-top:130px; border:1px solid #CCCCCC">
				<h3 class="page_header">Internship management System - Administration</h3>
				
				<table cellpadding="0" border="0" cellspacing="0" class="login_table">
				<s:form method="post" action="CheckAdmin" >
					<tr><td><s:textfield name="userName" cssClass="login_inputs" label="Username" /></td></tr>
					<tr><td><s:password  name="password" cssClass="login_inputs" label="Password"/></td></tr>
					<tr><td><s:hidden  name="loginPageType" value="admin"></s:hidden></td> </tr>
					<tr><td>&nbsp;</td><td><s:submit value="Sign in"  cssClass="but_login"></s:submit></td></tr>
					</s:form>
				</table>
				
			</div>


		</div>

        

        <script src="../assets/js/jquery.js"></script>
        <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="../assets/js/plugins.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>