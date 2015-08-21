package producao

class Usuario {

    String login
    String password
    String name
    
    
    static constraints = {
        login(unique:true)
        password(password:true)
        name()
    }

    String toString(){
        this.name
    }
}
