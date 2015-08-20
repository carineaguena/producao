package producao

class Solicitacao {

		static belongsTo = [nomeProduto:Produto, setorSolicitante:Setor, setorSolicitado:Setor, unidadeMedida:Medida]
		Date dataSolicitacao
		Date dataPrevista
		Double quantidade
		

    static constraints = {
			
			nomeProduto nullable:false, blank:false, maxSize: 50
			setorSolicitante nullable:false, blank:false, maxSize: 50
			setorSolicitado nullable:false, blank:false, maxSize: 50
			quantidade nullable:false, blank:false, maxSize: 50
			unidadeMedida nullable:false, blank:false, maxSize: 50
			dataSolicitacao nullable:false, blank:false, maxSize: 50
			dataPrevista nullable:false, blank:false, maxSize: 50
    }
}
