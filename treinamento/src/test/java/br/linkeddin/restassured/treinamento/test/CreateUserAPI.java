/**
 * 
 */
package br.linkeddin.restassured.treinamento.test;

import static org.hamcrest.Matchers.*;

import br.linkedin.restassured.treinamento.UserAPI;
import static io.restassured.RestAssured.*;
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
	 * Prepara a requisição
	 */
	private void montaRequisicaoCriaUsuarios(String nome, String cargo) {
		String corpo = "{\""+PARAMETRO_NOME+"\": \""+ nome+"\",\""+PARAMETRO_CARGO+"\": \""+cargo +"\"}";
		requisicao=
			given()
				.body(corpo)
				.contentType(ContentType.JSON);				
				
	}
	
	/**
	 * 
	 * Chama a requisição post informando o nome e o cargo para cadastro
	 * 
	 * @param nome		a ser cadastrado
	 * @param cargo 	a ser cadastrado
	 */
	public void chamarAPICriaUsuarios(String nome, String cargo) {

		montaRequisicaoCriaUsuarios(nome, cargo);
		
		resposta=requisicao
					.when()
						.post();
		guardarResposta();	
	}

	/**
	 * 	Valida se de fato foi criado o usuario com os dados corretos
	 * 
	 * @param nome	nome esperado do usuario
	 * @param cargo cargo esperado do usuario
	 */
	public void verificaUsuarioCriado(String nome, String cargo) {
		
		 json
		 	.assertThat().body(PARAMETRO_NOME, is(nome))
		 	.assertThat().body(PARAMETRO_CARGO, is(cargo))
		 	.assertThat().body(PARAMETRO_DATACRIACAO, notNullValue())
		 	.assertThat().body(PARAMETRO_ID, notNullValue()); 
		
	}

}
