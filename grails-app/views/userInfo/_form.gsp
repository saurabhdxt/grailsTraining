<%@ page import="com.comp.trainingapp.UserInfo" %>



<div class="fieldcontain ${hasErrors(bean: userInfoInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="userInfo.login.label" default="Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="login" maxlength="15" required="" value="${userInfoInstance?.login}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInfoInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="userInfo.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" maxlength="15" required="" value="${userInfoInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInfoInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="userInfo.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${userInfoInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInfoInstance, field: 'age', 'error')} required">
	<label for="age">
		<g:message code="userInfo.age.label" default="Age" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="age" type="number" min="18" value="${userInfoInstance.age}" required=""/>
</div>

