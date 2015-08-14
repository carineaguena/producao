package producao

class Medida {

	String descricao
	String tipo
	
	String toString(){
		this.descricao
	}

    static constraints = {
		descricao nullable:false, blank:false, maxSize: 50
		tipo nullable:false, blank:false, maxSize: 50
    }
}
