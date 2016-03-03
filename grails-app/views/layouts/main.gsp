<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
  		<!--<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>-->
                <asset:stylesheet src="bootstrap.css"/>
                <asset:stylesheet src="bootstrap.min.css"/>
                <asset:stylesheet src="bootstrap-responsive.css"/>
                <asset:stylesheet src="bootstrap-responsive.min.css"/>
		            <asset:javascript src="bootstrap.js"/>
                <asset:javascript src="bootstrap.min.js"/>

		<g:layoutHead/>
             
            
	</head>
	<body>
            
          <div class="cabecalho">
            
          
            
            <div class="page-header" style="margin-top: 0px;">

              <a href="${createLink(uri: '/')}"><asset:image src="grails_logo.png" alt="Grails"/></a>
              
              <br><br><br>

            </div>
            <div class="login-header"> <span class="icon icon-user" aria-hidden="true"></span> <g:loginControl /> </div>
          </div>
           
             
		<g:layoutBody/>
                
        
                      
                     
                        <div class="footer">
                               <a href="${createLink(uri: '/')}" style="float: left"><asset:image src="etiqueta_rodape2.png" alt="Ifc"/></a>
                               <a href="${createLink(uri: '/')}" style="float: right; padding-top: 30px; padding-left: 30px"><asset:image src="BrancoH_80px.jpg" alt="105"/></a>
                        
                            <h4>Endereço</h4>			
                            
                            <p>INSTITUTO FEDERAL DE EDUCAÇÃO, CIÊNCIA E TECNOLOGIA CATARINENSE - CÂMPUS CAMBORIÚ</p>
                            <p>RUA JOAQUIM GARCIA S/N - CAIXA POSTAL Nº 2016 - CEP 88340-055 - CAMBORIÚ - SC<p/>
                            <p>TELEFAX: (47) 2104-0800 - E-mail: ifc@ifc-camboriu.edu.br</p>
                          
                      </div>
                                           
                  
                    
            


	
	<script type='text/javascript' src='http://www.camboriu.ifc.edu.br/wp-content/themes/ifc/assets/js/bootstrap.min.js?ver=1.0'></script>
        <script type='text/javascript' src='http://www.camboriu.ifc.edu.br/wp-content/themes/ifc/assets/js/bootstrapwp.demo.js?ver=1.0'></script>

        </footer>

	</body>
</html>