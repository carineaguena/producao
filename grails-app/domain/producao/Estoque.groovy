package producao

class Estoque {
		
		Double quantidade 
		static belongsTo = [unidadeMedida:Medida, nomeProduto:Produto, setorProducao:Setor]

    static constraints = {
	
		quantidade nullable:false, blank:false, maxSize: 50
		unidadeMedida nullable:false, blank:false, maxSize: 50
		nomeProduto nullable:false, blank:false, maxSize: 50
		setorProducao nullable:false, blank:false, maxSize: 50
	
    }
}
