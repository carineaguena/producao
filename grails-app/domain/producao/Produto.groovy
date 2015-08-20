package producao

class Produto {

	String nome
	Double valor
	Double quantidade
        
    
	static belongsTo = [unidadeMedida:Medida,setorProducao:Setor]
						

    static constraints = {
		nome nullable:false, blank:false, maxSize: 50
		valor nullable:false, blank:false
		quantidade nullable:false
		unidadeMedida nullable:false
		setorProducao nullable:false
		
    }
}
