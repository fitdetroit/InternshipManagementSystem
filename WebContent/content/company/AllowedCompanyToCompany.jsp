<div style="float:left;width:85%; height: 668px;background:silver">
<h3 align="center">Allowed Company Details</h3>
<table border="1" align="center">
<tr>
    <th width="200">Company Name</th>
    <th width="200">Company Telephone</th>
    <th width="200">Contact Persion Name</th>
    <th width="200">Address</th>
    <th width="200">Company Web</th>
    <th width="200">No of VAcancies</th>
    <th width="150">View full profile</th>

    
    
    
</tr>
<s:iterator value="list" var="student">
    <tr>
        <td><s:property value="companyName"/> </td>
        <td><s:property value="companyTelephone"/> </td>
        <td><s:property value="contactPerson"/> </td>
        <td><s:property value="companyAddress"/> </td>
        <td><s:property value="companyWeb"/> </td>
        <td><s:property value="noOfVacancies"/> </td>
        
       <td><s:form method="post" action="FullCompanyProfileToCompany" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="Company User Name" name="companyUserName" value="%{companyUserName}"></s:hidden></td>        
        <td><s:submit value="View" ></s:submit></td> 
        </s:form></td>
        

        
 
   
    </tr>
</s:iterator>
</table></div>
