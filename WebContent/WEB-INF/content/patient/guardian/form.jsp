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
				<h4>Patient information
					<s:url var="patientViewUrl" namespace="/patient" action="view.html">
						<s:param value="%{patient.id}" name="id"></s:param>
					</s:url>

				 <s:a href="%{#patientViewUrl}" cssClass="btn btn-xs btn-primary" role="button">View</s:a>
  								
				</h4>
				
				<div>
					<table class="table table-condensed" id="patient_tbl">
  						<tr>
  							<th>Name</th>
  							<th>Serial No.</th>
  							<th>Sex</th>
  							<th>Birth</th>
  							<th>Mobile</th>
  							<th>Address</th>
  						</tr>
						<tr>
  							<td><s:property value="patient.firstName" /> <s:property value="patient.surname" /> </td>
  							<td><s:property value="patient.serialNumber" /></td>
  							<td><s:property value="patient.sex" /></td>
  							<td><s:date name="patient.dateOfBirth" nice="true"/></td>
  							<td><s:property value="patient.mobile" /></td>
  							<td><s:property value="patient.address" /></td>
  						  </tr>
					</table>
				
				</div>

				<h4>Guardian information</h4>
				
				<hr />
				
				<s:form namespace="/patient-guardian" action="save" method="post">

					<s:hidden name="patientId" value="%{patient.id}"></s:hidden>
					
					<div>

						<div class="form-group">
							<div class="row">
								<div class="col-md-2 col-sm-12 col-xs-6">
									<label for="name">Guardian Relation:</label>
								</div>
								<div class="col-md-3 col-sm-4 col-xs-12">
									<s:select cssClass="form-control" name="patientGuardian.relationship" list="#{'Relative':'Relative','Institute':'Institute'}"/>										
								</div>
								
								<div class="col-md-2 col-sm-12 col-xs-6">
									<label for="name">Guardian Name:</label>
								</div>
								
								<div class="col-md-3 col-sm-4 col-xs-12">
									<s:textfield required="required" title="Name" type="text" 
									cssClass="form-control" id="name" name="patientGuardian.name" placeholder="Name"/>
								</div>
								
							</div>
						</div>
						

						<div class="form-group">
							<div class="row">
								<div class="col-md-2 col-sm-2 col-xs-12">
									<label for="phone">Phone number:</label>
								</div>
								<div class="col-md-3 col-sm-4 col-xs-12">
									<s:textfield type="text" cssClass="form-control" 
										id="phoneNo" pattern=".{10,}" title="Phone number should be ten or more characters" name="patientGuardian.telephoneMobile" />
								</div>
								<div class="col-md-2 col-sm-2 col-xs-12">
									<label for="mail">NIC:</label>
								</div>
								<div class="col-md-3 col-sm-4 col-xs-12">
									<s:textfield type="text" cssClass="form-control" 
										name="patientGuardian.nic" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<div class="col-md-2 col-sm-2 col-xs-12">
									<label for="address">Address:</label>
								</div>
								<div class="col-md-3 col-sm-4 col-xs-12">
									<s:textarea cssClass="form-control" id="address"
										name="patientGuardian.address"><s:property value='%{patientGuardian.address}' /></s:textarea>
								</div>
							</div>
						</div>

						<br>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2 col-sm-4 col-xs-12"></div>
								<s:if test="patientGuardian.id != null && !patientGuardian.id.empty">
									<div class="col-md-3 col-sm-4 col-xs-12">
										<s:submit cssClass="btn btn-warning" value="Update"></s:submit>
									</div>
								</s:if>
								<s:else>
									<div class="col-md-2 col-sm-4 col-xs-12">
										<s:submit cssClass="btn btn-success" value="Insert"></s:submit>
									</div>
								</s:else>							
							</div>
						</div>

					</div>

				</s:form>

			</div>
			<!-- /page content -->
				
		</div>
	</div>
	<s:include value="/WEB-INF/content/common/footer.jsp"></s:include>
	<!-- Custom Theme Scripts -->
	<s:include value="/WEB-INF/content/common/js-include.jsp"></s:include>
</body>
</html>
