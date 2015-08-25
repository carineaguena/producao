package producao

class HomeController {

    def index() { 
        render(view:'/home')
    } 
    
    def beforeInterceptor = [action:this.&auth, except:["index", "edit", "show"]]

    def auth() {
        if(!session.usuario) {
            redirect(controller:"usuario", action:"login")
            return false
        }
    }
    
}
