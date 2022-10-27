package io.github.brunoclm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.brunoclm.domain.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
	
	@Query("select p from Pedido p where p.id = :id")
	Pedido pedidoPeloId(@Param("id")String id);

}
