/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * classe que cria o filtro de acesso para controlar o login
 * @author carineaguena
 */

class AutenticacaoFilters {
    
    def Filters = {
        FiltroAcesso(controller:'post',action:"(create|edit|update|delete|save)"){
            before = {
                if(!session.usuario && !actionName.equals('login')){
                    redirect(controller:'usuario', action:'login')
                    return false
                }
                return true
            }
        }
    }
	
}

