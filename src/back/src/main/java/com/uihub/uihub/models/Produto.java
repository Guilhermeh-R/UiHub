package com.uihub.uihub.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    @ManyToOne
    @JoinColumn(name = "id_loja", referencedColumnName = "id_loja", nullable = false)
    private Loja loja;

    @Transient
    private Integer idLojaTransient;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private BigDecimal preco;

    @Column(columnDefinition = "TEXT")
    private String foto;

    private Timestamp dataCriacao;

    private Timestamp dataAtualizacao;

    private Integer estoque; // Novo campo de estoque

    // Getters and Setters
    public Integer getIdProduto() {
        return id_produto;
    }

    public void setIdProduto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Integer getIdLojaTransient() {
        return idLojaTransient;
    }

    public void setIdLojaTransient(Integer idLojaTransient) {
        this.idLojaTransient = idLojaTransient;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
