
<% String strmovie3 =request.getParameter("entry"); %>

<script type="text/javascript">

	function node_1(){
			var xx = document.getElementById("1").value;
				location.href='index.jsp?entry=' + <% out.println(strmovie3); %> + '&node_id=' +xx;
	}
	function node_2(){
		var xx = document.getElementById("2").value;
		location.href='index.jsp?entry=' + <% out.println(strmovie3); %> + '&node_id=' +xx;
	}
	function node_3(){
		var xx = document.getElementById("3").value;
		location.href='index.jsp?entry=' + <% out.println(strmovie3); %> + '&node_id=' +xx;
	}
	function node_4(){
	var xx = document.getElementById("4").value;
	location.href='index.jsp?entry=' + <% out.println(strmovie3); %> + '&node_id=' +xx;
	}
	function node_5(){
		var xx = document.getElementById("5").value;
		location.href='index.jsp?entry=' + <% out.println(strmovie3); %> + '&node_id=' +xx;
		}
</script>



<div class="widget_1">

<div class="side_bar_menu">
    <ul>
      <li id="1" value="1" onclick= "node_1()" class="mein-menu-li home">HOME</li>
      <li id="2" value="2" onclick= "node_2()" class="mein-menu-li about-us">ABOUT US</li>
      <li id="3" value="3" onclick= "node_3()" class="mein-menu-li contact-us">MESSAGFS</li>
      <li id="4" value="4" onclick= "node_4()">CONTACT US</li>
      <li id="5" value="5" onclick= "node_5()">HELP</li>
    </ul>
  </div>



</div>
<div class="widget_2"></div>
<div class="widget_3"></div>