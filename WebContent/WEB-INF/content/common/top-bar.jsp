<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- top navigation -->
<div class="top_nav">
	<div class="nav_menu">
		<nav>
			<div class="nav toggle">
				<a id="menu_toggle"><i class="fa fa-bars"></i></a>
			</div>

			<ul class="nav navbar-nav navbar-right">

				<li class=""><a href="javascript:;"
					class="user-profile dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"> Quick Launch <span
						class=" fa fa-angle-down"></span>
				</a>
					<ul class="dropdown-menu dropdown-usermenu pull-right">
						<li><a href="javascript:;">Help</a></li>
						<li>
							<s:url var="signOutUrl" namespace="/" action="/sign-out.html"></s:url>
							<s:a href="%{#signOutUrl}"><span
								class="fa fa-sign-out pull-right"></span> Log Out</s:a></li>
					</ul></li>

				<li class="para" title="<s:property value='%{#session.SESSION_USER.email}'/>"><s:property value="%{#session.SESSION_USER.name}"/></li>
				<li class="para"><s:property value="%{#session.SESSION_USER.roleName}"/></li>
			</ul>
		</nav>
	</div>
</div>
<!-- /top navigation -->
