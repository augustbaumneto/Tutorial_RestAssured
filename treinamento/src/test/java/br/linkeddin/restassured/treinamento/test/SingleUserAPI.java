/**
 * 
 */
package br.linkeddin.restassured.treinamento.test;

import java.util.ArrayList;

import br.linkedin.restassured.treinamento.UserAPI;

/**
 * @author August Neto
 *
 * Classe que representa a API Single User (https://reqres.in/)
 *
 */
public class SingleUserAPI extends UserAPI {

	//private ArrayList<> data;
	//private ArrayList<> support;
	
	
	//Construtor padrão
	public SingleUserAPI() {
		super();

	}

	/**
	 * Chama o metodo get de lista de usuários e guarda o json de retorno
	 * 
	 */
	public void chamarAPIListaUsuarios() {
		resposta = requisicao.when().get();
		guardarResposta();

	}
	
	
}
