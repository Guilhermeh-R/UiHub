package com.uihub.uihub.repositories;

import com.uihub.uihub.models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LojaRepository extends JpaRepository<Loja, Integer> {

    @Query("SELECT l FROM Loja l WHERE l.usuario.id = :usuarioId")
    Optional<Loja> findByUsuarioId(@Param("usuarioId") Integer usuarioId);
}
