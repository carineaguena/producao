import producao.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_usuario_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'login', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("usuario.login.label"),'default':("Login")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("login"),'required':(""),'value':(usuarioInstance?.login)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'password', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("usuario.password.label"),'default':("Password")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['type':("password"),'name':("password"),'required':(""),'value':(usuarioInstance?.password)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'name', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("usuario.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("name"),'required':(""),'value':(usuarioInstance?.name)],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446127493696L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
