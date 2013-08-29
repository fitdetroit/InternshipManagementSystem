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

        <link rel="stylesheet" href="assets/css/normalize.min.css">
        <link rel="stylesheet" href="assets/css/main.css">
		<link rel="stylesheet" href="assets/css/960.css">
		<link rel="stylesheet" href="assets/css/login.css">

        <script src="assets/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
	
		<div class="header-content">
			<div class="container_12">
			<img src="assets/img/university_logo.png" class="uni_logo"/><h1 class="header_text">Faculty of Information Technology - University of Moratuwa</h1>
			</div>
		</div>
		<div class="container-main container_12">
		<h2 class="site_name">Internship Management System</h2>
		<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.  </p>
		
		<div class="welcome_disc grid_6 prefix_1">
			<h2 class="site_name">Welcome to </h2><p>Faculty of Information Technology Internship Management System</p>
		</div>
		
		<div class="login_area grid_5">
			
			<div class="login_top">
				<form method="GET" action="Login" >	
				<input type="text" name="userName" class="login_inputs" placeholder="Username"/>			
				<input type="password" name="password" class="login_inputs"  placeholder="Password" />
				<s:hidden  name="loginPageType" value="normall"></s:hidden>
				
				<s:submit value="Sign in"  cssClass="but_login"></s:submit>
				</form>
			</div>
			<div class="login_bottom">
				<label class="we-are-comp">We are a Company</label>
				<s:form method="GET" action="/NewCompany" >
				<s:submit  value="Register with Us" cssClass="but_signup" align="center"></s:submit>
				</s:form>
				
			</div>
			
		</div>
		
		
		<div class="footer_site-map grid_6">
			<ul><li>HOME</li>
				<li>INQUIRY</li>
				<li>CONTACT US</li>
				<li>ABOUT US</li>
				<li>HELP</li></ul>
		</div>
		</div>

        

        <script src="assets/js/jquery.js"></script>
        <script>window.jQuery || document.write('<script src="assets/js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>
    </body>
</html>
