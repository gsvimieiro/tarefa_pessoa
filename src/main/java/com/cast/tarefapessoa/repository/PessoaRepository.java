package com.cast.tarefapessoa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cast.tarefapessoa.model.Pessoa;

// Extentendo de PagingAndSortingRepository
// para garantir a Paginação e o Sort nativos do Spring
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, String>{

	Pessoa findById(long id);

}


