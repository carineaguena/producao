import producao.Solicitacao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_solicitacaoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solicitacao/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'solicitacao.label', default: 'Solicitação'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',27,['code':("solicitacao.nomeProduto.label"),'default':("Nome Produto")],-1)
printHtmlPart(13)
invokeTag('message','g',29,['code':("solicitacao.unidadeMedida.label"),'default':("Unidade Medida")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("quantidade"),'title':(message(code: 'solicitacao.quantidade.label', default: 'Quantidade'))],-1)
printHtmlPart(15)
invokeTag('message','g',33,['code':("solicitacao.setorSolicitante.label"),'default':("Setor Solicitante")],-1)
printHtmlPart(13)
invokeTag('message','g',35,['code':("solicitacao.setorSolicitado.label"),'default':("Setor Solicitado")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',37,['property':("dataSolicitacao"),'title':(message(code: 'solicitacao.dataSolicitacao.label', default: 'Data Solicitação'))],-1)
printHtmlPart(16)
invokeTag('message','g',39,['code':("solicitacao.email.label"),'default':("Email")],-1)
printHtmlPart(17)
invokeTag('message','g',41,['code':("solicitacao.status.label"),'default':("Status")],-1)
printHtmlPart(18)
loop:{
int i = 0
for( solicitacaoInstance in (solicitacaoInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: solicitacaoInstance, field: "nomeProduto"))
})
invokeTag('link','g',49,['action':("show"),'id':(solicitacaoInstance.id)],3)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: solicitacaoInstance, field: "unidadeMedida"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: solicitacaoInstance, field: "quantidade"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: solicitacaoInstance, field: "setorSolicitante"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: solicitacaoInstance, field: "setorSolicitado"))
printHtmlPart(21)
invokeTag('formatDate','g',59,['date':(solicitacaoInstance.dataSolicitacao)],-1)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: solicitacaoInstance, field: "email"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: solicitacaoInstance, field: "status"))
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',70,['total':(solicitacaoInstanceCount ?: 0)],-1)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446753601375L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
