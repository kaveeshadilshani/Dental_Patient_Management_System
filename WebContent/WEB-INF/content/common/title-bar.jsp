<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-md-3 left_col">
	<div class="left_col scroll-view">
		<div class="navbar nav_title" style="border: 0;">
			<a href="index.html" class="site_title"><i
				class="fa fa-hospital-o"></i> 
				<span> 
					<s:text name="global.application.name"></s:text>	
				 </span>
			</a>
		</div>

		<div class="clearfix"></div>

		<br />

		<s:include value="/WEB-INF/content/common/side-bar.jsp"></s:include>

	</div>
</div>