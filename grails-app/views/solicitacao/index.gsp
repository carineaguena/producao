
<%@ page import="producao.Solicitacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'solicitacao.label', default: 'Solicitação')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
                    <div class="nav" role="navigation">
                        
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"> <span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-solicitacao" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-condensed">
			<thead>
					<tr>
					
						<th><g:message code="solicitacao.nomeProduto.label" default="Nome Produto" /></th>
					
						<th><g:message code="solicitacao.unidadeMedida.label" default="Unidade Medida" /></th>
					
						<g:sortableColumn property="quantidade" title="${message(code: 'solicitacao.quantidade.label', default: 'Quantidade')}" />
					
						<th><g:message code="solicitacao.setorSolicitante.label" default="Setor Solicitante" /></th>
					
						<th><g:message code="solicitacao.setorSolicitado.label" default="Setor Solicitado" /></th>
					
						<g:sortableColumn property="dataSolicitacao" title="${message(code: 'solicitacao.dataSolicitacao.label', default: 'Data Solicitação')}" />

						<th><g:message code="solicitacao.email.label" default="Email" /></th>

						<th><g:message code="solicitacao.status.label" default="Status" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${solicitacaoInstanceList}" status="i" var="solicitacaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${solicitacaoInstance.id}">${fieldValue(bean: solicitacaoInstance, field: "nomeProduto")}</g:link></td>
					
						<td>${fieldValue(bean: solicitacaoInstance, field: "unidadeMedida")}</td>
					
						<td>${fieldValue(bean: solicitacaoInstance, field: "quantidade")}</td>
					
						<td>${fieldValue(bean: solicitacaoInstance, field: "setorSolicitante")}</td>
					
						<td>${fieldValue(bean: solicitacaoInstance, field: "setorSolicitado")}</td>
					
						<td><g:formatDate format="dd-MM-yyyy" date="${solicitacaoInstance.dataSolicitacao}" /></td>

						<td>${fieldValue(bean: solicitacaoInstance, field: "email")}</td>

						<td>${fieldValue(bean: solicitacaoInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${solicitacaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
