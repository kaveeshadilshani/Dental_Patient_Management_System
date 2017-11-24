<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<s:include value="/WEB-INF/content/common/meta-tags.jsp"></s:include>
<title><s:text name="global.application.title" /></title>
<s:include value="/WEB-INF/content/common/css-include.jsp"></s:include>

</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">

			<s:include value="/WEB-INF/content/common/title-bar.jsp"></s:include>
			<s:include value="/WEB-INF/content/common/top-bar.jsp"></s:include>

			<!-- page content -->
			<div class="right_col" role="main">
			<s:include value="/WEB-INF/content/patient/header.jsp"></s:include>
				<h4>Patients</h4>
				
				<s:actionerror cssClass="errorMessage"/>
			
				<s:if test="pager != null && pager.list != null && pager.list.size != 0">
				
					<table class="table table-condensed" id="patient_tbl">
  						<tr>
  							<th>Index</th>
  							<th>Name (Title, First Name)</th>
  							<th>Serial No.</th>
  							<th>Sex</th>
  							<th>Birth (Age)</th>
  							<th>Mobile</th>
  							<th>Address</th>
  							<th>Events</th>
  						</tr>
						<s:iterator value="pager.list" status="rowIndex">
						  <tr>
							<td><s:property value="%{#rowIndex.index + 1}" /> </td>
  							<td><s:property value="%{surname}"/> <s:property value="%{initials}"/> 
  								(<s:property value="%{title}"/>, <s:property value="%{firstName}"/> )</td>
  							<td title="Registered: <s:date name='insertDatetime' format='yyyy/MM/dd hh:mm'/>"><s:property value="serialNumber" /></td>
  							<td><s:property value="sex" /></td>
  							<td><s:date name="dateOfBirth" nice="true"/></td>
  							<td><s:property value="mobile" /></td>
  							<td><s:property value="address" /></td>
  							<td>
  								<s:url var="patientViewUrl" namespace="/patient" action="view.html">
  									<s:param value="%{id}" name="id"></s:param>
  								</s:url>
  								
								<s:a href="%{#patientViewUrl}" cssClass="btn btn-xs btn-primary" role="button">Add Visit</s:a>			
								<s:a href="%{#patientViewUrl}" cssClass="btn btn-xs btn-primary" role="button">View</s:a>
  								
								<s:url var="patientEditUrl" namespace="/patient" action="edit">
									<s:param name="id" value="%{id}"></s:param>
								</s:url>
								<s:a href="%{#patientEditUrl}" cssClass="btn btn-xs btn-warning">Edit</s:a>	
  							
  								<s:url var="printA4Url" namespace="/patient" action="information-pdf">
								<s:param name="id" value="%{id}"></s:param>
								</s:url>
									
								<s:a href="%{#printA4Url}" cssClass="btn btn-xs btn-success" target="_blank"> 
									<span class="glyphicon glyphicon-print">A4</span> 
								</s:a>	
								
							    <s:url var="printStickerUrl" namespace="/patient" action="sticker-pdf">
									<s:param name="id" value="%{id}"></s:param>
								</s:url>
								
								<s:a href="%{#printStickerUrl}" cssClass="btn btn-xs btn-success" target="_blank"> 
								  <span class="glyphicon glyphicon-barcode"></span>
							      <span class="glyphicon glyphicon-print"></span>
								</s:a>	
  							</td>
  						  </tr>
						</s:iterator>
					</table>
					
					<div class="text-center">
	                   <s:include value="/WEB-INF/content/common/pager.jsp" ></s:include>
	                </div>
				</s:if>
				<s:else>
					<div class="bg-info text-white">No patients found</div>				
				</s:else> 

				
			</div>
			<!-- /page content -->

		</div>
	</div>
	<s:include value="/WEB-INF/content/common/footer.jsp"></s:include>
	<!-- Custom Theme Scripts -->
	<s:include value="/WEB-INF/content/common/js-include.jsp"></s:include>
</body>
</html>
