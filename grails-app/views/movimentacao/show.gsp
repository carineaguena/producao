
<%@ page import="producao.Movimentacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'movimentacao.label', default: 'Movimentacao')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
            
            
		<div class="nav" role="navigation">
			<ul class="nav nav-tabs nav-justified" style="padding-left:15px">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"><span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><span class="icon icon-list" aria-hidden="true"></span> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-movimentacao" class="content scaffold-show" role="main" style="padding-left:15px">
			<h3><g:message code="default.show.label" args="[entityName]" /></h3>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list movimentacao">
			
				<g:if test="${movimentacaoInstance?.setorOrigem}">
				<li class="fieldcontain">
					<span id="setorOrigem-label" class="property-label"><g:message code="movimentacao.setorOrigem.label" default="Setor Origem" /></span>
					
						<span class="property-value" aria-labelledby="setorOrigem-label"><g:link controller="setor" action="show" id="${movimentacaoInstance?.setorOrigem?.id}">${movimentacaoInstance?.setorOrigem?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${movimentacaoInstance?.setorDestino}">
				<li class="fieldcontain">
					<span id="setorDestino-label" class="property-label"><g:message code="movimentacao.setorDestino.label" default="Setor Destino" /></span>
					
						<span class="property-value" aria-labelledby="setorDestino-label"><g:link controller="setor" action="show" id="${movimentacaoInstance?.setorDestino?.id}">${movimentacaoInstance?.setorDestino?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${movimentacaoInstance?.nomeProduto}">
				<li class="fieldcontain">
					<span id="nomeProduto-label" class="property-label"><g:message code="movimentacao.nomeProduto.label" default="Nome Produto" /></span>
					
						<span class="property-value" aria-labelledby="nomeProduto-label"><g:link controller="produto" action="show" id="${movimentacaoInstance?.nomeProduto?.id}">${movimentacaoInstance?.nomeProduto?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${movimentacaoInstance?.quantidade}">
				<li class="fieldcontain">
					<span id="quantidade-label" class="property-label"><g:message code="movimentacao.quantidade.label" default="Quantidade" /></span>
					
						<span class="property-value" aria-labelledby="quantidade-label"><g:fieldValue bean="${movimentacaoInstance}" field="quantidade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${movimentacaoInstance?.dataMovimentacao}">
				<li class="fieldcontain">
					<span id="dataMovimentacao-label" class="property-label"><g:message code="movimentacao.dataMovimentacao.label" default="Data Movimentacao" /></span>
					
						<span class="property-value" aria-labelledby="dataMovimentacao-label"><g:formatDate format="dd/MM/yyyy" date="${movimentacaoInstance?.dataMovimentacao}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:movimentacaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit " action="edit" resource="${movimentacaoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
