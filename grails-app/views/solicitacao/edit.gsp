<%@ page import="producao.Solicitacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'solicitacao.label', default: 'Solicitacao')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
            
		<div class="nav" role="navigation">
			<ul class="nav nav-tabs nav-justified" style="padding-left:15px">
				<li role="presentation" class="active"><a class="home" href="${createLink(uri: '/')}"><span class="icon icon-home" aria-hidden="true"></span> <g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><span class="icon icon-list" aria-hidden="true"></span> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><span class="icon icon-plus" aria-hidden="true"></span><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-solicitacao" class="content scaffold-edit" role="main" style="padding-left:15px">
			<h3><g:message code="default.edit.label" args="[entityName]" /></h3>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${solicitacaoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${solicitacaoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:solicitacaoInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${solicitacaoInstance?.version}" />
				<fieldset class="form">
				

					<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'nomeProduto', 'error')} required" style="padding-left:15px">
						<label for="nomeProduto">
							<g:message code="solicitacao.nomeProduto.label" default="Nome Produto" />
							<span class="required-indicator">*</span>
						</label>
						<g:select id="nomeProduto" name="nomeProduto.id" from="${producao.Produto.list()}" optionKey="id" required="" value="${solicitacaoInstance?.nomeProduto?.id}" class="many-to-one" disabled="disabled"/>
					</div>

					<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'unidadeMedida', 'error')} required" style="padding-left:15px">
						<label for="unidadeMedida">
							<g:message code="solicitacao.unidadeMedida.label" default="Unidade Medida" />
							<span class="required-indicator">*</span>
						</label>
						<g:select id="unidadeMedida" name="unidadeMedida.id" from="${producao.Medida.list()}" optionKey="id" required="" value="${solicitacaoInstance?.unidadeMedida?.id}" class="many-to-one" disabled="disabled"/>

					</div>

					<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'quantidade', 'error')} required" style="padding-left:15px">
						<label for="quantidade">
							<g:message code="solicitacao.quantidade.label" default="Quantidade" />
							<span class="required-indicator">*</span>
						</label>
						<g:field name="quantidade" value="${fieldValue(bean: solicitacaoInstance, field: 'quantidade')}" required="" disabled="disabled"/>
					</div>

					<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'setorSolicitante', 'error')} required" style="padding-left:15px">
						<label for="setorSolicitante">
							<g:message code="solicitacao.setorSolicitante.label" default="Setor Solicitante" />
							<span class="required-indicator">*</span>
						</label>
						<g:select id="setorSolicitante" name="setorSolicitante.id" from="${producao.Setor.list()}" optionKey="id" required="" value="${solicitacaoInstance?.setorSolicitante?.id}" class="many-to-one" disabled="disabled"/>

					</div>

					<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'setorSolicitado', 'error')} required" style="padding-left:15px">
						<label for="setorSolicitado">
							<g:message code="solicitacao.setorSolicitado.label" default="Setor Solicitado" />
							<span class="required-indicator">*</span>
						</label>
						<g:select id="setorSolicitado" name="setorSolicitado.id" from="${producao.Setor.list()}" optionKey="id" required="" value="${solicitacaoInstance?.setorSolicitado?.id}" class="many-to-one" disabled="disabled"/>

					</div>

					<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'dataSolicitacao', 'error')} required" style="padding-left:15px">
						<label for="dataSolicitacao">
							<g:message code="solicitacao.dataSolicitacao.label" default="Data Solicitacao" />
							<span class="required-indicator">*</span>
						</label>
						<g:datePicker name="dataSolicitacao" precision="day"  value="${solicitacaoInstance?.dataSolicitacao}" />

					</div>

					<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'email', 'error')} required" style="padding-left:15px">
						<label for="email">
							<g:message code="solicitacao.email.label" default="Email" />
							<span class="required-indicator">*</span>
						</label>
						<g:select id="email" name="email.id" from="${producao.Servidor.list()}" optionKey="id" required="" value="${solicitacaoInstance?.email?.id}" class="many-to-one" disabled="disabled"/>

					</div>




					<div class="fieldcontain ${hasErrors(bean: solicitacaoInstance, field: 'status', 'error')} required" style="padding-left:15px">
						<label for="status">
						<g:message code="solicitacao.status.label" default="Status" />
						<span class="required-indicator">*</span>
						</label>
	
						<g:select name="status" from="${['Solicitado', 'Atendido', 'Recusado']}" required="" value="${solicitacaoInstance?.status}"/>
					</div>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
