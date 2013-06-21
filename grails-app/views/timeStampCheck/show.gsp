
<%@ page import="com.comp.trainingapp.TimeStampCheck" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'timeStampCheck.label', default: 'TimeStampCheck')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-timeStampCheck" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-timeStampCheck" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list timeStampCheck">
			
				<g:if test="${timeStampCheckInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="timeStampCheck.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${timeStampCheckInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${timeStampCheckInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="timeStampCheck.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${timeStampCheckInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${timeStampCheckInstance?.timeStampName}">
				<li class="fieldcontain">
					<span id="timeStampName-label" class="property-label"><g:message code="timeStampCheck.timeStampName.label" default="Time Stamp Name" /></span>
					
						<span class="property-value" aria-labelledby="timeStampName-label"><g:fieldValue bean="${timeStampCheckInstance}" field="timeStampName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${timeStampCheckInstance?.timeStampProperty}">
				<li class="fieldcontain">
					<span id="timeStampProperty-label" class="property-label"><g:message code="timeStampCheck.timeStampProperty.label" default="Time Stamp Property" /></span>
					
						<span class="property-value" aria-labelledby="timeStampProperty-label"><g:fieldValue bean="${timeStampCheckInstance}" field="timeStampProperty"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${timeStampCheckInstance?.id}" />
					<g:link class="edit" action="edit" id="${timeStampCheckInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
