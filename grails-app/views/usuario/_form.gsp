<%@ page import="producao.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'login', 'error')} required" style="padding-left:15px">
	<label for="login">
		<g:message code="usuario.login.label" default="Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${session.usuario.name == 'Administrador'}">
		<g:textField name="login" required="" value="${usuarioInstance?.login}"/>
	</g:if>
	<g:else>
		<g:textField name="login" required="" value="${usuarioInstance?.login}" disabled="true"/>
	</g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required" style="padding-left:15px">
	<label for="password">
		<g:message code="usuario.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="password" required="" />

</div>

 
<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required" style="padding-left:15px">
	<label for="confirmacao">
		<g:message code="usuario.confirmacao.label" default="Confirme a Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="confirmacao" required="" id="confirmacao"/>

</div>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'name', 'error')} required" style="padding-left:15px">
	<label for="name">
		<g:message code="usuario.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${session.usuario.name == 'Administrador'}">
		<g:textField name="name" required="" value="${usuarioInstance?.name}"/>
	</g:if>
	<g:else>
		<g:textField name="name" required="" value="${usuarioInstance?.name}" disabled="true"/>
	</g:else>
</div>

