package producao

class HomeController {

    def index() { 
       // redirect(controller:"produto", action:"index")
       render(view:'/home')
    } 
    
    def beforeInterceptor = [action:this.&auth, except:["index", "edit", "show"]]

    def auth() {
        if(!session.usuario) {
            redirect(controller:"autentica", action:"login")
            return false
        }
    }
    
}
