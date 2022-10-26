package io.github.brunoclm.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {
	
	private String id = UUID.randomUUID().toString();
	
	private String descricao;
	
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
}
