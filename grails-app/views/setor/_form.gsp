<%@ page import="producao.Setor" %>



<div class="fieldcontain ${hasErrors(bean: setorInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="setor.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="50" required="" value="${setorInstance?.nome}"/>

</div>

