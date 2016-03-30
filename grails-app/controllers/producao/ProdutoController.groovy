package producao



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProdutoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Produto.list(sort:"nome", order:"asc"), model:[produtoInstanceCount: Produto.count()]

    }

    def show(Produto produtoInstance) {

        respond produtoInstance
    }

    def create() {
        respond new Produto(params)
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
    def save(Produto produtoInstance) {
        if (produtoInstance == null) {
            notFound()
            return
        }

        if (produtoInstance.hasErrors()) {
            respond produtoInstance.errors, view:'create'
            return
        }

        /*def produto = Produto.executeQuery("select pro from Produto pro where upper(pro.nome) like upper(:nomeProduto) AND " + 
            " pro.setorProducao = :setor", 
            [nomeProduto:produtoInstance.nome, setor:produtoInstance.setorProducao])

        if(produto){
            //erro duplicidade de nome

            produtoInstance.save flush:false
        }else{
            //produtoInstance.save flush:true
        }*/
        produtoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'produto.label', default: 'Produto'), produtoInstance.id])
                redirect produtoInstance
            }
            '*' { respond produtoInstance, [status: CREATED] }
        }   
    }

    def edit(Produto produtoInstance) {
        respond produtoInstance
    }

    @Transactional
    def update(Produto produtoInstance) {
        if (produtoInstance == null) {
            notFound()
            return
        }

        if (produtoInstance.hasErrors()) {
            respond produtoInstance.errors, view:'edit'
            return
        }

        produtoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Produto.label', default: 'Produto'), produtoInstance.id])
                redirect produtoInstance
            }
            '*'{ respond produtoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Produto produtoInstance) {

        if (produtoInstance == null) {
            notFound()
            return
        }

        produtoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Produto.label', default: 'Produto'), produtoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
