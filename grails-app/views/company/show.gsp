
<%@ page import="com.comp.trainingapp.Company" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-company" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list company">
			
				<g:if test="${companyInstance?.companyName}">
				<li class="fieldcontain">
					<span id="companyName-label" class="property-label"><g:message code="company.companyName.label" default="Company Name" /></span>
					
						<span class="property-value" aria-labelledby="companyName-label"><g:fieldValue bean="${companyInstance}" field="companyName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.companyProperties}">
				<li class="fieldcontain">
					<span id="companyProperties-label" class="property-label"><g:message code="company.companyProperties.label" default="Company Properties" /></span>
					
						<span class="property-value" aria-labelledby="companyProperties-label"><g:fieldValue bean="${companyInstance}" field="companyProperties"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.departmentList}">
				<li class="fieldcontain">
					<span id="departmentList-label" class="property-label"><g:message code="company.departmentList.label" default="Department List" /></span>
					
						<g:each in="${companyInstance.departmentList}" var="d">
						<span class="property-value" aria-labelledby="departmentList-label"><g:link controller="department" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.field}">
				<li class="fieldcontain">
					<span id="field-label" class="property-label"><g:message code="company.field.label" default="Field" /></span>
					
						<span class="property-value" aria-labelledby="field-label"><g:fieldValue bean="${companyInstance}" field="field"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${companyInstance?.id}" />
					<g:link class="edit" action="edit" id="${companyInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
