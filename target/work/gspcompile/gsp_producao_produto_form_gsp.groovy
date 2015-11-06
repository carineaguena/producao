import producao.Produto
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_produto_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/produto/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: produtoInstance, field: 'nome', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("produto.nome.label"),'default':("Nome")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("nome"),'maxlength':("50"),'required':(""),'value':(produtoInstance?.nome)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: produtoInstance, field: 'valor', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("produto.valor.label"),'default':("Valor")],-1)
printHtmlPart(5)
invokeTag('field','g',19,['name':("valor"),'value':(fieldValue(bean: produtoInstance, field: 'valor'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: produtoInstance, field: 'unidadeMedida', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("produto.unidadeMedida.label"),'default':("Unidade Medida")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("unidadeMedida"),'name':("unidadeMedida.id"),'from':(producao.Medida.list()),'optionKey':("id"),'required':(""),'value':(produtoInstance?.unidadeMedida?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: produtoInstance, field: 'setorProducao', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("produto.setorProducao.label"),'default':("Setor Produção")],-1)
printHtmlPart(2)
invokeTag('select','g',37,['id':("setorProducao"),'name':("setorProducao.id"),'from':(producao.Setor.list()),'optionKey':("id"),'required':(""),'value':(produtoInstance?.setorProducao?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446576503736L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
