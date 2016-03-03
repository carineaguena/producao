package producao


import producao.*
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
            redirect(controller:"autentica", action:"login")
            return false
        }
    }

    //até aqui

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

         //ALTERA ESTOQUE ATUAL

        if (solicitacaoInstance.status == "Atendido"){


            String hql = "select est from Estoque est where est.setorDeOrigemDoProduto = :setor " +
                " AND est.nomeProduto = :nomeProduto"

            def result = Estoque.executeQuery(hql, [setor:solicitacaoInstance.setorSolicitado, nomeProduto:solicitacaoInstance.nomeProduto])

            def Double valorBanco = result[0].quantidade
            def Double valorDigitado = solicitacaoInstance.quantidade.toDouble()
            def resultado = valorBanco - valorDigitado

            result[0].quantidade = resultado
            result[0].save()
            if(result[0].hasErrors()){
                render("tem erro")
            }else{
                //def resultado_nomeProduto = result.nomeProduto
                //def resultado_setor = result.setorDeOrigemDoProduto
                /*Estoque.executeUpdate("update Estoque set quantidade = :resultado where nomeProduto = :nomeProduto " +
                    " and setorDeOrigemDoProduto = :setorDeOrigemDoProduto", 
                    [resultado:resultado, nomeProduto:result.nomeProduto, setorDeOrigemDoProduto:result.setorDeOrigemDoProduto])*/

                //ALTERA O ESTOQUE DESTINO
                hql = "select est from Estoque est where est.setorDeOrigemDoProduto = :setorDestino " + 
                    " AND est.nomeProduto.id = :nomeProdutoDestino"
                def estoqueDestino = Estoque.executeQuery(hql, [setorDestino:solicitacaoInstance.setorSolicitante, 
                        nomeProdutoDestino:result[0].nomeProduto.id])

                if (estoqueDestino) {
                    estoqueDestino[0].quantidade += valorDigitado
                    estoqueDestino[0].save() 
                }else{
                    estoqueDestino  = new Estoque()
                    estoqueDestino.quantidade = valorDigitado
                    estoqueDestino.unidadeMedida = result[0].nomeProduto.unidadeMedida
                    estoqueDestino.nomeProduto = result[0].nomeProduto
                    estoqueDestino.setorDeOrigemDoProduto = solicitacaoInstance.setorSolicitante
                    estoqueDestino.dataDaMovimentacao = new Date()
                    estoqueDestino.save() 
                }            

                //GERA MOVIMENTAÇÃO
                Movimentacao movimentacao = new Movimentacao()
                movimentacao.setorOrigem = solicitacaoInstance.setorSolicitado
                movimentacao.setorDestino = solicitacaoInstance.setorSolicitante
                movimentacao.nomeProduto = solicitacaoInstance.nomeProduto
                movimentacao.quantidade = solicitacaoInstance.quantidade
                movimentacao.dataMovimentacao = new Date()
            
                solicitacaoInstance.validate()
                if(!solicitacaoInstance.hasErrors()){
                    solicitacaoInstance.save flush:true
                    movimentacao.save()
                }
                else{
                    solicitacaoInstance.save flush:false
                    estoqueDestino[0].save flush:false
                    movimentacao.save flush:false
                    estoqueDestino.save flush:false
                }
            }
        }
        else{
            solicitacaoInstance.save flush:true

            Double aa = result[0].quantidade
            Double bb = solicitacaoInstance.quantidade.toDouble()
           // render(result.quantidade+" -+= "+solicitacaoInstance.quantidade+" "+(aa - bb))
          
           // result.quantidade = (aa - bb)
           //Estoque.quantidade = (aa - bb)
           def resultado = aa - bb
           def resultado_nomeProduto = result.nomeProduto
           def resultado_setor = result.setorDeOrigemDoProduto

          // render(result.setorDeOrigemDoProduto)
          

           Estoque.executeUpdate("update Estoque set quantidade = :resultado where nomeProduto = :nomeProduto and setorDeOrigemDoProduto = :setorDeOrigemDoProduto", [resultado:resultado, nomeProduto:result.nomeProduto, setorDeOrigemDoProduto:result.setorDeOrigemDoProduto])

        }

        //até aqui

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
