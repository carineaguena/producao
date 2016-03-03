package producao

class LoginTagLib {
    //static defaultEncodeAs = [taglib:'text']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def loginControl = {
        
        if(session.usuario){
            out << "Olá ${session.usuario.name}, "
            //out << """[${link(action:"logout", controller:"usuario"){"Logout"}}]"""
            out << g.link(action:"logout", controller:"autentica"){"Logout"}
            
        } else {
            out << g.link(action:"login", controller:"autentica"){"Login"}
            }
           
    }
}