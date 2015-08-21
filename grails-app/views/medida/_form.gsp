<%@ page import="producao.Medida" %>



<div class="fieldcontain ${hasErrors(bean: medidaInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="medida.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" maxlength="50" required="" value="${medidaInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: medidaInstance, field: 'tipo', 'error')} required">
	<label for="tipo">
		<g:message code="medida.tipo.label" default="Tipo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="tipo" maxlength="50" required="" value="${medidaInstance?.tipo}"/>

</div>

