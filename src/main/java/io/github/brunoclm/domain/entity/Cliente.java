package io.github.brunoclm.domain.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	private String id = UUID.randomUUID().toString();
	@Column(length = 100)
	private String nome;
	
	public Cliente() {}
	
	public Cliente(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Cliente(String nome) {
		super();
		this.nome = nome;
	}
	
	
	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}
	
}
