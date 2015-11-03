package producao

class Solicitação {

		static belongsTo = [nomeProduto:Produto, unidadeMedida:Medida, setorSolicitante:Setor, setorSolicitado:Setor, email:Servidor]
		Date dataSolicitação
		Double quantidade
		String status



    static constraints = {
			
			nomeProduto nullable:false, blank:false, maxSize: 50
			unidadeMedida nullable:false, blank:false, maxSize: 50
			quantidade nullable:false, blank:false, maxSize: 50
			setorSolicitante nullable:false, blank:false, maxSize: 50
			setorSolicitado nullable:false, blank:false, maxSize: 50
			dataSolicitação nullable:false, blank:false, maxSize: 50
			email maxSize: 50
			status nullable:false, blank:false, maxSize: 50
    }
}
