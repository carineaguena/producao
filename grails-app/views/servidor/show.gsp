
<%@ page import="producao.Servidor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'servidor.label', default: 'Servidor')}" />
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
		<div id="show-servidor" class="content scaffold-show" role="main">
			<h3><g:message code="default.show.label" args="[entityName]" /></h3>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list servidor">
			
				<g:if test="${servidorInstance?.siape}">
				<li class="fieldcontain">
					<span id="siape-label" class="property-label"><g:message code="servidor.siape.label" default="Siape" /></span>
					
						<span class="property-value" aria-labelledby="siape-label"><g:fieldValue bean="${servidorInstance}" field="siape"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${servidorInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="servidor.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${servidorInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${servidorInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="servidor.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${servidorInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${servidorInstance?.ramal}">
				<li class="fieldcontain">
					<span id="ramal-label" class="property-label"><g:message code="servidor.ramal.label" default="Ramal" /></span>
					
						<span class="property-value" aria-labelledby="ramal-label"><g:fieldValue bean="${servidorInstance}" field="ramal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${servidorInstance?.cargo}">
				<li class="fieldcontain">
					<span id="cargo-label" class="property-label"><g:message code="servidor.cargo.label" default="Cargo" /></span>
					
						<span class="property-value" aria-labelledby="cargo-label"><g:link controller="cargo" action="show" id="${servidorInstance?.cargo?.id}">${servidorInstance?.cargo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${servidorInstance?.setor}">
				<li class="fieldcontain">
					<span id="setor-label" class="property-label"><g:message code="servidor.setor.label" default="Setor" /></span>
					
						<span class="property-value" aria-labelledby="setor-label"><g:link controller="setor" action="show" id="${servidorInstance?.setor?.id}">${servidorInstance?.setor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			
			</ol>
			<g:form url="[resource:servidorInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit " action="edit" resource="${servidorInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
