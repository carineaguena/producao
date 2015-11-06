import producao.Solicitacao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_solicitacao_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solicitacao/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: solicitacaoInstance, field: 'nomeProduto', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("solicitacao.nomeProduto.label"),'default':("Nome Produto")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("nomeProduto"),'name':("nomeProduto.id"),'from':(producao.Produto.list()),'optionKey':("id"),'required':(""),'value':(solicitacaoInstance?.nomeProduto?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: solicitacaoInstance, field: 'unidadeMedida', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("solicitacao.unidadeMedida.label"),'default':("Unidade Medida")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("unidadeMedida"),'name':("unidadeMedida.id"),'from':(producao.Medida.list()),'optionKey':("id"),'required':(""),'value':(solicitacaoInstance?.unidadeMedida?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: solicitacaoInstance, field: 'quantidade', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("solicitacao.quantidade.label"),'default':("Quantidade")],-1)
printHtmlPart(2)
invokeTag('field','g',28,['name':("quantidade"),'value':(fieldValue(bean: solicitacaoInstance, field: 'quantidade')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: solicitacaoInstance, field: 'setorSolicitante', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("solicitacao.setorSolicitante.label"),'default':("Setor Solicitante")],-1)
printHtmlPart(2)
invokeTag('select','g',37,['id':("setorSolicitante"),'name':("setorSolicitante.id"),'from':(producao.Setor.list()),'optionKey':("id"),'required':(""),'value':(solicitacaoInstance?.setorSolicitante?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: solicitacaoInstance, field: 'setorSolicitado', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("solicitacao.setorSolicitado.label"),'default':("Setor Solicitado")],-1)
printHtmlPart(2)
invokeTag('select','g',46,['id':("setorSolicitado"),'name':("setorSolicitado.id"),'from':(producao.Setor.list()),'optionKey':("id"),'required':(""),'value':(solicitacaoInstance?.setorSolicitado?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: solicitacaoInstance, field: 'dataSolicitacao', 'error'))
printHtmlPart(8)
invokeTag('message','g',52,['code':("solicitacao.dataSolicitacao.label"),'default':("Data Solicitacao")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',55,['name':("dataSolicitacao"),'precision':("day"),'value':(solicitacaoInstance?.dataSolicitacao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: solicitacaoInstance, field: 'email', 'error'))
printHtmlPart(9)
invokeTag('message','g',61,['code':("solicitacao.email.label"),'default':("Email")],-1)
printHtmlPart(2)
invokeTag('select','g',64,['id':("email"),'name':("email.id"),'from':(producao.Servidor.list()),'optionKey':("id"),'required':(""),'value':(solicitacaoInstance?.email?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: solicitacaoInstance, field: 'status', 'error'))
printHtmlPart(10)
invokeTag('message','g',70,['code':("solicitacao.status.label"),'default':("Status")],-1)
printHtmlPart(2)
invokeTag('select','g',73,['name':("status"),'from':(['Solicitado', 'Atendido', 'Recusado']),'required':(""),'value':(solicitacaoInstance?.status)],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446249232153L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
