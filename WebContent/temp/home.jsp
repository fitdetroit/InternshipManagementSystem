

<style>.main_menu ul li.home{ background:#FFFFFF; border-radius:5px 5px 0 0; border:none; height:34px}</style>


This is home page<br>
value is <%= request.getParameter("entry") %><br>

<input type="hidden" name="test" value="<%= request.getParameter("entry") %>"/>


<% String strmovie3 =request.getParameter("test");%>hidden 
	
	<% out.println(strmovie3);%><br>

node_id <%= request.getParameter("node_id") %><br>



