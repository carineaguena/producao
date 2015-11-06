
<%@ page import="producao.Produto" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'produto.label', default: 'Produto')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
                    <div class="nav" role="navigation">
                        
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"> <span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-produto" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-condensed">
			<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'produto.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="valor" title="${message(code: 'produto.valor.label', default: 'Valor')}" />
					
						<th><g:message code="produto.unidadeMedida.label" default="Unidade Medida" /></th>
					
						<th><g:message code="produto.setorProducao.label" default="Setor Produção" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${produtoInstanceList}" status="i" var="produtoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${produtoInstance.id}">${fieldValue(bean: produtoInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: produtoInstance, field: "valor")}</td>
					
						<td>${fieldValue(bean: produtoInstance, field: "unidadeMedida")}</td>
					
						<td>${fieldValue(bean: produtoInstance, field: "setorProducao")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${produtoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
