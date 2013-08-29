<h3 align="right">Welcome! <s:property value="%{#session.userName}"/> <a href="<s:url action="LogOut"/>">(logout)</a></h3>

<table width="100%" border="0" style="border-collapse:collapse; height: 1346px; border-top-style: none; border-top-color: inherit; border-top-width: 0px;">


	<tr>
		<td >
			<table >
				<tr>
					<td ><s:url id="url" action="GetImageCompany">
            <s:param name="userName"><s:property value="%{#session.userName}"/> </s:param>
                </s:url>
                <img src="<s:property value='#url'/>"  width="200px" height="250px"/></td>
				</tr>

				<tr><td style="height:883px"></td></tr>

			</table>
		</td>
		<td style="height: 1331px" valign="top">
			<table width="100%" border="0">
				<tr>
					<td colspan="2" ><s:property  value="company.companyName"></s:property></td>
				</tr>
				<tr><td style="height: 50px"></td></tr>
				<tr>
					<td colspan="2" class="ankers"><a name="personal"></a>Company Informations</td>
				</tr>
				<tr>
					<td style="width:5%"></td>
					<td class="content1"><table>
					<tr><td><i>User Name</i></td><td><s:property  value="%{#session.userName}"></s:property></td></tr>
					<tr><td style="width:15%"><i>Company Name</i></td><td><s:property  value="company.companyName"></s:property></td></tr>
					<tr><td><i>Company Telephone</i></td><td><s:property  value="company.companyTelephone" ></s:property></td></tr>
					<tr><td><i>Contact Person</i></td><td><s:property  value="company.contactPerson"></s:property></td></tr>
					<tr><td><i>Company Address</i></td><td><s:property  value="company.companyAddress"></s:property></td></tr>
					<tr><td><i>Company Web</i></td><td><s:property  value="company.companyWeb"></s:property></td></tr>
					<tr><td><i>No of Vacancies</i></td><td><s:property  value="company.noOfVacancies"></s:property></td></tr>
										
										</table></td>
				</tr>
			</table>
		</td>
	</tr>

</table>
