<%@ page import="producao.Estoque" %>



<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'quantidade', 'error')} required">
	<label for="quantidade">
		<g:message code="estoque.quantidade.label" default="Quantidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade" value="${fieldValue(bean: estoqueInstance, field: 'quantidade')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'unidadeMedida', 'error')} required">
	<label for="unidadeMedida">
		<g:message code="estoque.unidadeMedida.label" default="Unidade Medida" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unidadeMedida" name="unidadeMedida.id" from="${producao.Medida.list()}" optionKey="id" required="" value="${estoqueInstance?.unidadeMedida?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'nomeProduto', 'error')} required">
	<label for="nomeProduto">
		<g:message code="estoque.nomeProduto.label" default="Nome Produto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="nomeProduto" name="nomeProduto.id" from="${producao.Produto.list()}" optionKey="id" required="" value="${estoqueInstance?.nomeProduto?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'setorProducao', 'error')} required">
	<label for="setorProducao">
		<g:message code="estoque.setorProducao.label" default="Setor Producao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="setorProducao" name="setorProducao.id" from="${producao.Setor.list()}" optionKey="id" required="" value="${estoqueInstance?.setorProducao?.id}" class="many-to-one"/>

</div>

