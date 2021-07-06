package com.marcio.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.cursomc.domain.Categoria;
import com.marcio.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//o decorator Autowired instancia automaticamente com injeção de depenência
	@Autowired
	private CategoriaService service;
	
	
	//e uma rota tipo GET que recebe id como request.params;
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		//@PathVarible avisa que é o valor do params como parametro
		
		Categoria obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
