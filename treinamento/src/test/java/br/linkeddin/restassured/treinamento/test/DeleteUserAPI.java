/**
 * 
 */
package br.linkeddin.restassured.treinamento.test;

import br.linkedin.restassured.treinamento.UserAPI;
import io.restassured.http.ContentType;

/**
 * @author August Neto
 *
 *Classe que representa a API Delete User (https://reqres.in/)
 *
 */
public class DeleteUserAPI extends UserAPI {

	/**
	 * 
	 */
	
	//Construtor padrão
	public DeleteUserAPI() {
		super();
	}
	
	
	/**
	 * Chama o metodo delete de usuários e guarda o json de retorno
	 * 
	 * @param id  Id do usuario a ser pago
	 */
	public void chamarAPIApagaUsuario(int id) {
		String idusuario = Integer.toString(id);
		
		resposta = requisicao.contentType(ContentType.JSON).when().delete("/"+idusuario);
		guardarResposta();

	}

}
