<div style="float:left;width:85%; height: 668px;background:silver">
<h2 align="center">Not Selected Student for Interview </h2>
<table border="1" align="center">
<tr >
    <th width="220">Name In Full</th>
    <th width="220">Name With Initials</th>
    <th width="50">Gender</th>
    <th width="100">Mobile No 1</th>
    <th width="100">Mobile No 2</th>
    <th width="100">Telephone</th>
    <th width="100">Email</th>
    <th width="100">Year of Admission</th>
    <th width="150">View full profile</th>
    <th width="150">Select for the Interview</th>


    
    
    
</tr>
<s:iterator value="list" var="student">
    <tr>
        <td><s:property value="nameInFull"/> </td>
        <td><s:property value="nameWithInitials"/> </td>
        <td><s:property value="gender"/> </td>
        <td><s:property value="mobile1"/> </td>
        <td><s:property value="mobile2"/> </td>
        <td><s:property value="telephone"/></td>
         <td><s:property value="email"/></td>
        <td><s:property value="yearOfAdmission"/></td>
        
        <td><s:form method="post" action="StudentCvToCompany" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="student user name" name="studentUserName" value="%{studentUserName}"></s:hidden></td>   
        
        <td><s:submit value="View" ></s:submit></td> 
        </s:form></td>
        
       <td> <s:if test="%{selected==true}">
         <s:form method="post" action="UpdateStateToInterview" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="student user name" name="studentUserName" value="%{studentUserName}"></s:hidden></td> 
         <td><s:hidden label="Company User Name" name="CompanyUserName" value="%{#session.userName}"></s:hidden></td>
          
        <td><s:submit value="select" disabled="true"></s:submit><p>(this student already selected)</p></td>    
        
        </s:form>
        
        </s:if>
        <s:else>      
        <s:form method="post" action="UpdateStateToInterview" enctype="multipart/form-data" validate="true">
        <td><s:hidden label="student user name" name="studentUserName" value="%{studentUserName}"></s:hidden></td> 
         <td><s:hidden label="Company User Name" name="CompanyUserName" value="%{#session.userName}"></s:hidden></td>
          
        <td><s:submit value="select" ></s:submit></td>    
        
        </s:form>
        </s:else>
        </td>

  
    </tr>
</s:iterator>
</table>
</div>


