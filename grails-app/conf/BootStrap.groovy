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
			new Medida(descricao: "Peso", tipo:"Kg").save()
			new Medida(descricao: "Liquido", tipo:"Lt").save()
		}
    	//carrega os setores no banco de dados
    	if (!Setor.count()){
			new Setor(nome: "Agroindústria").save()
			new Setor(nome: "Cozinha").save()
		}
    }
    def destroy = {
    }
}
