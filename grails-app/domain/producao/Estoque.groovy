package producao

class Estoque {
		
		Date dataDaMovimentação
		Double quantidade 
		static belongsTo = [unidadeMedida:Medida, nomeProduto:Produto, setorDeOrigemDoProduto:Setor]

    static constraints = {
	
		quantidade nullable:false, blank:false, maxSize: 50
		unidadeMedida nullable:false, blank:false, maxSize: 50
		nomeProduto nullable:false, blank:false, maxSize: 50
		setorDeOrigemDoProduto nullable:false, blank:false, maxSize: 50
		dataDaMovimentação nullable:false, blank:false, maxSize: 50
	
    }
}
