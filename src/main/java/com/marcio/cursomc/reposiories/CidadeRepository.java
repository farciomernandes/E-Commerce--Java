package com.marcio.cursomc.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcio.cursomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	//arquivp interface do JpaRepository que acessa o db
	//recebe como parametro o nome da classe da tabela e o tipo do id da tabela
	
	

}
