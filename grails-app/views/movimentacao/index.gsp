
<%@ page import="producao.Movimentacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'movimentacao.label', default: 'Movimentação')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
                    <div class="nav" role="navigation">
                        
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"> <span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				
				<!--Link de alteracao removido-->				
				<!--<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>-->
			
			</ul>
		</div>
		<div id="list-movimentacao" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-condensed">
			<thead>
					<tr>
					
						<th><g:message code="movimentacao.setorOrigem.label" default="Setor Origem" /></th>
					
						<th><g:message code="movimentacao.setorDestino.label" default="Setor Destino" /></th>
					
						<th><g:message code="movimentacao.nomeProduto.label" default="Nome Produto" /></th>
					
						<g:sortableColumn property="quantidade" title="${message(code: 'movimentacao.quantidade.label', default: 'Quantidade')}" />
					
						<g:sortableColumn property="dataMovimentacao" title="${message(code: 'movimentacao.dataMovimentacao.label', default: 'Data Movimentação')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${movimentacaoInstanceList}" status="i" var="movimentacaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${movimentacaoInstance.id}">${fieldValue(bean: movimentacaoInstance, field: "setorOrigem")}</g:link></td>
					
						<td>${fieldValue(bean: movimentacaoInstance, field: "setorDestino")}</td>
					
						<td>${fieldValue(bean: movimentacaoInstance, field: "nomeProduto")}</td>
					
						<td>${fieldValue(bean: movimentacaoInstance, field: "quantidade")}</td>
					
						<td><g:formatDate format="dd-MM-yyyy" date="${movimentacaoInstance.dataMovimentacao}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${movimentacaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
