package com.uihub.uihub.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_loja", referencedColumnName = "id_loja")
    private Loja loja;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("complemento")
    private String complemento;

    @JsonProperty("metodopagamento")
    private String metodoPagamento;

    @JsonProperty("totalpedido")
    @Column(name = "totalpedido")
    private Double totalPedido;

    @JsonProperty("email")
    private String email;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProdutoPedido> produtosPedido;

    // Construtor padrão
    public Pedido() {
    }

    // Getters e Setters
    public Integer getIdPedido() {
        return id_pedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.id_pedido = idPedido;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ProdutoPedido> getProdutosPedido() {
        return produtosPedido;
    }

    public void setProdutosPedido(Set<ProdutoPedido> produtosPedido) {
        this.produtosPedido = produtosPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + id_pedido +
                ", loja=" + (loja != null ? loja.getIdLoja() : null) +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", complemento='" + complemento + '\'' +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", totalPedido=" + totalPedido +
                ", email='" + email + '\'' +
                ", produtosPedido=" + produtosPedido +
                '}';
    }
}
