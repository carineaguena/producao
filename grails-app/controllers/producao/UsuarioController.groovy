package producao

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class UsuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def scaffold = Usuario

  // def login = {}

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
    
    def save(Usuario userInstance) {
        if (params.confirmacao == userInstance.password){

        if (userInstance == null) {
            notFound()
            return
        }



        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'create'
            return
        }

        userInstance.password = userInstance.password.encodeAsPassword()

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*' { respond userInstance, [status: CREATED] }
        }
      }
      else{ 
          flash.message = "Desculpe, as senhas não são iguais. Por favor, tente novamente."
          redirect(action: "create")
        }
  }

  @Transactional
    def update(Usuario userInstance) {

      if (params.confirmacao == userInstance.password){


        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond medidaInstance.errors, view:'edit'
            return
        }

      userInstance.password = userInstance.password.encodeAsPassword()        

      userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond medidaInstance, [status: OK] }
        }
    }
    else{ 
          flash.message = "Desculpe, as senhas não são iguais. Por favor, tente novamente."
          redirect(action: "edit", id: userInstance.id)
        }


  }




/*  def authenticate = {
    def passwordHashed = params.password.encodeAsPassword()
    def usuario = Usuario.findByLoginAndPassword(params.login, passwordHashed)
    //def usuario = Usuario.findByLoginAndPassword(params.login, params.password)
    if(usuario){
      session.usuario = usuario
      //flash.message = "Olá ${usuario.name}!"
      //loga e manda para pagina do controle
      render(view:'/home')
    }else{
      flash.message = "Desculpe, ${params.login}. Por favor, tente novamente."
      redirect(action:"login")
    }
  }

  def logout = {
    //flash.message = "Até mais ${session.usuario.name}"
    session.usuario = null
    //desloga e manda para a pagina inicial do servidor
    render(view:"/home")
  }*/
  
 
}