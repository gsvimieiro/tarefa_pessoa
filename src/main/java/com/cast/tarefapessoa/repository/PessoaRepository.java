package com.cast.tarefapessoa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cast.tarefapessoa.model.Pessoa;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, String>{

	Pessoa findById(long id);

}


