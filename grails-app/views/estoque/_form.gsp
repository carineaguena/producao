<%@ page import="producao.Estoque" %>



<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'quantidade', 'error')} required" style="padding-left:15px">
	<label for="quantidade">
		<g:message code="estoque.quantidade.label" default="Quantidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade" value="${fieldValue(bean: estoqueInstance, field: 'quantidade')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'unidadeMedida', 'error')} required" style="padding-left:15px">
	<label for="unidadeMedida">
		<g:message code="estoque.unidadeMedida.label" default="Unidade Medida" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unidadeMedida" name="unidadeMedida.id" from="${producao.Medida.list()}" optionKey="id" required="" value="${estoqueInstance?.unidadeMedida?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'nomeProduto', 'error')} required" style="padding-left:15px">
	<label for="nomeProduto">
		<g:message code="estoque.nomeProduto.label" default="Nome Produto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="nomeProduto" name="nomeProduto.id" from="${producao.Produto.list(sort:"nome", order:"asc")}" optionKey="id" required="" value="${estoqueInstance?.nomeProduto?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'setorDeOrigemDoProduto', 'error')} required" style="padding-left:15px">
	<label for="setorDeOrigemDoProduto">
		<g:message code="estoque.setorDeOrigemDoProduto.label" default="Setor De Origem Do Produto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="setorDeOrigemDoProduto" name="setorDeOrigemDoProduto.id" from="${producao.Setor.list(sort:"nome", order:"asc")}" optionKey="id" required="" value="${estoqueInstance?.setorDeOrigemDoProduto?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: estoqueInstance, field: 'dataDaMovimentacao', 'error')} required" style="padding-left:15px">
	<label for="dataDaMovimentacao">
		<g:message code="estoque.dataDaMovimentacao.label" default="Data Da Movimentacao" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataDaMovimentacao" precision="day"  value="${estoqueInstance?.dataDaMovimentacao}"  />

</div>

