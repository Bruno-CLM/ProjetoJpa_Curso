package io.github.brunoclm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunoclm.domain.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String>{

}
