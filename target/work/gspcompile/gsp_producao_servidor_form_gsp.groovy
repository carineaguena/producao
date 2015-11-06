import producao.Servidor
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_servidor_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/servidor/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: servidorInstance, field: 'siape', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("servidor.siape.label"),'default':("Siape")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("siape"),'type':("number"),'value':(servidorInstance.siape),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: servidorInstance, field: 'nome', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("servidor.nome.label"),'default':("Nome")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("nome"),'maxlength':("50"),'required':(""),'value':(servidorInstance?.nome)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: servidorInstance, field: 'email', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("servidor.email.label"),'default':("Email")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("email"),'maxlength':("50"),'required':(""),'value':(servidorInstance?.email)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: servidorInstance, field: 'ramal', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("servidor.ramal.label"),'default':("Ramal")],-1)
printHtmlPart(2)
invokeTag('field','g',37,['name':("ramal"),'type':("number"),'value':(servidorInstance.ramal),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: servidorInstance, field: 'cargo', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("servidor.cargo.label"),'default':("Cargo")],-1)
printHtmlPart(2)
invokeTag('select','g',46,['id':("cargo"),'name':("cargo.id"),'from':(producao.Cargo.list()),'optionKey':("id"),'required':(""),'value':(servidorInstance?.cargo?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: servidorInstance, field: 'setor', 'error'))
printHtmlPart(8)
invokeTag('message','g',52,['code':("servidor.setor.label"),'default':("Setor")],-1)
printHtmlPart(2)
invokeTag('select','g',55,['id':("setor"),'name':("setor.id"),'from':(producao.Setor.list()),'optionKey':("id"),'required':(""),'value':(servidorInstance?.setor?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446229473169L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
