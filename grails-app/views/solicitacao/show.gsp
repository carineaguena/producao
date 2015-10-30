
<%@ page import="producao.Solicitacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'solicitacao.label', default: 'Solicitacao')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
            
            
		<div class="nav" role="navigation">
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"><span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><span class="icon icon-list" aria-hidden="true"></span> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-solicitacao" class="content scaffold-show" role="main">
			<h3><g:message code="default.show.label" args="[entityName]" /></h3>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list solicitacao">
			
				<g:if test="${solicitacaoInstance?.nomeProduto}">
				<li class="fieldcontain">
					<span id="nomeProduto-label" class="property-label"><g:message code="solicitacao.nomeProduto.label" default="Nome Produto" /></span>
					
						<span class="property-value" aria-labelledby="nomeProduto-label"><g:link controller="produto" action="show" id="${solicitacaoInstance?.nomeProduto?.id}">${solicitacaoInstance?.nomeProduto?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitacaoInstance?.unidadeMedida}">
				<li class="fieldcontain">
					<span id="unidadeMedida-label" class="property-label"><g:message code="solicitacao.unidadeMedida.label" default="Unidade Medida" /></span>
					
						<span class="property-value" aria-labelledby="unidadeMedida-label"><g:link controller="medida" action="show" id="${solicitacaoInstance?.unidadeMedida?.id}">${solicitacaoInstance?.unidadeMedida?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitacaoInstance?.quantidade}">
				<li class="fieldcontain">
					<span id="quantidade-label" class="property-label"><g:message code="solicitacao.quantidade.label" default="Quantidade" /></span>
					
						<span class="property-value" aria-labelledby="quantidade-label"><g:fieldValue bean="${solicitacaoInstance}" field="quantidade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitacaoInstance?.setorSolicitante}">
				<li class="fieldcontain">
					<span id="setorSolicitante-label" class="property-label"><g:message code="solicitacao.setorSolicitante.label" default="Setor Solicitante" /></span>
					
						<span class="property-value" aria-labelledby="setorSolicitante-label"><g:link controller="setor" action="show" id="${solicitacaoInstance?.setorSolicitante?.id}">${solicitacaoInstance?.setorSolicitante?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitacaoInstance?.setorSolicitado}">
				<li class="fieldcontain">
					<span id="setorSolicitado-label" class="property-label"><g:message code="solicitacao.setorSolicitado.label" default="Setor Solicitado" /></span>
					
						<span class="property-value" aria-labelledby="setorSolicitado-label"><g:link controller="setor" action="show" id="${solicitacaoInstance?.setorSolicitado?.id}">${solicitacaoInstance?.setorSolicitado?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitacaoInstance?.dataSolicitacao}">
				<li class="fieldcontain">
					<span id="dataSolicitacao-label" class="property-label"><g:message code="solicitacao.dataSolicitacao.label" default="Data Solicitacao" /></span>
					
						<span class="property-value" aria-labelledby="dataSolicitacao-label"><g:formatDate date="${solicitacaoInstance?.dataSolicitacao}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitacaoInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="solicitacao.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:link controller="servidor" action="show" id="${solicitacaoInstance?.email?.id}">${solicitacaoInstance?.email?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:solicitacaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit " action="edit" resource="${solicitacaoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
