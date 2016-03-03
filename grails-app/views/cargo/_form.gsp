<%@ page import="producao.Cargo" %>



<div class="fieldcontain ${hasErrors(bean: cargoInstance, field: 'nome', 'error')} required" style="padding-left:15px">
	<label for="nome">
		<g:message code="cargo.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="50" required="" value="${cargoInstance?.nome}"/>

</div>

