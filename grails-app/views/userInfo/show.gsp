
<%@ page import="com.comp.trainingapp.UserInfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userInfo.label', default: 'UserInfo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-userInfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-userInfo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list userInfo">
			
				<g:if test="${userInfoInstance?.login}">
				<li class="fieldcontain">
					<span id="login-label" class="property-label"><g:message code="userInfo.login.label" default="Login" /></span>
					
						<span class="property-value" aria-labelledby="login-label"><g:fieldValue bean="${userInfoInstance}" field="login"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInfoInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="userInfo.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInfoInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInfoInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="userInfo.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${userInfoInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInfoInstance?.age}">
				<li class="fieldcontain">
					<span id="age-label" class="property-label"><g:message code="userInfo.age.label" default="Age" /></span>
					
						<span class="property-value" aria-labelledby="age-label"><g:fieldValue bean="${userInfoInstance}" field="age"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userInfoInstance?.id}" />
					<g:link class="edit" action="edit" id="${userInfoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
