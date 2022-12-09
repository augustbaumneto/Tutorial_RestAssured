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
 * Classe que representa a API Update User (https://reqres.in/)
 *
 */
public class UpdateUserAPI extends UserAPI {

	//private ArrayList<> data;
	//private ArrayList<> support;

	//Estrutura do json de resposta
	private static final String PARAMETRO_NOME = "name";
	private static final String PARAMETRO_CARGO = "job";
	private static final String PARAMETRO_DATAALTERACAO = "updatedAt";

	
	
	
	//Construtor padrão
	public UpdateUserAPI() {
		super();
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
		
		//monta o body para envio
		String corpo = "{\""+PARAMETRO_NOME+"\": \""+ nome+"\",\""+PARAMETRO_CARGO+"\": \""+cargo +"\"}";
		resposta=requisicao.body(corpo).contentType(ContentType.JSON).when().put("/"+idusuario);
		guardarResposta();	
	}
	
	/**
	 * 	Valida se de fato foi criado o usuario com os dados corretos
	 * 
	 * @param nome	nome esperado do usuario
	 * @param cargo cargo esperado do usuario
	 */
	public void verificaUsuarioModificado(String nome, String cargo) {
		
		 json.body(PARAMETRO_NOME, Matchers.is(nome))
	     .body(PARAMETRO_CARGO, Matchers.is(cargo))
	     .body(PARAMETRO_DATAALTERACAO, Matchers.notNullValue());
		
	}
	
}
