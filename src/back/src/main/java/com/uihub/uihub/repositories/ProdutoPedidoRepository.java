package com.uihub.uihub.repositories;

import com.uihub.uihub.models.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Integer> {
}
