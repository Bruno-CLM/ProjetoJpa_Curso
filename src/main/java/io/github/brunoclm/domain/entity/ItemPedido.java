package io.github.brunoclm.domain.entity;

import java.util.UUID;

public class ItemPedido {
	
	private String id = UUID.randomUUID().toString();
	
	private Pedido pedidoId;
	
	private Produto produtoId;
	
	private Integer quantidade;

	public String getId() {
		return id;
	}

	public Pedido getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Pedido pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Produto getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
