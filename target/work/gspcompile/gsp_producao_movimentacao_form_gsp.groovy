import producao.Movimentacao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_movimentacao_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/movimentacao/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: movimentacaoInstance, field: 'setorOrigem', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("movimentacao.setorOrigem.label"),'default':("Setor Origem")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("setorOrigem"),'name':("setorOrigem.id"),'from':(producao.Setor.list()),'optionKey':("id"),'required':(""),'value':(movimentacaoInstance?.setorOrigem?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: movimentacaoInstance, field: 'setorDestino', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("movimentacao.setorDestino.label"),'default':("Setor Destino")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("setorDestino"),'name':("setorDestino.id"),'from':(producao.Setor.list()),'optionKey':("id"),'required':(""),'value':(movimentacaoInstance?.setorDestino?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: movimentacaoInstance, field: 'nomeProduto', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("movimentacao.nomeProduto.label"),'default':("Nome Produto")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("nomeProduto"),'name':("nomeProduto.id"),'from':(producao.Produto.list()),'optionKey':("id"),'required':(""),'value':(movimentacaoInstance?.nomeProduto?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: movimentacaoInstance, field: 'quantidade', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("movimentacao.quantidade.label"),'default':("Quantidade")],-1)
printHtmlPart(2)
invokeTag('field','g',37,['name':("quantidade"),'value':(fieldValue(bean: movimentacaoInstance, field: 'quantidade')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: movimentacaoInstance, field: 'dataMovimentacao', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("movimentacao.dataMovimentacao.label"),'default':("Data Movimentacao")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',46,['name':("dataMovimentacao"),'precision':("day"),'value':(movimentacaoInstance?.dataMovimentacao)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446784157405L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
