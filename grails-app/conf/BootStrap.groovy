import producao.*

class BootStrap {

    def init = { servletContext ->
    	//carrega os usuarios no banco de dados
    	if (!Usuario.count()){
    		def passwordHashed = "admin".encodeAsPassword()

			new Usuario(login: 'usuario', password: passwordHashed, name: 'Usuário do Sistema').save()
			new Usuario(login: 'admin', password: passwordHashed, name: 'Administrador').save()
		}
		//carrega os cargos no banco de dados
    	if (!Cargo.count()){
			new Cargo(nome: "Veterinário").save()
			new Cargo(nome: "Técnico Agropecuário").save()

		}
		//carrega as medidas no banco de dados
		if (!Medida.count()){
			def medida = new Medida(descricao: "Peso", tipo:"Kg").save()
			new Medida(descricao: "Liquido", tipo:"Lt").save()
		}
    	//carrega os setores no banco de dados
    	if (!Setor.count()){
			def setor = new Setor(nome: "Agroindústria").save()
			new Setor(nome: "Cozinha").save()
		}
		//carrega os produtos
		if (!Produto.count()){
			//new Produto(nome: "Carne", valor:"0.0", quantidade:"0", unidadeMedida:medida, setorProducao:setor).save()
		
		}
    }
    def destroy = {
    }
}
