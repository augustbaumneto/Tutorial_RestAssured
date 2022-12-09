package br.linkeddin.restassured.treinamento.test;

import org.junit.jupiter.api.*;

/**
 * Classe para testes de API.
 */
public class DeleteUserAPITest 
{
	
	private static DeleteUserAPI api;
	
	//Iniciliza a API
	@BeforeAll
	public static void setup() {
		 api = new DeleteUserAPI();
		
	}
	
	//Imprime o corpo no final de cada teste
	@AfterAll
	public static void imprimeCorpo() {
		System.out.println("Test Apaga");
		api.logResposta();
	}
	
    /**
     * Verifica se a API esta funcionando e apaga o Usuario
     */
    @Test
    public void apagaUsuarios()
    {
    	int id = 2;
    	
    	api.chamarAPIApagaUsuario(id);
    	api.verificaStatus(204);
    	
    }
    
    
    
    
    
}
