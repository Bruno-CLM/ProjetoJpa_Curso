package io.github.brunoclm.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private LocalDate dataPedido;
	
	@Column(length = 20, precision = 2)
	private BigDecimal totalPedido;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemsPedidos;

	public String getId() {
		return id;
	}

	public Cliente getClienteId() {
		return cliente;
	}

	public void setClienteId(Cliente clienteId) {
		this.cliente = clienteId;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	public List<ItemPedido> getItemsPedidos() {
		return itemsPedidos;
	}

	public void setItemsPedidos(List<ItemPedido> itemsPedidos) {
		this.itemsPedidos = itemsPedidos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente.getNome() + ", dataPedido=" + dataPedido + ", totalPedido="
				+ totalPedido + ", itemsPedidos=" + itemsPedidos + "]";
	}
	
}
