import producao.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producao_usuarioshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'usuario.label', default: 'Usuario'))],-1)
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
if(true && (usuarioInstance?.login)) {
printHtmlPart(15)
invokeTag('message','g',29,['code':("usuario.login.label"),'default':("Login")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',31,['bean':(usuarioInstance),'field':("login")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (usuarioInstance?.password)) {
printHtmlPart(19)
invokeTag('message','g',38,['code':("usuario.password.label"),'default':("Password")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',40,['bean':(usuarioInstance),'field':("password")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (usuarioInstance?.name)) {
printHtmlPart(21)
invokeTag('message','g',47,['code':("usuario.name.label"),'default':("Name")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',49,['bean':(usuarioInstance),'field':("name")],-1)
printHtmlPart(17)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',57,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',57,['class':("edit "),'action':("edit"),'resource':(usuarioInstance)],3)
printHtmlPart(25)
invokeTag('actionSubmit','g',58,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(26)
})
invokeTag('form','g',60,['url':([resource:usuarioInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',62,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446127493699L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
