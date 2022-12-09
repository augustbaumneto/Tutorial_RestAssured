/**
 * 
 */
package br.linkeddin.restassured.treinamento.test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import br.linkedin.restassured.treinamento.UserAPI;
import io.restassured.http.ContentType;

/**
 * @author August Neto
 *
 * Classe que representa a API Update User (https://reqres.in/)
 *
 */
public class UpdateUserAPI extends UserAPI {



	//Estrutura do json de resposta
	private static final String PARAMETRO_NOME = "name";
	private static final String PARAMETRO_CARGO = "job";
	private static final String PARAMETRO_DATAALTERACAO = "updatedAt";

	
	
	
	//Construtor padrão
	public UpdateUserAPI() {
		super();
	}

	/**
	 * Prepara a requisição
	 */
	private void montaRequisicaoAtualizaUsuario(String nome, String cargo) {
		String corpo = "{\""+PARAMETRO_NOME+"\": \""+ nome+"\",\""+PARAMETRO_CARGO+"\": \""+cargo +"\"}";
		requisicao=
			given()
				.body(corpo)
				.contentType(ContentType.JSON);				
				
	}
	
	/**
	 * 
	 * Chama a requisição put informando o id para procura e os dados nome e cargo para atualizar
	 * 
	 * @param nome		a ser alterado
	 * @param cargo 	a ser alterado
	 * @param id		do usuário a ser modificado
	 * 
	 */
	public void chamarAPIAlteraUsuario(String nome, String cargo, int id) {
		String idusuario = Integer.toString(id);
		montaRequisicaoAtualizaUsuario(nome, cargo);
		
		resposta=requisicao
				.when()
					.put("/"+idusuario);
		guardarResposta();	
	}
	
	/**
	 * 	Valida se de fato foi criado o usuario com os dados corretos
	 * 
	 * @param nome	nome esperado do usuario
	 * @param cargo cargo esperado do usuario
	 */
	public void verificaUsuarioModificado(String nome, String cargo) {
		
		 json
		 	.assertThat().body(PARAMETRO_NOME, is(nome))
		 	.assertThat().body(PARAMETRO_CARGO, is(cargo))
		 	.assertThat().body(PARAMETRO_DATAALTERACAO, notNullValue());
		
	}
	
}
