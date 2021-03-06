package producao


import producao.*
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CargoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cargo.list(sort:"nome", order:"asc"), model:[cargoInstanceCount: Cargo.count()]
    }

    def show(Cargo cargoInstance) {
        respond cargoInstance
    }

    def create() {
        respond new Cargo(params)
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
    def save(Cargo cargoInstance) {
        if (cargoInstance == null) {
            notFound()
            return
        }

        if (cargoInstance.hasErrors()) {
            respond cargoInstance.errors, view:'create'
            return
        }

        cargoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cargo.label', default: 'Cargo'), cargoInstance.id])
                redirect cargoInstance
            }
            '*' { respond cargoInstance, [status: CREATED] }
        }
    }

    def edit(Cargo cargoInstance) {
        respond cargoInstance
    }

    @Transactional
    def update(Cargo cargoInstance) {
        if (cargoInstance == null) {
            notFound()
            return
        }

        if (cargoInstance.hasErrors()) {
            respond cargoInstance.errors, view:'edit'
            return
        }

        cargoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Cargo.label', default: 'Cargo'), cargoInstance.id])
                redirect cargoInstance
            }
            '*'{ respond cargoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Cargo cargoInstance) {

        if (cargoInstance == null) {
            notFound()
            return
        }

        cargoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Cargo.label', default: 'Cargo'), cargoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cargo.label', default: 'Cargo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
