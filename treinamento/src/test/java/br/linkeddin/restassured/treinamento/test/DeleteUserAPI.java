/**
 * 
 */
package br.linkeddin.restassured.treinamento.test;

import br.linkedin.restassured.treinamento.UserAPI;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

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
	 * Prepara a requisição
	 */
	private void montaRequisicaoApagaUsuarios() {
		requisicao=
				given()
				.contentType(ContentType.JSON);
					
	}
	
	
	/**
	 * Chama o metodo delete de usuários e guarda o json de retorno
	 * 
	 * @param id  Id do usuario a ser pago
	 */
	public void chamarAPIApagaUsuario(int id) {
		
		montaRequisicaoApagaUsuarios();
		String idusuario = Integer.toString(id);
		
		resposta = requisicao
				.when()
					.delete("/"+idusuario);
		guardarResposta();

	}

}
