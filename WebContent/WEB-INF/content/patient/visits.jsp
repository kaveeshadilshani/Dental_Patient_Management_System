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
			<%-- <s:include value="/WEB-INF/content/patient/header.jsp"></s:include> --%>
				<h3>Patient Visits</h3>

				<div class="row" style="margin-bottom: 1em;">

					<div class="col-md-4">

						<s:form namespace="/patient" action="visits.html"
							id="visitSearchForm" method="post">
							<div class="input-group">

								<div class="input-group-btn search-panel">
									<button type="button" class="btn btn-default dropdown-toggle">
										<span id="search_concept">Search</span>
									</button>
								</div>
								<input type="hidden" name="searchKey" value="serial"
									id="search_param"> <input type="text"
									class="form-control" name="searchWord"
									placeholder="Enter Patient Serial" autofocus> <span
									class="input-group-btn"> <s:submit
										cssClass="btn btn-default" type="button">
										<span class="glyphicon glyphicon-search"></span>
									</s:submit>
								</span>
							</div>
						</s:form>
					</div>

				</div>
				<div class="row" style="margin-bottom: 2em;">
					<s:form namespace="/patient" action="addVisits.html"
						id="addCommentForm" method="post">
						<div class="col-md-10">
							<input type="text" class="form-control" name="visitComment"
								placeholder="Comments" autofocus>

						</div>
						<div class="col-md-2">

							<input type="hidden" name="patientId" value=<s:property value="%{patient.serialNumber}" />>
								
							<%-- <s:a href="%{#addCommentForm}" cssClass="btn btn-primary"
								role="button">Add Visit</s:a>
							 --%>
							<s:submit
								cssClass="btn btn-primary" type="button">
								<span id="add_visit">Add Visit</span>
							</s:submit>	
							<!-- Check the Submit of new Visit - to be configured -->
							<%-- <s:a href="%{#patientHiddenUrl}" cssClass="btn btn-info" role="button">Deleted</s:a> --%>
						</div>
					</s:form>
				</div>

				<div class="row">
					<div class="col-sm-7">

						<div class="form-group">
							<div class="row" id="serialNo">
								<div class="col-xs-3" id="serialNo1">
									<label>Serial Number:</label>
								</div>
								<div class="col-xs-6" id="serialNo2">
									<s:property value="%{patient.serialNumber}" />
								</div>

								<%-- <div class="col-xs-4" id="barcode">
										<img id="barcodeImage" style="width: 200px; height: 50px" src="<s:url namespace="/image" action='bar-code.html?q=%{patient.serialNumber}' />" />									
									</div>		 --%>

							</div>
						</div>

						<div id="patient-full">
							<div class="form-group">
								<div class="row" id="name">
									<div class="col-xs-3">
										<label for="name">Patient Name:</label>
									</div>
									<div class="col-xs-6">
										<s:property value="%{patient.printName}" />
										(First name: <s:property value="%{patient.firstName}" />)
									</div>

								</div>
							</div>

							<div class="form-group">
								<div class="row" id="fileNo">
									<div class="col-xs-3">
										<label for="name">Phy. File No. :</label>
									</div>
									<div class="col-xs-6">
										<s:property value="%{patient.fileNumber}" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="row" id="sex">
									<div class="col-xs-3">
										<label for="name">Sex:</label>
									</div>
									<div class="col-xs-6">
										<s:property value="%{patient.sex}" />
									</div>

								</div>
							</div>

						</div>

						<br>
						<%-- <s:actionerror cssClass="errorMessage"/> --%>

						<s:if
							test="pager != null && pager.list != null && pager.list.size != 0">

							<table class="table table-condensed" id="patient_visit_tbl">
								<tr>
									<th>Date</th>
									<th>Department</th>
									<th>Comments</th>
								</tr>
								<s:iterator value="pager.list" status="rowIndex">
									<tr>
										<td
										<s:date name='insertDatetime' format='yyyy-MM-dd'/>><s:property
												value="%{insertDatetime}" /></td>
										<td><s:property
												value="%{department}" /></td>
												
										<td><s:property value="%{comment}" /> </td>
										
									</tr>
								</s:iterator>
							</table>

							<div class="text-center">
								<s:include value="/WEB-INF/content/common/pager.jsp"></s:include>
							</div>
						</s:if>
						<s:else>
							<div class="bg-info text-white">No Visits found</div>
						</s:else>


					</div>
					<!-- /page content -->

				</div>
			</div>
		</div>
	</div>
			
	<s:include value="/WEB-INF/content/common/footer.jsp"></s:include>
	<!-- Custom Theme Scripts -->
	<s:include value="/WEB-INF/content/common/js-include.jsp"></s:include>
</body>

</html>

