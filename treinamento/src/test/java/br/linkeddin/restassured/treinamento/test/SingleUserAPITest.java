package br.linkeddin.restassured.treinamento.test;

import org.junit.jupiter.api.*;

/**
 * Classe para testes de API.
 */
public class SingleUserAPITest 
{
	
	private static SingleUserAPI api;
	
	//Iniciliza a API
	@BeforeAll
	public static void setup() {
		 api = new SingleUserAPI();

	}
	
	//Imprime o corpo no final de cada teste
	@AfterAll
	public static void imprimeCorpo() {
		System.out.println("Test Consulta Lista");
		System.out.println(api.retornaBody());
	}
	
    /**
     * Verifica se a API esta funcionando e retornando todos os usuarios
     */
    @Test
    public void listaUsuarios()
    {
    	api.chamarAPIListaUsuarios();
    	api.verificaStatus(200);
    
    }
    
    
    
    
    
}
