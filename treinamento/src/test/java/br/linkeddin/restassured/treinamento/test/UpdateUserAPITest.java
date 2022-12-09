package br.linkeddin.restassured.treinamento.test;

import org.junit.jupiter.api.*;

/**
 * Classe para testes de API.
 */
public class UpdateUserAPITest 
{
	
	private static UpdateUserAPI api;
	
	//Iniciliza a API
	@BeforeAll
	public static void setup() {
		 api = new UpdateUserAPI();
		
	}
	
	//Imprime o corpo no final de cada teste
	@AfterAll
	public static void imprimeCorpo() {
		System.out.println("Test Alteração");
		api.logResposta();
	}
	
    /**
     * Verifica se a API fez a atualização completa
     */
    @Test
    public void atualizaUsuarios()
    {
    	String nome = "James Weberson";
    	String cargo = "Spyation";
    	int id = 2;
    	
    	api.chamarAPIAlteraUsuario(nome, cargo, id);
    	api.verificaStatus(200);
    	api.verificaUsuarioModificado(nome, cargo);

    }
    
    
    
    
    
}
