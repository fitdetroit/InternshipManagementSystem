<%
	if( request.getParameter("page") == null ){	%>
			<%@include file="header/menus/main_menu-common.jsp" %>
			
			<%	
		}
		else{
			
			if("NotAllowedComp".equals(request.getParameter("subcat")))
			{
		%>
		<%@include file="header/menus/main_menu-common.jsp" %>
		
		<%
			}//CompRegistration
			
			else if("AllowedComp".equals(request.getParameter("subcat")))
			{
		%>
		<%@include file="header/menus/main_menu_allowed_comp.jsp" %>
		
		<%
			}// AllowedComp
			
			else if("AllowedComp".equals(request.getParameter("subcat")))
			{
		%>
		<%@include file="header/menus/main_menu-common.jsp" %>
		
		<%
			}// AllowedComp
			
			else if("EditCompany".equals(request.getParameter("page")) || "CompanyViewToCompany".equals(request.getParameter("page"))){
				%>
				<%@include file="header/menus/main_menu-common.jsp" %>	
				<%
				
			}// NotAllowed
			
			
		}	  		



	%>
	
	
	
	