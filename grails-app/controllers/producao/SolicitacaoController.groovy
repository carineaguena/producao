package producao



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SolicitacaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Solicitacao.list(params), model:[solicitacaoInstanceCount: Solicitacao.count()]
    }

    def show(Solicitacao solicitacaoInstance) {
        respond solicitacaoInstance
    }

    def create() {
        respond new Solicitacao(params)
    }

    //controle de autenticacao (deve ser colocado em todos os controles que deseja proteger)
    def beforeInterceptor = [action:this.&auth]
        
    def auth() {
        if(!session.usuario) {
            redirect(controller:"usuario", action:"login")
            return false
        }
    }

    def enviarMensagem(Solicitacao envio) {
        envio.validate()
        if (envio.hasErrors()) {
            // Erro encontrado
            flash.message = "Erro de validação"
            render(view:"comunicacao",
            model:[mensagem:envio,
            fornecedores:Fornecedor.list()])
        } else {
            // Mensagem enviada (código omitido)
            flash.message = "Mensagem enviada com sucesso"
            render(view:'comunicacao')
        }
    }

    //copiar até aqui
    
    @Transactional
    def save(Solicitacao solicitacaoInstance) {
        if (solicitacaoInstance == null) {
            notFound()
            return
        }

        if (solicitacaoInstance.hasErrors()) {
            respond solicitacaoInstance.errors, view:'create'
            return
        }

        solicitacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'solicitacao.label', default: 'Solicitacao'), solicitacaoInstance.id])
                redirect solicitacaoInstance
            }
            '*' { respond solicitacaoInstance, [status: CREATED] }
        }
    }

    def edit(Solicitacao solicitacaoInstance) {
        respond solicitacaoInstance
    }

    @Transactional
    def update(Solicitacao solicitacaoInstance) {
        if (solicitacaoInstance == null) {
            notFound()
            return
        }

        if (solicitacaoInstance.hasErrors()) {
            respond solicitacaoInstance.errors, view:'edit'
            return
        }

        solicitacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Solicitacao.label', default: 'Solicitacao'), solicitacaoInstance.id])
                redirect solicitacaoInstance
            }
            '*'{ respond solicitacaoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Solicitacao solicitacaoInstance) {

        if (solicitacaoInstance == null) {
            notFound()
            return
        }

        solicitacaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Solicitacao.label', default: 'Solicitacao'), solicitacaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'solicitacao.label', default: 'Solicitacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
