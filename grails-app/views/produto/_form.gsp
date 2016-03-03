<%@ page import="producao.Produto" %>



<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'nome', 'error')} required" style="padding-left:15px">
	<label for="nome">
		<g:message code="produto.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="50" required="" value="${produtoInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'valor', 'error')} " style="padding-left:15px">
	<label for="valor">
		<g:message code="produto.valor.label" default="Valor" />
		
	</label>
	<g:field name="valor" value="${fieldValue(bean: produtoInstance, field: 'valor')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'unidadeMedida', 'error')} required" style="padding-left:15px">
	<label for="unidadeMedida">
		<g:message code="produto.unidadeMedida.label" default="Unidade Medida" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unidadeMedida" name="unidadeMedida.id" from="${producao.Medida.list()}" optionKey="id" required="" value="${produtoInstance?.unidadeMedida?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'setorProducao', 'error')} required" style="padding-left:15px">
	<label for="setorProducao">
		<g:message code="produto.setorProducao.label" default="Setor Producao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="setorProducao" name="setorProducao.id" from="${producao.Setor.list()}" optionKey="id" required="" value="${produtoInstance?.setorProducao?.id}" class="many-to-one"/>

</div>

