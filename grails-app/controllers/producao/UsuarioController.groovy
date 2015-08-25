package producao

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class UsuarioController {

  def scaffold = Usuario

  def login = {}
  
    @Transactional
    def save(Usuario userInstance) {
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

  def authenticate = {
    def passwordHashed = params.password.encodeAsPassword()
    def usuario = Usuario.findByLoginAndPassword(params.login, passwordHashed)
    //def usuario = Usuario.findByLoginAndPassword(params.login, params.password)
    if(usuario){
      session.usuario = usuario
     // flash.message = true
      //loga e manda para pagina do controle
      render(view:'/home')
    }else{
    //  flash.message = false
      redirect(action:"login")
    }
  }

  def logout = {

   // flash.message = false
    session.usuario = null
    //desloga e manda para a pagina inicial do servidor
    render(view:"/index")
  }
  
 
}