package com.uihub.uihub.repositories;

import com.uihub.uihub.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.loja.id_loja = :idLoja")
    List<Pedido> findByLojaId(@Param("idLoja") Integer idLoja);
}
