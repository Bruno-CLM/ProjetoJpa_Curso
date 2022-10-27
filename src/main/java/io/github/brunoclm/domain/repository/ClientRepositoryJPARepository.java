package io.github.brunoclm.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import io.github.brunoclm.domain.entity.Cliente;

public interface ClientRepositoryJPARepository extends JpaRepository<Cliente, String> {

	// select c from Cliente c where c.nome = :nome
	@Query(value = "select * from cliente c where c.nome like '%:nome%'", nativeQuery = true)
	List<Cliente> encontrarPorNome(@Param("nome") String nome);

	List<Cliente> findByNomeOrId(String nome, String id);

	/*
	 * @Query(value = "delete Cliente c where c.id =:id ")
	 * 
	 * @Modifying void deleteByEmail(String id);
	 */
	
	@Query("select c from Cliente c left join fetch c.pedidos where c.id = :id")
	Cliente findClienteFetchPedidos(@Param("id") String uuid);

	Boolean existsByEmail(String email);
}
