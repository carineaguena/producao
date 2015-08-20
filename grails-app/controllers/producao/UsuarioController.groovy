package producao

class UsuarioController {

  def scaffold = Usuario

  def login = {}

  def authenticate = {
    def usuario = Usuario.findByLoginAndPassword(params.login, params.password)
    if(usuario){
      session.usuario = usuario
      flash.message = "Hello ${usuario.name}!"
      redirect(controller:"home", action:"index")
    }else{
      flash.message = "Sorry, ${params.login}. Please try again."
      redirect(action:"login")
    }
  }

  def logout = {
    flash.message = "Goodbye ${session.usuario.name}"
    session.usuario = null
    redirect(controller:"usuario", action:"login")
  }
  
 
}
