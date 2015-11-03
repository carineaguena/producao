<%@ page import="producao.Servidor" %>



<div class="fieldcontain ${hasErrors(bean: servidorInstance, field: 'siape', 'error')} required">
	<label for="siape">
		<g:message code="servidor.siape.label" default="Siape" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="siape" type="number" value="${servidorInstance.siape}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: servidorInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="servidor.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="50" required="" value="${servidorInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: servidorInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="servidor.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" maxlength="50" required="" value="${servidorInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: servidorInstance, field: 'ramal', 'error')} required">
	<label for="ramal">
		<g:message code="servidor.ramal.label" default="Ramal" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ramal" type="number" value="${servidorInstance.ramal}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: servidorInstance, field: 'cargo', 'error')} required">
	<label for="cargo">
		<g:message code="servidor.cargo.label" default="Cargo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cargo" name="cargo.id" from="${producao.Cargo.list()}" optionKey="id" required="" value="${servidorInstance?.cargo?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: servidorInstance, field: 'setor', 'error')} required">
	<label for="setor">
		<g:message code="servidor.setor.label" default="Setor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="setor" name="setor.id" from="${producao.Setor.list()}" optionKey="id" required="" value="${servidorInstance?.setor?.id}" class="many-to-one"/>

</div>



