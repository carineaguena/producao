package producao

class Produto {

		String nome
		Double valor
		Double quantidade
		static belongsTo = [unidadeMedida:Medida,setorProducao:Setor]
	
		String toString(){
		this.nome
	}		


    static constraints = {
		nome nullable:false, blank:false, maxSize: 50
		valor nullable:true, blank:true, maxSize: 50
		unidadeMedida nullable:false
		setorProducao nullable:false
		
    }
}
