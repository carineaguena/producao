package producao

class Solicitacao {

		static belongsTo = [nomeProduto:Produto, unidadeMedida:Medida, setorSolicitante:Setor, setorSolicitado:Setor, email:Servidor]
		Date dataSolicitacao
		Double quantidade
		String status


		

    static constraints = {
			
			nomeProduto nullable:false, blank:false, maxSize: 50
			unidadeMedida nullable:false, blank:false, maxSize: 50
			quantidade nullable:false, blank:false, maxSize: 50
			setorSolicitante nullable:false, blank:false, maxSize: 50
			setorSolicitado nullable:false, blank:false, maxSize: 50
			dataSolicitacao nullable:false, blank:false, maxSize: 50
			email maxSize: 50
			status nullable:false, blank:false, maxSize: 50
    }
}
