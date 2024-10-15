package com.uihub.uihub.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;

    @Column(name = "nome")
    @JsonProperty("nome")
    @NotBlank(message = "O nome do usuário não pode ser vazio.")
    private String nome;

    @Column(name = "sobrenome")
    @JsonProperty("sobrenome")
    @NotBlank(message = "O sobrenome do usuário não pode ser vazio.")
    private String sobrenome;

    @Column(name = "email")
    @JsonProperty("email")
    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "O email deve ser um endereço de email válido.")
    private String email;

    @Column(name = "senha")
    @JsonProperty("senha")
    @NotBlank(message = "A senha não pode ser vazia.")
    private String senha;
    
    @Column(name = "data_de_registro", updatable = false)
    @JsonProperty("data_de_registro")
    private LocalDateTime dataDeRegistro;

    public Usuario() {}

    public Usuario(Integer id_usuario, String nome, String sobrenome, String email, String senha, LocalDateTime dataDeRegistro) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.dataDeRegistro = dataDeRegistro;
    }

    // Getters e setters
    public Integer getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }
}
