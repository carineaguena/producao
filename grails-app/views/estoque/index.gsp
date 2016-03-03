
<%@ page import="producao.Estoque" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'estoque.label', default: 'Estoque')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
                    <div class="nav" role="navigation">
                        
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"> <span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-estoque" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-condensed">
			<thead>
					<tr>
					
						<g:sortableColumn property="quantidade" title="${message(code: 'estoque.quantidade.label', default: 'Quantidade')}" />
					
						<th><g:message code="estoque.unidadeMedida.label" default="Unidade Medida" /></th>
					
						<th><g:message code="estoque.nomeProduto.label" default="Nome Produto" /></th>
					
						<th><g:message code="estoque.setorDeOrigemDoProduto.label" default="Setor" /></th>
					
						<g:sortableColumn property="dataDaMovimentacao" title="${message(code: 'estoque.dataDaMovimentacao.label', default: 'Data Da Movimentação')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${estoqueInstanceList}" status="i" var="estoqueInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${estoqueInstance.id}">${fieldValue(bean: estoqueInstance, field: "quantidade")}</g:link></td>
					
						<td>${fieldValue(bean: estoqueInstance, field: "unidadeMedida")}</td>
					
						<td>${fieldValue(bean: estoqueInstance, field: "nomeProduto")}</td>
					
						<td>${fieldValue(bean: estoqueInstance, field: "setorDeOrigemDoProduto")}</td>
					
						<td><g:formatDate format="dd-MM-yyyy" date="${estoqueInstance.dataDaMovimentacao}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${estoqueInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
