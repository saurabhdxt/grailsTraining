<%@ page import="com.comp.trainingapp.Company" %>



<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'companyName', 'error')} ">
	<label for="companyName">
		<g:message code="company.companyName.label" default="Company Name" />
		
	</label>
	<g:textField name="companyName" value="${companyInstance?.companyName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'companyProperties', 'error')} ">
	<label for="companyProperties">
		<g:message code="company.companyProperties.label" default="Company Properties" />
		
	</label>
	<g:textField name="companyProperties" value="${companyInstance?.companyProperties}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'departmentList', 'error')} ">
	<label for="departmentList">
		<g:message code="company.departmentList.label" default="Department List" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${companyInstance?.departmentList?}" var="d">
    <li><g:link controller="department" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="department" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'department.label', default: 'Department')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'field', 'error')} ">
	<label for="field">
		<g:message code="company.field.label" default="Field" />
		
	</label>
	<g:textField name="field" value="${companyInstance?.field}"/>
</div>

