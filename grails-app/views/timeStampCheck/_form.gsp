<%@ page import="com.comp.trainingapp.TimeStampCheck" %>


<g:hiddenField name="id"/>

<div class="fieldcontain ${hasErrors(bean: timeStampCheckInstance, field: 'timeStampName', 'error')} ">
	<label for="timeStampName">
		<g:message code="timeStampCheck.timeStampName.label" default="Time Stamp Name" />
		
	</label>
	<g:textField name="timeStampName" value="${timeStampCheckInstance?.timeStampName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: timeStampCheckInstance, field: 'timeStampProperty', 'error')} ">
	<label for="timeStampProperty">
		<g:message code="timeStampCheck.timeStampProperty.label" default="Time Stamp Property" />
		
	</label>
	<g:textField name="timeStampProperty" value="${timeStampCheckInstance?.timeStampProperty}"/>
</div>

