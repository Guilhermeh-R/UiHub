package com.uihub.uihub.repositories;

import com.uihub.uihub.models.Usuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Busca um usuário pelo ID usando SQL nativo
    @Query(value = "SELECT * FROM usuario WHERE id_usuario = :id", nativeQuery = true)
    Optional<Usuario> findById(@Param("id") int id);

    // Insere um novo usuário usando SQL nativo corrigido
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO usuario (nome, sobrenome, email, senha) VALUES (:nome, :sobrenome, :email, :senha)", nativeQuery = true)
    void insertUsuario(@Param("nome") String nome, @Param("sobrenome") String sobrenome, @Param("email") String email, @Param("senha") String senha);

    // Atualiza um usuário existente usando SQL nativo corrigido
    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET nome = :nome, sobrenome = :sobrenome, email = :email, senha = :senha WHERE id_usuario = :id", nativeQuery = true)
    void updateUsuario(@Param("id") int id, @Param("nome") String nome, @Param("sobrenome") String sobrenome, @Param("email") String email, @Param("senha") String senha);

    // Deleta um usuário pelo ID usando SQL nativo
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM usuario WHERE id_usuario = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    // Deleta um usuário nas tabelas 'usuario' e 'loja' pelo ID usando SQL nativo
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM loja WHERE id_usuario = :id; DELETE FROM usuario WHERE id_usuario = :id", nativeQuery = true)
    void deleteFromUsuarioAndLojaById(@Param("id") int id);
}
