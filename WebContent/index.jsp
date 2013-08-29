<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<META HTTP-EQUIV="Refresh" CONTENT="0;URL=index">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<style type="text/css">  <%@include file="assets/css/normalize.css" %>  </style>
<style type="text/css">  <%@include file="assets/css/main.css" %>  </style>
<style type="text/css">  <%@include file="assets/css/bootstrap-fileupload.css" %>  </style>


<script src="assets/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/dropdown.js"></script>
</head>
<body class="<%= request.getParameter("cat") %> <%= request.getParameter("page") %>">
<div class="header_top">
  <div class="header_contariner"> <img src="assets/img/university_logo.png" class="uni_logo"/>
    <h1>Faculty of Information Technology - University of Moratuwa</h1>
    <div class="header_right_panel">
      <ul>
        <li class="sub-menu">&nbsp;</li>
        <li class="sub-menu ">&nbsp;</li>
        <a class="account" ><img class="setting_img " src="assets/img/settings_symbol.png"/> </a>
      </ul>
      <div class="submenu">
        <ul>
          <li>
            <div class="icon_view_pro"></div>
            Veiw Profile</li>
          <li>
            <div class="icon_log_out"></div>
            Log out</li>
        </ul>
      </div>
    </div>
  </div>
</div>
<div class="header_bottom">

<%@include file="main_menu_functions.jsp"%>


</div>
<div class="div_middle"></div>
<div class="container clear">
 	<div class="container_left clear">
<%@include file="functions.jsp"%>
</div>
	<div class="container_right" >
		<%@include file="sidebar_function.jsp"%>
		<div class="widget_3">
			<h4>Nead a Help ?</h4>
			<p>Nead a Help? If you have any problem with this system you can just <a href="#">send a message</a>..</p>
		</div>
		<div class="widget_2">
			<h4>Related Links</h4>
			<ul><li><img src="assets/img/building.png">University Of Moratuwa</li>
				<li><img src="assets/img/building.png">Faculty Of Information Technology</li>
			</ul>

		</div>
	</div>


<script src="assets/js/plugins.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap-fileupload.js"></script>
<script src="assets/js/dropdown.js"></script>
</body>
</html>