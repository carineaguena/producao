
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
                        
			<ul class="nav nav-tabs nav-justified" style="padding-left:15px">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"> <span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="edit" action="edit" resource="${usuarioInstance}" id="${session.usuario.id}"><span class="icon icon-pencil" aria-hidden="true"></span> <g:message code="Alterar Senha"/></g:link></li>	
				<g:if test="${session.usuario.name == 'Administrador'}">
					<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
				</g:if>
			</ul>
		</div>

		<g:if test="${session.usuario.name == 'Administrador'}">
		<div id="list-usuario" class="content scaffold-list" role="main" style="padding-left:15px">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-condensed">
			<thead>
					<tr>
					
						<g:sortableColumn property="login" title="${message(code: 'usuario.login.label', default: 'Login')}" />
					
					
						<g:sortableColumn property="name" title="${message(code: 'usuario.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${usuarioInstanceList}" status="i" var="usuarioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usuarioInstance.id}">${fieldValue(bean: usuarioInstance, field: "login")}</g:link></td>
					
					
						<td>${fieldValue(bean: usuarioInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usuarioInstanceCount ?: 0}" />
			</div>
		</div>
		</g:if>


		<g:else>
		 	<div id="show-usuario" class="content scaffold-show" role="main" style="padding-left:15px">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuario">
			
				<g:if test="${session.usuario.login}">
				<li class="fieldcontain">
					<span id="login-label" class="property-label"><g:message code="usuario.login.label" default="Login:" /></span>
					
						<span class="property-value" aria-labelledby="login-label"><g:fieldValue bean="${session.usuario}" field="login"/></span>
					
				</li>
				</g:if>
		
			
				<g:if test="${session.usuario.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="usuario.name.label" default="Name:" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${session.usuario}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
	
		</div>

		 </g:else>
    			
	</body>
</html>
