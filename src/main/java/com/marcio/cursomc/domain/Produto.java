package com.marcio.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Double price;
	
	

	//@JsonBackReference: decorator serve para avisar que o outro lado do relacionamento ja fez a busca dos objetos
	//@JsonBackReference: entao essa entidade nao precisar buscar os objetos, omite a categoria de cada produto
	
	//Criar relacionamento muitos pra muitos e tabela PRODUTO_CATEGORIA 
	//que tem "produto_id" e "categoria_id"
	@JsonBackReference()
	@ManyToMany
	@JoinTable(name="PRODUTO_CATEGORIA",
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categories = new ArrayList<>();
	
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Produto() {
	}

	public Produto(Integer id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public List<Pedido> getPedidos(){
		List<Pedido> list = new ArrayList<>();
		
		//Percorre todos os ItemPedido de itens
		for(ItemPedido x : itens) {
			list.add(x.getPedido());
		}
		
		return list;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Categoria> getCategories() {
		return categories;
	}

	public void setCategories(List<Categoria> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	
}
