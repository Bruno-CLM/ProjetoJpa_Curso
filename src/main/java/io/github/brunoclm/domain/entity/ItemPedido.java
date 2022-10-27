package io.github.brunoclm.domain.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name= "produto_id")
	private Produto produto;
	
	private Integer quantidade;

	public String getId() {
		return id;
	}

	public Pedido getPedidoId() {
		return pedido;
	}

	public void setPedidoId(Pedido pedidoId) {
		this.pedido = pedidoId;
	}

	public Produto getProdutoId() {
		return produto;
	}

	public void setProdutoId(Produto produtoId) {
		this.produto = produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", pedido=" + pedido + ", produto=" + produto + ", quantidade=" + quantidade
				+ "]";
	}

}
