package producao



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ServidorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Servidor.list(sort:"nome", order:"asc"), model:[servidorInstanceCount: Servidor.count()]
    }

    def show(Servidor servidorInstance) {
        respond servidorInstance
    }

    def create() {
        respond new Servidor(params)
    }

     //controle de autenticacao (deve ser colocado em todos os controles que deseja proteger)
    def beforeInterceptor = [action:this.&auth]
        
    def auth() {
        if(!session.usuario) {
            redirect(controller:"autentica", action:"login")
            return false
        }
        //controle de permissao de usuarios
        else if(session.usuario.name!="Administrador")
            {
               flash.message = "Desculpe, você não tem permissão para acessar essa página"
                session.usuario = null
                redirect(controller:"autentica", action:"login")

             }
    }

    //copiar até aqui
    
    @Transactional
    def save(Servidor servidorInstance) {
        if (servidorInstance == null) {
            notFound()
            return
        }

        if (servidorInstance.hasErrors()) {
            respond servidorInstance.errors, view:'create'
            return
        }

        servidorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'servidor.label', default: 'Servidor'), servidorInstance.id])
                redirect servidorInstance
            }
            '*' { respond servidorInstance, [status: CREATED] }
        }
    }

    def edit(Servidor servidorInstance) {
        respond servidorInstance
    }

    @Transactional
    def update(Servidor servidorInstance) {
        if (servidorInstance == null) {
            notFound()
            return
        }

        if (servidorInstance.hasErrors()) {
            respond servidorInstance.errors, view:'edit'
            return
        }

        servidorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Servidor.label', default: 'Servidor'), servidorInstance.id])
                redirect servidorInstance
            }
            '*'{ respond servidorInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Servidor servidorInstance) {

        if (servidorInstance == null) {
            notFound()
            return
        }

        servidorInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Servidor.label', default: 'Servidor'), servidorInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'servidor.label', default: 'Servidor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
