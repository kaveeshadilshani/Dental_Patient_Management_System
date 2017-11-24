<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="pager != null && pager.list != null && pager.list.size != 0">
	<hr style="margin: 0px;"/>
	<div class="center" style="text-align:center;">
		Total Records: <s:property value="pager.total"/>
	</div>
	<div class="center" title="Total : <s:property value="pager.total"/>" style="text-align:center;">
	   			
		<ul class="pagination pagination-sm">
		
			<!-- FIRST -->
			<s:if test="pager.firstEnable == true">
				<s:url var="firstUrl" namespace="%{pager.namespace}" action="%{pager.actionName}" escapeAmp="false" >
						<s:param name="pageStart" value="0"/>
						<s:param name="pageSize" value="%{pager.size}"/>
						<s:param name="paging">true</s:param>
				</s:url>
				
				<li><s:a href="%{#firstUrl}">First</s:a></li>
			</s:if>
			<s:else>
			 	<li class="disabled"><a href="#">First</a></li>
			</s:else>
		  
			<!-- PREVIOUS -->
			<s:if test="pager.previousEnable == true">
				<s:url var="previousUrl" namespace="%{pager.namespace}" action="%{pager.actionName}" escapeAmp="false" >
						<s:param name="pageStart" value="%{pager.start - pager.size}"/>
						<s:param name="pageSize" value="%{pager.size}"/>
						<s:param name="paging">true</s:param>
				</s:url>
				
			 	<li><s:a href="%{#previousUrl}">Prev</s:a></li>
			</s:if>
			<s:else>
			 	<li class="disabled"><a href="#">Prev</a></li>
			</s:else>
	
			<!-- PAGES -->
			<s:if test="pager.numberOfPages <= pager.limit">
				<s:set name="countbegin" value="1"/>
				<s:set name="countend" value="pager.numberOfPages"/>
			</s:if>
			<s:elseif test="pager.pageNumber <= pager.activePosition">
				<s:set name="countbegin" value="1"/>
				<s:set name="countend" value="pager.limit"/>
			</s:elseif>
			<s:elseif test="(pager.pageNumber + pager.activePosition -1) > pager.numberOfPages">
				<s:set name="countbegin" value="%{pager.numberOfPages - pager.limit + 1}"/>
				<s:set name="countend" value="pager.numberOfPages"/>
			</s:elseif>		
			<s:else>
				<s:set name="countbegin" value="%{pager.pageNumber - pager.activePosition +1}"/>
				<s:set name="countend" value="%{#countbegin  + pager.limit -1}"/>
			</s:else>
			
			<s:iterator var="counter" begin="#countbegin" end="#countend" status="pageIndex">				
				<s:url var="pageUrl" namespace="%{pager.namespace}" action="%{pager.actionName}" escapeAmp="false" >
						<s:param name="pageStart" value="%{pager.size * (#countbegin + #pageIndex.index - 1)}"/>
						<s:param name="pageSize" value="%{pager.size}"/>
						<s:param name="paging">true</s:param>
				</s:url>
				
			 	<s:if test="pager.pageNumber == (#countbegin + #pageIndex.index)">
			  		<li class="active">
			  	</s:if>
			  	<s:else>
			  		<li>
			  	</s:else>			  	
			  	<s:a href="%{#pageUrl}"><s:property value="%{#countbegin + #pageIndex.index}" /></s:a></li>			  		
			</s:iterator>
	
			<!-- NEXT --> 
			<s:if test="pager.nextEnable == true">
				<s:url var="nextUrl" namespace="%{pager.namespace}" action="%{pager.actionName}" escapeAmp="false">
					    <s:param name="pageSize" value="%{pager.size}"/>
						<s:param name="pageStart" value="%{pager.start + pager.size}"/>
						<s:param name="searchCallList" value="%{searchCallList}"/>
						<s:param name="paging">true</s:param>
				</s:url>
				<li><s:a href="%{#nextUrl}">Next</s:a></li>
			</s:if>
			<s:else>
			  	<li class="disabled"><a href="#">Next</a></li>
			</s:else>
			
			<!-- LAST -->
			<s:if test="pager.lastEnable == true">
				<s:url var="lastUrl" namespace="%{pager.namespace}" action="%{pager.actionName}" escapeAmp="false" >
						<s:param name="pageStart" value="%{((pager.total-1) / pager.size)* pager.size}"/>
						<s:param name="pageSize" value="%{pager.size}"/>
						<s:param name="paging">true</s:param>
				</s:url>
				
			 	<li><s:a href="%{#lastUrl}">Last</s:a></li>
			</s:if>
			<s:else>
			 	<li class="disabled"><a href="#">Last</a></li>
			</s:else>
		</ul>
	</div>
	
	
	
	<script type="text/javascript">
		function getURLParameter(url, name) {
		    return (RegExp(name + '=' + '(.+?)(&|$)').exec(url)||[,null])[1];
		}
		
		$(document).ready(function(){
		
			$("ul.pagination li a").click(function(e){
				var searchform = $(".mainsearchform").find('form');
				var isDisabled = $(this).parent(".disabled").length;

				if(searchform.length && !isDisabled){
					e.preventDefault();
					var href = $(this).attr('href');
					
					var actionUrl = href.substring(0,href.indexOf("?")); 
					
					var pageStart = $("<input>")
					               .attr("type", "hidden")
					               .attr("name", "pageStart").val(getURLParameter(href, 'pageStart'));
					var pageSize = $("<input>")
					               .attr("type", "hidden")
					               .attr("name", "pageSize").val(getURLParameter(href, 'pageSize'));
					               
					searchform.append($(pageStart));	
					searchform.append($(pageSize));
					searchform.attr('action',actionUrl);
					searchform.submit();
				}			
			});
		});
	
	</script>
</s:if>