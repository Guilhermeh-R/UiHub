package com.uihub.uihub.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Avaliacao;

    @ManyToOne
    @JoinColumn(name = "Id_Produto", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private Integer Nota;

    @Column(columnDefinition = "TEXT")
    private String Comentario;

    @Column(nullable = false)
    private Timestamp Data_Hora_Avaliacao;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    public Avaliacao() {
    }

    public Avaliacao(Integer Id_Avaliacao, Produto produto, Integer Nota,
                     String Comentario, Timestamp Data_Hora_Avaliacao, String nome, String email) {
        this.Id_Avaliacao = Id_Avaliacao;
        this.produto = produto;
        this.Nota = Nota;
        this.Comentario = Comentario;
        this.Data_Hora_Avaliacao = Data_Hora_Avaliacao;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId_Avaliacao() {
        return this.Id_Avaliacao;
    }

    public void setId_Avaliacao(Integer Id_Avaliacao) {
        this.Id_Avaliacao = Id_Avaliacao;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getNota() {
        return this.Nota;
    }

    public void setNota(Integer Nota) {
        this.Nota = Nota;
    }

    public String getComentario() {
        return this.Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public Timestamp getData_Hora_Avaliacao() {
        return this.Data_Hora_Avaliacao;
    }

    public void setData_Hora_Avaliacao(Timestamp Data_Hora_Avaliacao) {
        this.Data_Hora_Avaliacao = Data_Hora_Avaliacao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Avaliacao))
            return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(Id_Avaliacao, avaliacao.Id_Avaliacao) &&
                Objects.equals(produto, avaliacao.produto) &&
                Objects.equals(Nota, avaliacao.Nota) &&
                Objects.equals(Comentario, avaliacao.Comentario) &&
                Objects.equals(Data_Hora_Avaliacao, avaliacao.Data_Hora_Avaliacao) &&
                Objects.equals(nome, avaliacao.nome) &&
                Objects.equals(email, avaliacao.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Avaliacao, produto, Nota, Comentario, Data_Hora_Avaliacao, nome, email);
    }
}
