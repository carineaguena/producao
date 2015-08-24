
<%@ page import="producao.Estoque" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'estoque.label', default: 'Estoque')}" />
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
		<div id="show-estoque" class="content scaffold-show" role="main">
			<h3><g:message code="default.show.label" args="[entityName]" /></h3>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list estoque">
			
				<g:if test="${estoqueInstance?.quantidade}">
				<li class="fieldcontain">
					<span id="quantidade-label" class="property-label"><g:message code="estoque.quantidade.label" default="Quantidade" /></span>
					
						<span class="property-value" aria-labelledby="quantidade-label"><g:fieldValue bean="${estoqueInstance}" field="quantidade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${estoqueInstance?.unidadeMedida}">
				<li class="fieldcontain">
					<span id="unidadeMedida-label" class="property-label"><g:message code="estoque.unidadeMedida.label" default="Unidade Medida" /></span>
					
						<span class="property-value" aria-labelledby="unidadeMedida-label"><g:link controller="medida" action="show" id="${estoqueInstance?.unidadeMedida?.id}">${estoqueInstance?.unidadeMedida?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${estoqueInstance?.nomeProduto}">
				<li class="fieldcontain">
					<span id="nomeProduto-label" class="property-label"><g:message code="estoque.nomeProduto.label" default="Nome Produto" /></span>
					
						<span class="property-value" aria-labelledby="nomeProduto-label"><g:link controller="produto" action="show" id="${estoqueInstance?.nomeProduto?.id}">${estoqueInstance?.nomeProduto?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${estoqueInstance?.setorProducao}">
				<li class="fieldcontain">
					<span id="setorProducao-label" class="property-label"><g:message code="estoque.setorProducao.label" default="Setor Producao" /></span>
					
						<span class="property-value" aria-labelledby="setorProducao-label"><g:link controller="setor" action="show" id="${estoqueInstance?.setorProducao?.id}">${estoqueInstance?.setorProducao?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:estoqueInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit " action="edit" resource="${estoqueInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
