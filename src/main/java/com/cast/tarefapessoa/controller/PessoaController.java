package com.cast.tarefapessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cast.tarefapessoa.model.Pessoa;
import com.cast.tarefapessoa.repository.PessoaRepository;

// RestController por se tratar de uma classe essencialmente REST
@RestController
@RequestMapping("/rest")
public class PessoaController {
	
	// Injecao do Repositorio Pessoa
	@Autowired
	private PessoaRepository pessoaDAO;
	
	// Listar Pessoas
	@GetMapping("/pessoas")
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(pessoaDAO.findAll(), HttpStatus.OK);
	}
	
	// Buscar Pessoa por ID
	@GetMapping(path = "/pessoa/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") long id){
		Pessoa pessoa = pessoaDAO.findById(id);
		if (pessoa !=null) {
			return new ResponseEntity<>(pessoaDAO.findById(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	// Salvar Pessoa
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Pessoa pessoa){
		return new ResponseEntity<>(pessoaDAO.save(pessoa), HttpStatus.OK);
	}

	// Deletar Pessoa por ID
	@DeleteMapping(path = "/remove/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") long id){
		Pessoa pessoa = pessoaDAO.findById(id);
		if (pessoa != null) {
			pessoaDAO.delete(pessoa);
			return new ResponseEntity<>( HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	// Alterar Pessoa
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Pessoa pessoa){
		pessoaDAO.save(pessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
