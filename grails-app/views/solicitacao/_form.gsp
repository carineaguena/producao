<%@ page import="producao.Solicitacao" %>



<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'nomeProduto', 'error')} required" style="padding-left:15px">
	<label for="nomeProduto">
		<g:message code="solicitacao.nomeProduto.label" default="Nome Produto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="nomeProduto" name="nomeProduto.id" from="${producao.Produto.list(sort:"nome", order:"asc")}" optionKey="id" required="" value="${solicitacaoInstance?.nomeProduto?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'unidadeMedida', 'error')} required" style="padding-left:15px">
	<label for="unidadeMedida">
		<g:message code="solicitacao.unidadeMedida.label" default="Unidade Medida" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unidadeMedida" name="unidadeMedida.id" from="${producao.Medida.list()}" optionKey="id" required="" value="${solicitacaoInstance?.unidadeMedida?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'quantidade', 'error')} required" style="padding-left:15px">
	<label for="quantidade">
		<g:message code="solicitacao.quantidade.label" default="Quantidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade" value="${fieldValue(bean: solicitacaoInstance, field: 'quantidade')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'setorSolicitante', 'error')} required" style="padding-left:15px">
	<label for="setorSolicitante">
		<g:message code="solicitacao.setorSolicitante.label" default="Setor Solicitante" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="setorSolicitante" name="setorSolicitante.id" from="${producao.Setor.list(sort:"nome", order:"asc")}" optionKey="id" required="" value="${solicitacaoInstance?.setorSolicitante?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'setorSolicitado', 'error')} required" style="padding-left:15px">
	<label for="setorSolicitado">
		<g:message code="solicitacao.setorSolicitado.label" default="Setor Solicitado" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="setorSolicitado" name="setorSolicitado.id" from="${producao.Setor.list(sort:"nome", order:"asc")}" optionKey="id" required="" value="${solicitacaoInstance?.setorSolicitado?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'dataSolicitacao', 'error')} required" style="padding-left:15px">
	<label for="dataSolicitacao">
		<g:message code="solicitacao.dataSolicitacao.label" default="Data Solicitacao" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataSolicitacao" precision="day"  value="${solicitacaoInstance?.dataSolicitacao}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'email', 'error')} required" style="padding-left:15px">
	<label for="email">
		<g:message code="solicitacao.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="email" name="email.id" from="${producao.Servidor.list()}" optionKey="id" required="" value="${solicitacaoInstance?.email?.id}" class="many-to-one"/>

</div>


	<!--<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'status', 'error')} required" style="padding-left:15px">
	<label for="status">
		<g:message code="solicitacao.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>

	<g:select name="status" from="${['Solicitado', 'Atendido', 'Recusado']}" required="" value="${solicitacaoInstance?.status}"/>

</div>


</div>-->

