package producao



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MovimentacaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Movimentacao.list(params), model:[movimentacaoInstanceCount: Movimentacao.count()]
    }

    def show(Movimentacao movimentacaoInstance) {
        respond movimentacaoInstance
    }

    def create() {
        respond new Movimentacao(params)
    }

    //controle de autenticacao (deve ser colocado em todos os controles que deseja proteger)
    def beforeInterceptor = [action:this.&auth]
        
    def auth() {
        if(!session.usuario) {
            redirect(controller:"autentica", action:"login")
            return false
        }
    }

    //copiar até aqui

    @Transactional
    def save(Movimentacao movimentacaoInstance) {
        if (movimentacaoInstance == null) {
            notFound()
            return
        }

        if (movimentacaoInstance.hasErrors()) {
            respond movimentacaoInstance.errors, view:'create'
            return
        }

        movimentacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'movimentacao.label', default: 'Movimentacao'), movimentacaoInstance.id])
                redirect movimentacaoInstance
            }
            '*' { respond movimentacaoInstance, [status: CREATED] }
        }
    }

    def edit(Movimentacao movimentacaoInstance) {
        respond movimentacaoInstance
    }

    @Transactional
    def update(Movimentacao movimentacaoInstance) {
        if (movimentacaoInstance == null) {
            notFound()
            return
        }

        if (movimentacaoInstance.hasErrors()) {
            respond movimentacaoInstance.errors, view:'edit'
            return
        }

        movimentacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Movimentacao.label', default: 'Movimentacao'), movimentacaoInstance.id])
                redirect movimentacaoInstance
            }
            '*'{ respond movimentacaoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Movimentacao movimentacaoInstance) {

        if (movimentacaoInstance == null) {
            notFound()
            return
        }

        movimentacaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Movimentacao.label', default: 'Movimentacao'), movimentacaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'movimentacao.label', default: 'Movimentacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
