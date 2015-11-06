import producao.Solicitacao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_solicitacaoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solicitacao/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'solicitacao.label', default: 'Solicitacao'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',16,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',17,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("create"),'action':("create")],2)
printHtmlPart(10)
invokeTag('message','g',21,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (solicitacaoInstance?.nomeProduto)) {
printHtmlPart(15)
invokeTag('message','g',29,['code':("solicitacao.nomeProduto.label"),'default':("Nome Produto")],-1)
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(solicitacaoInstance?.nomeProduto?.encodeAsHTML())
})
invokeTag('link','g',31,['controller':("produto"),'action':("show"),'id':(solicitacaoInstance?.nomeProduto?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (solicitacaoInstance?.unidadeMedida)) {
printHtmlPart(19)
invokeTag('message','g',38,['code':("solicitacao.unidadeMedida.label"),'default':("Unidade Medida")],-1)
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(solicitacaoInstance?.unidadeMedida?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("medida"),'action':("show"),'id':(solicitacaoInstance?.unidadeMedida?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (solicitacaoInstance?.quantidade)) {
printHtmlPart(21)
invokeTag('message','g',47,['code':("solicitacao.quantidade.label"),'default':("Quantidade")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',49,['bean':(solicitacaoInstance),'field':("quantidade")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (solicitacaoInstance?.setorSolicitante)) {
printHtmlPart(23)
invokeTag('message','g',56,['code':("solicitacao.setorSolicitante.label"),'default':("Setor Solicitante")],-1)
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(solicitacaoInstance?.setorSolicitante?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("setor"),'action':("show"),'id':(solicitacaoInstance?.setorSolicitante?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (solicitacaoInstance?.setorSolicitado)) {
printHtmlPart(25)
invokeTag('message','g',65,['code':("solicitacao.setorSolicitado.label"),'default':("Setor Solicitado")],-1)
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(solicitacaoInstance?.setorSolicitado?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("setor"),'action':("show"),'id':(solicitacaoInstance?.setorSolicitado?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (solicitacaoInstance?.dataSolicitacao)) {
printHtmlPart(27)
invokeTag('message','g',74,['code':("solicitacao.dataSolicitacao.label"),'default':("Data Solicitação")],-1)
printHtmlPart(28)
invokeTag('formatDate','g',76,['date':(solicitacaoInstance?.dataSolicitacao)],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (solicitacaoInstance?.email)) {
printHtmlPart(29)
invokeTag('message','g',83,['code':("solicitacao.email.label"),'default':("Email")],-1)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(solicitacaoInstance?.email?.encodeAsHTML())
})
invokeTag('link','g',85,['controller':("servidor"),'action':("show"),'id':(solicitacaoInstance?.email?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (solicitacaoInstance?.status)) {
printHtmlPart(31)
invokeTag('message','g',92,['code':("solicitacao.status.label"),'default':("Status")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',94,['bean':(solicitacaoInstance),'field':("status")],-1)
printHtmlPart(17)
}
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createTagBody(3, {->
invokeTag('message','g',102,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',102,['class':("edit "),'action':("edit"),'resource':(solicitacaoInstance)],3)
printHtmlPart(35)
invokeTag('actionSubmit','g',103,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(36)
})
invokeTag('form','g',105,['url':([resource:solicitacaoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',107,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446753864309L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
