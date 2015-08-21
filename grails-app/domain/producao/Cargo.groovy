package producao

class Cargo {
		
		String nome
                
    String toString(){
        this.nome
    }
		
		
    static constraints = {
			nome nullable:false, blank:false, maxSize: 50
    }
}
