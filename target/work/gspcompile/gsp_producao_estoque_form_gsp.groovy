import producao.Estoque
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_estoque_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/estoque/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: estoqueInstance, field: 'quantidade', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("estoque.quantidade.label"),'default':("Quantidade")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("quantidade"),'value':(fieldValue(bean: estoqueInstance, field: 'quantidade')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: estoqueInstance, field: 'unidadeMedida', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("estoque.unidadeMedida.label"),'default':("Unidade Medida")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("unidadeMedida"),'name':("unidadeMedida.id"),'from':(producao.Medida.list()),'optionKey':("id"),'required':(""),'value':(estoqueInstance?.unidadeMedida?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: estoqueInstance, field: 'nomeProduto', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("estoque.nomeProduto.label"),'default':("Nome Produto")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("nomeProduto"),'name':("nomeProduto.id"),'from':(producao.Produto.list()),'optionKey':("id"),'required':(""),'value':(estoqueInstance?.nomeProduto?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: estoqueInstance, field: 'setorDeOrigemDoProduto', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("estoque.setorDeOrigemDoProduto.label"),'default':("Setor")],-1)
printHtmlPart(2)
invokeTag('select','g',37,['id':("setorDeOrigemDoProduto"),'name':("setorDeOrigemDoProduto.id"),'from':(producao.Setor.list()),'optionKey':("id"),'required':(""),'value':(estoqueInstance?.setorDeOrigemDoProduto?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: estoqueInstance, field: 'dataDaMovimentacao', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("estoque.dataDaMovimentação.label"),'default':("Data Da Movimentacao")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',46,['name':("dataDaMovimentacao"),'precision':("day"),'value':(estoqueInstance?.dataDaMovimentacao)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446771357772L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
