/**
 * 
 */
package br.linkeddin.restassured.treinamento.test;

import org.hamcrest.Matchers;

import br.linkedin.restassured.treinamento.UserAPI;
import io.restassured.http.ContentType;

/**
 * @author August Neto
 *
 * Classe que representa a API Create User (https://reqres.in/)
 *
 */
public class CreateUserAPI extends UserAPI {

	//Estrutura do json de resposta
	private static final String PARAMETRO_NOME = "name";
	private static final String PARAMETRO_CARGO = "job";
	private static final String PARAMETRO_ID = "id";
	private static final String PARAMETRO_DATACRIACAO = "createdAt";
	
	//Construtor padrão
	public CreateUserAPI() {
		super();
	}

	/**
	 * 
	 * Chama a requisição post informando o nome e o cargo para cadastro
	 * 
	 * @param nome		a ser cadastrado
	 * @param cargo 	a ser cadastrado
	 */
	public void chamarAPICriaUsuarios(String nome, String cargo) {
		
		//monta o body para envio
		String corpo = "{\""+PARAMETRO_NOME+"\": \""+ nome+"\",\""+PARAMETRO_CARGO+"\": \""+cargo +"\"}";
		resposta=requisicao.body(corpo).contentType(ContentType.JSON).when().post();
		guardarResposta();	
	}

	/**
	 * 	Valida se de fato foi criado o usuario com os dados corretos
	 * 
	 * @param nome	nome esperado do usuario
	 * @param cargo cargo esperado do usuario
	 */
	public void verificaUsuarioCriado(String nome, String cargo) {
		
		 json.body(PARAMETRO_NOME, Matchers.is(nome))
	     .body(PARAMETRO_CARGO, Matchers.is(cargo))
	     .body(PARAMETRO_DATACRIACAO, Matchers.notNullValue())
	     .body(PARAMETRO_ID, Matchers.notNullValue()); 
		
	}
	
	

}
