package producao

class Cargo {
		
		String nome
		
    static constraints = {
			nome nullable:false, blank:false, maxSize: 50
    }
}
