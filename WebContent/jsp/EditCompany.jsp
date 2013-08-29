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
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<style type="text/css"> <%@include file="../assets/css/normalize.css" %>  </style>
<style type="text/css">  <%@include file="../assets/css/main.css" %>  </style>
<style type="text/css">  <%@include file="../assets/css/960.css" %>  </style>
<style type="text/css">  <%@include file="../assets/css/bootstrap-fileupload.css" %> </style>
<script src="../assets/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script> <%@include file="../assets/js/jquery.js" %> </script>
<script> <%@include file="../assets/js/dropdown.js" %> </script>

<style type="text/css">
 .container { min-height: 1250px;}
.registration_form{ height: 1171px; padding:10px; width: 960px;}
.registration_form table{border-bottom:5px solid #ffffff; width:910px; position:relative; margin-left:auto; margin-right:auto;}
.registration_form table td{ color:#999999;}
.registration_form table td.user_input_fieldset{ background:rgb(231, 238, 250); border-bottom:5px solid #ffffff; padding:0 10px 0 10px }
.registration_form table td.file_upload{ height:150px;}
.registration_form table td label{ color: #444444}
.registration_form table td.input_notif{background: rgb(247, 247, 248); color:#555555; font-size:0.8em; border-bottom:5px solid #ffffff;}
.content_area{width:630px; height:1000px; float:left}
.input_name{ color: #666666}
.form_inputs{ width:490px; height:30px; margin-top:5px; margin-bottom:10px; font-size:1.2em; font-weight:400; padding-left:10px; color:#333333; border: 1px solid #d9e3f4;}
.input_comp_disc{ max-width:585px; min-width:585px; max-height:500px; padding-left:10px; font-size:1.2em; font-weight:400; color:#333333}
.fileupload-new-but{ background:rgb(57, 136, 214); padding:5px 20px 5px 20px; font-family: sans-serif; color:#EFEFEF; font-weight:600}
.fileupload-exists-but{  background:rgb(106, 177, 112); padding:5px 20px 5px 20px; font-family: sans-serif; color:#EFEFEF; font-weight:600; text-decoration:none}
.thumb-image{ background: url(../assets/img/comp_default.png); border:1px solid #d9e3f4;}
.controls{ margin-left:50px;}
.but_submit{ background:#0066CC; color:#FFFFFF; font-weight:bold; width:150px; height:35px; -webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; border:none; margin-left:450px;}
.text_note{ font-size:.8em; color:#999999; padding-top:30px;}
.div_verify_note{ color:#444444}
</style>
</head>
<body>
<div class="header_top">
  <div class="header_contariner"> <img src="../assets/img/university_logo.png" class="uni_logo"/>
    <h1>Faculty of Information Technology - University of Moratuwa</h1>
	<div class="header_right_panel">
      <ul>
        <li class="sub-menu"><%= request.getAttribute("companyName") %></li>
        <li class="">&nbsp;</li>
        <a class="account" ><img class="setting_img " src="../assets/img/settings_symbol.png"/> </a>
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
<div class="header_bottom">
  <div class="main_menu">
    <ul>
      <li class="active_li">HOME</li>
      <li>ABOUT US</li>
      <li>MESSAGFS</li>
      <li>CONTACT US</li>
      <li>HELP</li>
      <li>HOME</li>
    </ul>
  </div>
</div>
<div class="div_middle"></div>
<div class="container">
  <div class="container_left">
    <h3>UPDATE COMPANY PROFILE</h3>
    <div class="registration_form">
      <s:form method="post" action="UpdateCompany"  validate="true">
        <s:hidden name="companyUserName" value="%{companyUserName}"></s:hidden>
        <s:hidden cssClass="form_inputs" name="companyName" value="%{companyName}" ></s:hidden>
        <table cellpadding="5" cellspacing="0">
          <tr>
            <td class="user_input_fieldset"><label>Name of the company</label>
              <input type="text" name="companyName" class="form_inputs" value="<%= request.getAttribute("companyName") %>" disabled="disabled"/></td>
            <td class="input_notif">We'll send you an email to activate your account, so please triple-check that you've typed it correctly.</td>
          </tr>
          <tr>
            <td class="user_input_fieldset file_upload"><label>Select a Profile Picture</label>
              <!-- start of image -->
              <div class="controls">
                <div class="input-prepend"> <span class="add-on"><i class="icon-camera"></i></span>
                  <!-- file upload-->
                  <div class="fileupload fileupload-new" data-provides="fileupload">
                    <div class="fileupload-preview thumbnail thumb-image" style="width: 190px; height: 140px;">
                    <s:url id="url" action="GetImageCompany">
           				 <s:param name="userName"><s:property value="%{#session.userName}"/> </s:param>
                	</s:url>
               		 <img src="<s:property value='#url'/>" /></div>
                    <div> <span class="btn btn-file" > <span class="fileupload-new upload-but fileupload-new-but">Select image</span> <span class="fileupload-exists fileupload-new-but">Change</span>
                      <input type="file" name="ProfilePicture"/>
                      </span> <a href="#" class="btn fileupload-exists fileupload-exists-but" data-dismiss="fileupload">Remove</a> </div>
                  </div>
                  <!--end of file upload -->
                </div>
              </div></td>
            <td class="input_notif">We'll send you an email to activate your account, so please triple-check that you've typed it correctly.</td>
          </tr>
          </td>
          </tr>
          
          <tr>
            <td class="user_input_fieldset"><label>Username</label>
              <input type="text" name="companyUserName" class="form_inputs" value="<%= request.getAttribute("companyUserName") %>" disabled="disabled"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label>Password</label>
              <input type="password" name="password" class="form_inputs" /></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label>Repeat Password</label>
              <input type="password" name="conPassword" class="form_inputs" /></td>
               <td><s:hidden label="Company Hidden password" name="password2" value="%{company.password}" ></s:hidden></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label>Telephone</label>
              <input type="text" name="companyTelephone" class="form_inputs" value="<%= request.getAttribute("companyTelephone") %>"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label>Contact Person</label>
              <input type="text" name="contactPerson" class="form_inputs" value="<%= request.getAttribute("contactPerson") %>"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label>Company Address</label>
              <input type="text" name="companyAddress" class="form_inputs" value="<%= request.getAttribute("companyAddress") %>"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label>Website URL</label>
              <input type="text" name="companyWeb" class="form_inputs" value="<%= request.getAttribute("companyWeb") %>"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label>Number of Vacansies</label>
              <input type="text" name="noOfVacancies" class="form_inputs" value="<%= request.getAttribute("noOfVacancies") %>"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td colspan="3"><div class="div_verify_note">
                <label>
                <input type="checkbox"/>
                &nbsp; Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley</label>
              </div></td>
          </tr>
          <s:hidden cssClass="form_inputs" label="Company Hidden password" name="password2" value="%{password2}" ></s:hidden>
        </table>
        <s:submit label="Save" cssClass="but_submit"></s:submit>
      </s:form>
      <p class="text_note" style="color:#999999;">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
    </div>
  </div>
  <div class="container_right">
    <div class="widget_1"></div>
    <div class="widget_2"></div>
    <div class="widget_3"></div>
  </div>
</div>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>

<script> <%@include file="../assets/js/bootstrap-fileupload.js" %> </script>
<script> <%@include file="../assets/js/html5.js" %> </script>
</body>
</html>
