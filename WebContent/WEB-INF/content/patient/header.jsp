<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row" style="margin-bottom:2em;">

    <div class="col-md-8 col-md-offset-1 pull-right"> 
		
		<s:form namespace="/patient" action="search.html" id="patientSearchForm" method="post">
		<div class="input-group">
               
                <div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    	<span id="search_concept">Search By</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href="#serial">Serial Number</a></li>	
                      <li><a href="#surname">Surname</a></li>
                      <li><a href="#firstname">First name</a></li>
                      <li><a href="#nic">NIC</a></li>
                                            
                      <li class="divider"></li>
                      <li><a href="#mobile">Mobile</a></li>
                      <li><a href="#email">Email</a></li>                     
                    </ul>
                </div>
                <input type="hidden" name="searchKey" value="serial" id="search_param">     
                <input type="text" class="form-control" name="searchWord" placeholder="default is serial" autofocus>
                <span class="input-group-btn">
                    <s:submit cssClass="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></s:submit>
                </span>
            </div>
            </s:form>
        </div>
		<div class="col-md-3 pull-right"> 
			<s:url var="patientListUrl" namespace="/patient" action="list.html"></s:url>
			<s:url var="patientAddUrl" namespace="/patient" action="registration-form.html"></s:url>
			<%-- <s:url var="patientHiddenUrl" namespace="/patient" action="hidden-list.html"></s:url>
			 --%>
			<s:a href="%{#patientAddUrl}" cssClass="btn btn-primary" role="button">Add New</s:a>
			<s:a href="%{#patientListUrl}" cssClass="btn btn-success" role="button">List</s:a>
			<%-- <s:a href="%{#patientHiddenUrl}" cssClass="btn btn-info" role="button">Deleted</s:a> --%>
		</div>

</div>
