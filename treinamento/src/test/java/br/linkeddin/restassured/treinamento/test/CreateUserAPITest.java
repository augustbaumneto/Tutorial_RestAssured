package br.linkeddin.restassured.treinamento.test;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

/**
 * Classe para testes de API.
 */
public class CreateUserAPITest 
{
	
	public static CreateUserAPI api;
	
	//Iniciliza a API
	@BeforeAll
	public static void setup() {
		 api = new CreateUserAPI();
		
	}
	
	//Imprime o corpo no final de cada teste
	@AfterAll
	public static void imprimeCorpo() {
		System.out.println("Test Criação");
		api.logResposta();
	}
	
    /**
     * Verifica se a API esta funcionando e cria Usuario
     */
    @Test
    public void criaUsuarios()
    {
    	String nome = "James Web";
    	String cargo = "Spy";
    	
    	api.chamarAPICriaUsuarios(nome,cargo);
    	api.verificaStatus(201);
    	
    	api.verificaUsuarioCriado(nome, cargo);
    }
    
    
    
    
    
}
