package com.marcio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcio.cursomc.domain.Categoria;
import com.marcio.cursomc.domain.Produto;
import com.marcio.cursomc.reposiories.CategoriaRepository;
import com.marcio.cursomc.reposiories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	//CommandLineRunner executa o metodo "run" antes de iniciar essa classe
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//executa esse metodo antes de iniciar o projeto
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
	
		Produto p1 =  new Produto(null, "Computador", 2000.00);
		Produto p2 =  new Produto(null, "Impressora", 800.00);
		Produto p3 =  new Produto(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
