<%@ page import="com.comp.trainingapp.TimeStampCheck" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'timeStampCheck.label', default: 'TimeStampCheck')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-timeStampCheck" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-timeStampCheck" class="content scaffold-create" role="main">
			<h1>Time Stamp</h1>
			<trainingApptags:showCompanyDetailsTag/>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:hasErrors bean="${timeStampCheckInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${timeStampCheckInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
			<div id="timeStampFormResultsDiv">
				Initial DIV
			</div>
			
			<g:formRemote name="timeStampForm" 
				url="[controller: 'timeStampCheck', action:'saveTimeStampValues']"
				update="timeStampFormResultsDiv"
				>
			
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
				
			</g:formRemote>
			
		</div>
	</body>
</html>
