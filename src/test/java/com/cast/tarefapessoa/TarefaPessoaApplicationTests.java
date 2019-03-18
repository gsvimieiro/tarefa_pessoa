package com.cast.tarefapessoa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cast.tarefapessoa.controller.PessoaController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TarefaPessoaApplicationTests {

	@Autowired 
	private PessoaController pc;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void pessoaControllerTest() {
		ResponseEntity<?> rs;
		
		rs = pc.getById(2);
		
	}
	
	@Before
	public void before() {
		System.out.println("Iniciando os testes");
	}

	@After
	public void after() {
		System.out.println("Término dos testes");
	}
}
