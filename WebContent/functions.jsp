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
			
			else if("SelectedForInterviewToCompnay".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/SelectedForInterviewToCompnay.jsp" %>
		
		<%
			}//SelectedForInterviewToCompnay
			
			else if("SelectedForInternshipToCompany".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/SelectedForInternshipToCompany.jsp" %>
		
		<%
			}//SelectedForInternshipToCompany
			
			else if("AllowedCompanyToCompany".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/AllowedCompanyToCompany.jsp" %>
		
		<%
			}//AllowedCompanyToCompany
		
			else if("FullCompanyToCompany".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/FullCompanyToCompany.jsp" %>
		
		<%
			}//FullCompanyToCompany
			else if("ManageStudents".equals(request.getParameter("page")))
			{
		%>
		<%@include file="content/company/ManageStudents.jsp" %>
		
		<%
			}
		//ManageStudents
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
	
	
	
	