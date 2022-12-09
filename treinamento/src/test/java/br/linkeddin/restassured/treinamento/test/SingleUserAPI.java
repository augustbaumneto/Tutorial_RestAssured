/**
 * 
 */
package br.linkeddin.restassured.treinamento.test;


import br.linkedin.restassured.treinamento.UserAPI;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

/**
 * @author August Neto
 *
 * Classe que representa a API Single User (https://reqres.in/)
 *
 */
public class SingleUserAPI extends UserAPI {

	//Parametros da resposta 
	private static final String PARAM_RESP_TOTAL = "total";
	private static final String PARAM_RESP_ID = "id";
	private static final String PARAM_RESP_EMAIL = "email";
	private static final String PARAM_RESP_FIRSTNAME = "first_name";
	private static final String PARAM_RESP_LASTNAME = "last_name";
	private static final String PARAM_RESP_AVATAR = "avatar";
	
	
	//Construtor padrão
	public SingleUserAPI() {
		super();

	}

	/**
	 * Prepara a requisição
	 */
	private void montaAPIListaUsuarios() {
		requisicao = 
				RestAssured.given();				
				
	}
	
	/**
	 * Chama o metodo get de lista de usuários e guarda o json de retorno
	 * 
	 */
	public void chamarAPIListaUsuarios() {
		montaAPIListaUsuarios();
		resposta = requisicao
				.when()
					.get();
		guardarResposta();

	}
	
	/**
	 * 	Valida se a lista de usuario retornou
	 * 
	 */
	public void verificaListaRetornada() {

		 json
		 	.assertThat().body("data[0]."+PARAM_RESP_FIRSTNAME,equalTo("George"))
		 	.assertThat().body("data[0]."+PARAM_RESP_EMAIL,equalTo("george.bluth@reqres.in"))
		 	.assertThat().body("data[0]."+PARAM_RESP_LASTNAME,equalTo("Bluth"))
		    .assertThat().body("data[0]."+PARAM_RESP_ID,equalTo(1))
		    .assertThat().body("data[0]."+PARAM_RESP_AVATAR,notNullValue())
		 	.assertThat().body(PARAM_RESP_TOTAL,equalTo(12));
		
	}
	
	
}
