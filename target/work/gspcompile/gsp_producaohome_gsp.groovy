import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_producaohome_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/home.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
for( c in (grailsApplication.controllerClasses.sort { it.name }) ) {
printHtmlPart(6)
createTagBody(3, {->
expressionOut.print(c.name)
})
invokeTag('link','g',18,['controller':(c.logicalPropertyName)],3)
printHtmlPart(7)
}
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',22,['controller':("home")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',23,['controller':("produto")],2)
printHtmlPart(10)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',24,['controller':("medida")],2)
printHtmlPart(10)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',25,['controller':("setor")],2)
printHtmlPart(10)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',26,['controller':("cargo")],2)
printHtmlPart(10)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',27,['controller':("servidor")],2)
printHtmlPart(10)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',28,['controller':("estoque")],2)
printHtmlPart(10)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',29,['controller':("solicitacao")],2)
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('link','g',30,['controller':("movimentacao")],2)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',1,[:],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446663430983L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
