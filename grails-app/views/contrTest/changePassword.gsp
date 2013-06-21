

<g:if test="${flash.message}">

	${flash.message.msg1}
	<br/>
	${flash.message.msg2}
	
</g:if>

checkScope: ${checkScope} 

<g:form action="performPasswordChange">
	
	username: <g:textField name="username" />
	actualPassword: <g:textField name="actualPassword" />
	
	newPassword: <g:textField name="newPassword" />
	repNewPassword: <g:textField name="repNewPassword" />
	<br/>
	<g:submitButton name="checkRegisterCommand" />
	
</g:form>
