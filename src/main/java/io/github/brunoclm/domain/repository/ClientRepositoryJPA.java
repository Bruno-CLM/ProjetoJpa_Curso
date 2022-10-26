package io.github.brunoclm.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.brunoclm.domain.entity.Cliente;
import io.github.brunoclm.querys.JpqlCliente;

@Repository
public class ClientRepositoryJPA {
	
	@Autowired
	private EntityManager entityManager;

	//POST
	@Transactional
	public Boolean salvar(Cliente cliente) {
		try {
			entityManager.persist(cliente);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Boolean.FALSE;
	}
	
	//GET
	@Transactional(readOnly = true)
	public List<Cliente> listarClientes() {
		return entityManager.createQuery(JpqlCliente.SELECT_ALL, Cliente.class).getResultList();
	}
	
	//GET
	@Transactional(readOnly = true)
	public List<Cliente> listarPorNome(String nome){
		TypedQuery<Cliente> query = entityManager.createQuery(JpqlCliente.SELECT_BY_NAME, Cliente.class);
		query.setParameter("nome", "&" + nome + "%");
		return query.getResultList();
	}
	
	//PUT
	@Transactional
	public Boolean updateCliente(Cliente cliente) {
		try {
			entityManager.merge(cliente);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return Boolean.FALSE;
	}
	
	//Delete 
	@Transactional
	public Boolean deletarClientePorId(String id) {
		try {
			
			Cliente cliente = entityManager.find(Cliente.class, id);
			deletarCliente(cliente);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Boolean.FALSE;
	}
	
	//Delete 
	@Transactional
	public Boolean deletarCliente(Cliente cliente) {
		try {
			if(!entityManager.contains(cliente)) {
				entityManager.merge(cliente);
			}
			entityManager.remove(cliente);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Boolean.FALSE;
	}
}
