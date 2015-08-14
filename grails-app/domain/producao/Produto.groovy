package producao

class Produto {

	String nome
	Integer valor
	Double quantidade
	static belongsTo = [unidadeMedida:Medida]
	

    static constraints = {
		nome nullable:false, blank:false, maxSize: 50
		valor nullable:false, blank:false
		quantidade nullable:false
		unidadeMedida nullable:false
    }
}
