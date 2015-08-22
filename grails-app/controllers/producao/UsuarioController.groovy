package producao

class UsuarioController {

  def scaffold = Usuario

  def login = {}

  def authenticate = {
    def usuario = Usuario.findByLoginAndPassword(params.login, params.password)
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
  }
  
 
}
