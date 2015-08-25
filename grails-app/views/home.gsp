<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Sistema de Produção</title>

		
	</head>
	<body>
		
                        
            <div class="nav" role="navigation">

				<ul class="nav nav-tabs nav-justified">
                                   
					<!--<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.name } }">
						<li><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
					</g:each>-->

										<!-- Para adicionar os controles na tela de navegação -->
                                        <li role="presentation" class="active"> <g:link controller="home"><span class="icon icon-home" aria-hidden="true"></span> Home</g:link></li>
                                        <li><g:link controller="produto"><span class="icon icon-asterisk" aria-hidden="true"></span> Produto</g:link></li>
                                        <li><g:link controller="medida"><span class="icon icon-leaf" aria-hidden="true"></span> Medida</g:link></li>
                                        <li><g:link controller="setor"><span class="icon icon-wrench" aria-hidden="true"></span> Setor</g:link></li>
                                        <li><g:link controller="cargo"><span class="icon icon-briefcase" aria-hidden="true"></span> Cargo</g:link></li>
                                        <li><g:link controller="solicitacao"><span class="icon icon-plus-sign" aria-hidden="true"></span> Solicitação</g:link></li>
				</ul>
				<div class="jumbotron">
      				<div class="container">
        				<h1>Bem-Vindo!</h1>
        				<p>Este é o sistema para controle de produção agropecuária do Instituto Federal Catarinense Campus Camboriú.</p>
        				
      				</div>
    			</div>
			</div>
		
	</body>