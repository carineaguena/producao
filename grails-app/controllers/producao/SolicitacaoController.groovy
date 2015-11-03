package producao


import producao.Estoque
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

        //começa aqui

        if (solicitacaoInstance.status == "Atendido"){
            String hql = "select est from Estoque est where est.setorDeOrigemDoProduto = :setor " +
                " AND est.nomeProduto = :nomeProduto"
            
            //def result = Estoque.get(1)

            //Double bb = solicitacaoInstance.quantidade
            //Double aa = result.quantidade.toDouble()
            
            //render(result.quantidade+" -+= "+solicitacaoInstance.quantidade+" "+(aa - bb))
            def result = Estoque.executeQuery(hql, [setor:solicitacaoInstance.setorSolicitado, nomeProduto:solicitacaoInstance.nomeProduto])
            Double aa = result[0].quantidade
            Double bb = solicitacaoInstance.quantidade.toDouble()
            render(result.quantidade+" -+= "+solicitacaoInstance.quantidade+" "+(aa - bb))
          
            result.quantidade = (aa - bb)
        }

        //até aqui

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
