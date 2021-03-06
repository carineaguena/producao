package producao



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SetorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Setor.list(sort:"nome", order:"asc"), model:[setorInstanceCount: Setor.count()]
    }

    def show(Setor setorInstance) {
        respond setorInstance
    }

    def create() {
        respond new Setor(params)
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
    def save(Setor setorInstance) {
        if (setorInstance == null) {
            notFound()
            return
        }

        if (setorInstance.hasErrors()) {
            respond setorInstance.errors, view:'create'
            return
        }

        setorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'setor.label', default: 'Setor'), setorInstance.id])
                redirect setorInstance
            }
            '*' { respond setorInstance, [status: CREATED] }
        }
    }

    def edit(Setor setorInstance) {
        respond setorInstance
    }

    @Transactional
    def update(Setor setorInstance) {
        if (setorInstance == null) {
            notFound()
            return
        }

        if (setorInstance.hasErrors()) {
            respond setorInstance.errors, view:'edit'
            return
        }

        setorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Setor.label', default: 'Setor'), setorInstance.id])
                redirect setorInstance
            }
            '*'{ respond setorInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Setor setorInstance) {

        if (setorInstance == null) {
            notFound()
            return
        }

        setorInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Setor.label', default: 'Setor'), setorInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'setor.label', default: 'Setor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
