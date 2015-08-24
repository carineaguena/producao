
<%@ page import="producao.Servidor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'servidor.label', default: 'Servidor')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
                    <div class="nav" role="navigation">
                        
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"> <span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-servidor" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-condensed">
			<thead>
					<tr>
					
						<g:sortableColumn property="siape" title="${message(code: 'servidor.siape.label', default: 'Siape')}" />
					
						<g:sortableColumn property="nome" title="${message(code: 'servidor.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'servidor.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="ramal" title="${message(code: 'servidor.ramal.label', default: 'Ramal')}" />
					
						<th><g:message code="servidor.cargo.label" default="Cargo" /></th>
					
						<th><g:message code="servidor.setor.label" default="Setor" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${servidorInstanceList}" status="i" var="servidorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${servidorInstance.id}">${fieldValue(bean: servidorInstance, field: "siape")}</g:link></td>
					
						<td>${fieldValue(bean: servidorInstance, field: "nome")}</td>
					
						<td>${fieldValue(bean: servidorInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: servidorInstance, field: "ramal")}</td>
					
						<td>${fieldValue(bean: servidorInstance, field: "cargo")}</td>
					
						<td>${fieldValue(bean: servidorInstance, field: "setor")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${servidorInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
