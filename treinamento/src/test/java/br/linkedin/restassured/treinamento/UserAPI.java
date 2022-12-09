/**
 * 
 */
package br.linkedin.restassured.treinamento;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * @author August Neto
 *
 * Classe base da API Usuários
 *
 */
public class UserAPI {

	// URL da api para consulta de usuário único
		protected static final String URI_USERS = "https://reqres.in/api/users";
		
		protected RequestSpecification requisicao;
		protected Response resposta;
		protected ValidatableResponse json;
		protected JsonPath jsonpath;
	
	
	/**
	 * 
	 */
	protected UserAPI() {
		//Construtor padrão
		RestAssured.baseURI = URI_USERS;
		//Monta a requisição padrão
		requisicao = RestAssured.given();

	}
	
	/**
	 * Guardar os dados da requisição
	 * 
	 */
	protected void guardarResposta() {
		
		//Guarda a resposta
		json = resposta.then();
		jsonpath =resposta.jsonPath();

	}
	
	/**
	 *   Verifica o codigo de retorno da resposta da API
	 * 
	 * @param codigoretorno int para checar o status html do retorno
	 */
	public void verificaStatus(int codigoretorno) {

			json.statusCode(codigoretorno);
	}
	
	/**
	 *   Retorna o corpo
	 * 
	 */
	
	public String retornaBody() {

		return resposta.prettyPrint();
	}

}
