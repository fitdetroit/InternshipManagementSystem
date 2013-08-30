<style type="text/css">
.registration_form{padding:10px; width: 960px;}
.registration_form table{border-bottom:5px solid #ffffff; width:910px; position:relative; margin-left:auto; margin-right:auto;}
.registration_form table td{ color:#999999;}
.registration_form table td.user_input_fieldset{ background:rgb(231, 238, 250); border-bottom:5px solid #ffffff; padding:0 10px 0 10px }
.registration_form table td.file_upload{ height:150px;}
.registration_form table td .user_input_label{ color: #444444}
.sub_header{ collor:#000000}
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
.help-inline-note{ color:#FF0000; font-size:0.8em; padding-top:0; float:right}
</style>
</head>
    <div class="notifi_reg-form">
      <h2>Welcome to Internship Management System</h2>
      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum</p>
    </div>
    <h3>REGISTRATION FORM</h3>
    <div class="registration_form">
     
      <s:form id="signUp" method="post" action="RegisterCompany" enctype="multipart/form-data" >
        <table cellpadding="5" cellspacing="0">
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Name of the company</label>
              <input type="text" name="companyName" class="form_inputs"/></td>
            <td class="input_notif">We'll send you an email to activate your account, so please triple-check that you've typed it correctly.</td>
          </tr>
          <tr>
            <td class="user_input_fieldset file_upload"><label class="user_input_label">Select a Profile Picture</label>
              <!-- start of image -->
              <div class="controls">
                <div class="input-prepend"> <span class="add-on"><i class="icon-camera"></i></span>
                  <!-- file upload-->
                  
                      <input type="file" class="but_change" name="ProfilePicture"/>
                  <!--end of file upload -->
                </div>
              </div></td>
            <td class="input_notif">We'll send you an email to activate your account, so please triple-check that you've typed it correctly.</td>
          </tr>
          </td>
          </tr>
          
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Username</label>
              <input type="text" name="companyUserName" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Password</label>
              <input type="password" id="password" name="password" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Repeat Password</label>
              <input type="password" name="conPassword" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Telephone</label>
              <input type="text" name="companyTelephone" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Contact Person</label>
              <input type="text" name="contactPerson" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Company Address</label>
              <input type="text" name="companyAddress" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Website URL</label>
              <input type="text" name="companyWeb" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Number of Vacansies</label>
              <input type="text" name="noOfVacancies" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          <tr>
        </table>

<table cellpadding="5" cellspacing="0">
          <tr><td colspan="2" class="sub_header">Spacification</td></tr>
		  <tr>
            <td>
            <input type="checkbox" id="Web1"/><label for="Web1">Web Developing</label><br>
            <input type="checkbox" id="Web2"/><label for="Web2">Java</label><br>
            <input type="checkbox" id="Web3"/><label for="Web3">C# ASP .NET</label></td>
            
            
            
            <td>
            <input type="checkbox" id="Web4"/><label for="Web4">PHP</label><br>
            <input type="checkbox" id="Web5"/><label for="Web5">RUBY</label><br>
            <input type="checkbox" id="Web6"/><label for="Web6">PYTHON</label> </td>
            
            <td>
            <input type="checkbox" id="Web7"/><label for="Web7">TEXT</label><br>
            <input type="checkbox" id="Web8"/><label for="Web8">Other</label><br>
            <input type="checkbox" id="Web9"/><label for="Web9">This is a sample</label> </td>
            
            
          </tr>

		 </table>

   
      
<hr><h4>For office use only</h4><hr>         
         <table cellpadding="5" cellspacing="0">
          <tr><td colspan="2" class="sub_header">Contact Person</td></tr>
		  <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Name of the Person</label>
              <input type="text" name="" class="form_inputs"/></td>
            <td class="input_notif">We'll send you an email to activate your account, so please triple-check that you've typed it correctly.</td>
          </tr>
			<tr>
            <td class="user_input_fieldset"><label class="user_input_label">Contact Number</label>
              <input type="text" name="" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
		   <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Contact email Address</label>
              <input type="text" name="" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
		 </table>
		 
		  <table cellpadding="5" cellspacing="0">
          <tr><td colspan="2" class="sub_header">Aulternative Contact Person</td></tr>
		  <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Name of the Person</label>
              <input type="text" name="" class="form_inputs"/></td>
            <td class="input_notif">We'll send you an email to activate your account, so please triple-check that you've typed it correctly.</td>
          </tr>
			<tr>
            <td class="user_input_fieldset"><label class="user_input_label">Contact Number</label>
              <input type="text" name="" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
		   <tr>
            <td class="user_input_fieldset"><label class="user_input_label">Contact email Address</label>
              <input type="text" name="" class="form_inputs"/></td>
            <td class="input_notif"></td>
          </tr>
          
            <td colspan="3"><div class="div_verify_note">
                <label>
                <input type="checkbox"/>
                &nbsp; Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley</label>
              </div></td>
          </tr>
		 </table>	
		 
        
        
        
        
        
        
        <s:submit label="Save" id="signUp" cssClass="but_submit"></s:submit>
      </s:form>
      <p class="text_note" style="color:#999999;">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
    </div>


