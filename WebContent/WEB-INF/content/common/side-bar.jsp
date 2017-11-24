<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- sidebar menu -->
<div id="sidebar-menu"
	class="main_menu_side hidden-print main_menu">
	<div class="menu_section">
		<h3><s:text name="global.menu.module"></s:text> </h3>
		<ul class="nav side-menu">
			<li>
				<s:url var="dashboardUrl" action="dashboard.html" namespace="/"></s:url>
				<s:a href="%{#dashboardUrl}">
					<i class="fa fa-line-chart"></i>Dashboard
				</s:a>
			</li>
			<li>
				<s:url var="registrationFormUrl" action="registration-form.html" namespace="/patient"></s:url>
				<s:a href="%{#registrationFormUrl}">
					<i class="fa fa-user-plus"></i>Registration
				</s:a>
			</li>
			<li><a><i class="fa fa-users"></i> Patients</a>
			<li><a><i class="fa fa-institution"></i> Departments</a>
			<li>
			
				<s:url var="reportDashboardUrl" action="dashboard.html" namespace="/report"></s:url>
				<s:a href="%{#reportDashboardUrl}">
					<i class="fa fa-file"></i>Report
				</s:a>
				
			<li><a><i class="fa fa-user"></i>Users</a>
			<li><a><i class="fa fa-calendar"></i>ICU</a>
			
			<s:if test="admin">
				<li><a><i class="fa fa-cog"></i> Settings</a>
				<ul class="nav child_menu">
					<li><a href="#">Primary Settings</a></li>
					<li><a href="#">Lists</a></li>
					<li><a href="#">Profile Settings</a></li>
				</ul></li>
			</s:if>
		</ul>
	</div>
</div>
<!-- /sidebar menu -->
