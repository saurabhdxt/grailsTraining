
<%@ page import="com.comp.trainingapp.TimeStampCheck" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'timeStampCheck.label', default: 'TimeStampCheck')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-timeStampCheck" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-timeStampCheck" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'timeStampCheck.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'timeStampCheck.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="timeStampName" title="${message(code: 'timeStampCheck.timeStampName.label', default: 'Time Stamp Name')}" />
					
						<g:sortableColumn property="timeStampProperty" title="${message(code: 'timeStampCheck.timeStampProperty.label', default: 'Time Stamp Property')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${timeStampCheckInstanceList}" status="i" var="timeStampCheckInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${timeStampCheckInstance.id}">${fieldValue(bean: timeStampCheckInstance, field: "dateCreated")}</g:link></td>
					
						<td><g:formatDate date="${timeStampCheckInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: timeStampCheckInstance, field: "timeStampName")}</td>
					
						<td>${fieldValue(bean: timeStampCheckInstance, field: "timeStampProperty")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${timeStampCheckInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
