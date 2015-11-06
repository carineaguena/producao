package producao

class Estoque {
		
		Date dataDaMovimentacao
		Double quantidade 
		static belongsTo = [unidadeMedida:Medida, nomeProduto:Produto, setorDeOrigemDoProduto:Setor]
		//static belongsTo = [nomeProduto:Produto, setorDeOrigemDoProduto:Setor]

    static constraints = {
		quantidade(min: new Double(0))//, nullable:false, blank:false, maxSize: 50
		unidadeMedida nullable:false, blank:false, maxSize: 50
		nomeProduto nullable:false, blank:false, maxSize: 50
		setorDeOrigemDoProduto nullable:false, blank:false, maxSize: 50
		dataDaMovimentacao nullable:false, blank:false, maxSize: 50
	
    }
}
