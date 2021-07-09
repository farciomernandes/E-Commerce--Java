package com.marcio.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcio.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	//arquivp interface do JpaRepository que acessa o db
	//recebe como parametro o nome da classe da tabela e o tipo do id da tabela
	
	

}
