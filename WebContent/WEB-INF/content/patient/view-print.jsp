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

<body onload="window.print();">
<div class="wrapper">
  <!-- Main content -->
  <section class="invoice">
    <!-- title row -->
    <div class="row">
      <div class="col-xs-12">
        <h2 class="page-header" align="center">
			<u>
				Dental Hospital (Teaching) - Peradeniya <br>
				Patient Central Record 
			</u>
        </h2>		
        <small class="pull-right">Date: 2/10/2014</small>
		<hr>
      </div>
      <!-- /.col -->
    </div>

    <!-- Table row -->
    <div class="row">
      <div class="col-xs-8">
            Serial Number:<br>
            Patient Name:<br>
            Nic number:<br>
            Date of Birth:<br>
            Sex:<br>
            Ethnicity:<br>	
      </div>
      <div class="col-xs-4">
           Sex:<br>
            Ethnicity:<br>
	
      </div>	  
	  <hr>
      <!-- /.col -->
    </div>

  </section>
  <!-- /.content -->
</div>
<!-- ./wrapper -->
</body>
</html>
