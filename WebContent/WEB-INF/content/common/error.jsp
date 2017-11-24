<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url var="homeUrl" action="index" namespace="/" includeParams="none" />
<div class="error_msg"><s:actionerror /></div>

<br />
<br />
<br />

<div class="session">
	<img src='<s:url value="/images/oops.png" />' style="display: block;margin: 0 auto; width: 55%;max-width: 250px;" alt="ooops!" />
	<p style="text-align: center; font-family: arial; font-size: 20px; color: #00c1ff;"><s:text name="global.error.invalid.url"/></p>
	<p style="text-align: center;font-size: 22px;">
		<s:a href="%{#homeUrl}">
		<s:text name="global.return.home"/></s:a>
	</p>
</div>