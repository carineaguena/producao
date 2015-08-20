package producao

class Movimentacao {

		static belongsTo = [setorOrigem:Setor, setorDestino:Setor, nomeProduto:Produto]
		Double quantidade
		Date dataMovimentacao

    static constraints = {
	
		setorOrigem nullable:false, blank:false, maxSize: 50
		setorDestino nullable:false, blank:false, maxSize: 50
		nomeProduto nullable:false, blank:false, maxSize: 50
		quantidade nullable:false, blank:false, maxSize: 50
		dataMovimentacao nullable:false, blank:false, maxSize: 50
	
    }
}
