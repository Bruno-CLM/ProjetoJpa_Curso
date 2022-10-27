package io.github.brunoclm.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(length = 300)
	private String descricao;
	
	@Column(name="preco_unitario")
	private BigDecimal preco_Unitario;

	public String getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco_Unitario() {
		return preco_Unitario;
	}

	public void setPreco_Unitario(BigDecimal preco_Unitario) {
		this.preco_Unitario = preco_Unitario;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", preco_Unitario=" + preco_Unitario + "]";
	}
	
}
