<%
	if( request.getParameter("page") == null ){	%>
			<%@include file="temp/home.jsp" %>
			
			<%	
		}
		else{
			
			if("CompRegistration".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/CompanyRegistrationForm.jsp" %>
		
		<%
			}// CompRegistration
			
			else if(request.getParameter("page") == null || "AllowedCompHomepage".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/AllowedCompany.jsp" %>
		
		<%
			}//AllowedCompHomepage
			
			else if("CompanyViewToCompany".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/CompanyViewToCompany.jsp" %>
		
		<%
			}// CompanyViewToCompany
			
			else if("EditCompany".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/EditCompany.jsp" %>
		
		<%
			}// EditCompany
			
			else if("NotSelectForInterviewToCompany".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/NotSelectForInterviewToCompany.jsp" %>
		
		<%
			}// NotSelectForInterviewToCompany
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////  Not Allowed Company
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			else if("NotAllowedCompany".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/NotAllowedCompany.jsp" %>
		
		<%
			}// NotAllowedCompany
			
		}	  		



	%>
	
	
	
	