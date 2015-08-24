
<%@ page import="producao.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
                    <div class="nav" role="navigation">
                        
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"> <span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-usuario" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-condensed">
			<thead>
					<tr>
					
						<g:sortableColumn property="login" title="${message(code: 'usuario.login.label', default: 'Login')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'usuario.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'usuario.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${usuarioInstanceList}" status="i" var="usuarioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usuarioInstance.id}">${fieldValue(bean: usuarioInstance, field: "login")}</g:link></td>
					
						<td>${fieldValue(bean: usuarioInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: usuarioInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usuarioInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
