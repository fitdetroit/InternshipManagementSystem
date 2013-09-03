

<table width="100%" border="0" style="border-collapse:collapse; height: 1346px; border-top-style: none; border-top-color: inherit; border-top-width: 0px;">


	<tr>
		<td style="width: 200px; height: 1331px;" valign="top">
			<table style="border-right-color:black;border-right-style:outset">
				<tr>
					<td style="width: 200px; height: 250px;"><s:url id="url" action="GetImageCompany">
            <s:param name="userName"><s:property value="companyUserName"/> </s:param>
                </s:url>
                <img src="<s:property value='#url'/>"  width="200px" height="250px"/></td>
				</tr>

				<tr><td style="height:883px"></td></tr>

			</table>
		</td>
		<td style="height: 1331px" valign="top">
			<table width="100%" border="0">
				<tr>
					<td colspan="2" style="background-color:black;width:100%;font-family:Cambria;font-size:60px;color:teal"><s:property  value="company.companyName"></s:property></td>
				</tr>
				<tr><td style="height: 50px"></td></tr>
				<tr style="background-color:#333333">
					<td colspan="2" class="ankers"><a name="personal"></a>Company Informations</td>
				</tr>
				<tr>
					<td style="width:5%"></td>
					<td class="content1"><table style="text-align:left" width="100%">					
					<tr><td style="width:15%"><i>Company Name</i></td><td><s:property  value="company.companyName"></s:property></td></tr>
					<tr><td><i>Company Telephone</i></td><td><s:property  value="company.companyTelephone" ></s:property></td></tr>
					<tr><td><i>Contact Person</i></td><td><s:property  value="company.contactPerson"></s:property></td></tr>
					<tr><td><i>Company Address</i></td><td><s:property  value="company.companyAddress"></s:property></td></tr>
					<tr><td><i>Company Web</i></td><td><s:property  value="company.companyWeb"></s:property></td></tr>
					<tr><td><i>No of Vacancies</i></td><td><s:property  value="company.noOfVacancies"></s:property></td></tr>
										
										</table></td>
				</tr>

				

				<tr style="height:100px"></tr>
			</table>
		</td>
	</tr>

</table>

