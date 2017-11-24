<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<link href="<s:url value="/css/dashboard-component.css" includeParams="none"/>" rel="stylesheet" type="text/css">
	
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
				<h2>Monthly Reports</h2>
				
				<hr>

				
				<div class="row">
	            	
						<%-- <input type="date" class="form-control" id="report-Date" 
							name="customReportDaily" value='<s:property value='%{customReport.daily}' default='2017-12-01'/>'> --%>
							
					<s:form namespace="/report" action="report-pdf" method="post">
						<div class="col-md-3 col-sm-3 col-xs-12"  >
						   <input type="month" class="form-control" id="report-Week" name=customDate value='<s:property value='%{customDate}'/>'>
						   <s:hidden name="viewType" value="M"/>
						   <s:hidden name="pattern" value="%Y-%m"/>
						</div>
						<div class="col-md-3 col-sm-3 col-xs-12"  >	  
							<s:submit cssClass="btn btn-primary" value="Print" />
						</div>	
					</s:form>		
										
	            	
			    </div>
				
				
				
			</div>	
			<!-- /page content -->

		</div>
	</div>
	
	<s:include value="/WEB-INF/content/common/footer.jsp"></s:include>
	<!-- Custom Theme Scripts -->
	<s:include value="/WEB-INF/content/common/js-include.jsp" ></s:include>

</body>
</html>