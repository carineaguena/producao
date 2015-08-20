package producao

class Servidor {

		Integer siape 
		String nome
		String email
		Integer ramal
		String senha
		
		
		static belongsTo = [cargo:Cargo, setor:Setor]

    static constraints = {
	
			siape nullable:false, blank:false, maxSize: 50
			nome nullable:false, blank:false, maxSize: 50
			email nullable:false, blank:false, maxSize: 50
			ramal nullable:false, blank:false, maxSize: 50
			cargo nullable:false, blank:false, maxSize: 50
			setor nullable:false, blank:false, maxSize: 50
			senha nullable:false, blank:false, maxSize: 50
    }
}
