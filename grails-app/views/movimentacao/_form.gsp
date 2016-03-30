<%@ page import="producao.Movimentacao" %>



<div class="fieldcontain ${hasErrors(bean: movimentacaoInstance, field: 'setorOrigem', 'error')} required" style="padding-left:15px">
	<label for="setorOrigem">
		<g:message code="movimentacao.setorOrigem.label" default="Setor Origem" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="setorOrigem" name="setorOrigem.id" from="${producao.Setor.list()}" optionKey="id" required="" value="${movimentacaoInstance?.setorOrigem?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: movimentacaoInstance, field: 'setorDestino', 'error')} required" style="padding-left:15px">
	<label for="setorDestino">
		<g:message code="movimentacao.setorDestino.label" default="Setor Destino" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="setorDestino" name="setorDestino.id" from="${producao.Setor.list(sort:"nome", order:"asc")}" optionKey="id" required="" value="${movimentacaoInstance?.setorDestino?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: movimentacaoInstance, field: 'nomeProduto', 'error')} required" style="padding-left:15px">
	<label for="nomeProduto">
		<g:message code="movimentacao.nomeProduto.label" default="Nome Produto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="nomeProduto" name="nomeProduto.id" from="${producao.Produto.list(sort:"nome", order:"asc")}" optionKey="id" required="" value="${movimentacaoInstance?.nomeProduto?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: movimentacaoInstance, field: 'quantidade', 'error')} required" style="padding-left:15px">
	<label for="quantidade">
		<g:message code="movimentacao.quantidade.label" default="Quantidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade" value="${fieldValue(bean: movimentacaoInstance, field: 'quantidade')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: movimentacaoInstance, field: 'dataMovimentacao', 'error')} required" style="padding-left:15px">
	<label for="dataMovimentacao">
		<g:message code="movimentacao.dataMovimentacao.label" default="Data Movimentacao" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataMovimentacao" precision="day"  value="${movimentacaoInstance?.dataMovimentacao}"  />

</div>

