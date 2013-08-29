<%
	if( request.getParameter("page") == null ){	
		
		}
		else{
			
			if("CompRegistration".equals(request.getParameter("page")))
			{

			}// CompRegistration
			
			else if("AllowedComp".equals(request.getParameter("subcat"))){
				%>
				<%@include file="header/menus/widget_side_menu_allowed_comp.jsp" %>	
				<%
				
			}// AllowedComp
			
			else if("NotAllowedComp".equals(request.getParameter("subcat"))){
				%>
				<%@include file="header/menus/widget_side_menu_notallowed_comp.jsp" %>	
				<%
				
			}// NotAllowed
			
			else if("EditCompany".equals(request.getParameter("page")) || "CompanyViewToCompany".equals(request.getParameter("page"))){
				%>
				<%@include file="header/menus/widget_side_menu_notallowed_comp.jsp" %>	
				<%
				
			}// NotAllowed
		}	  		



	%>


