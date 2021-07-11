package com.marcio.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//classe nao possui id proprio, seu id e o pedido e item

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	//id dessa classe e uma classe auxiliar que tem o id do pedido e do item
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double discount;
	private Integer quantity;
	private Double price;
	
	public ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Produto produto, Double discount, Integer quantity, Double price) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
}
