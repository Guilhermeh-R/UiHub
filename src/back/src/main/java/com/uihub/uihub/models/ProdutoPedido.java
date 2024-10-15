package com.uihub.uihub.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "produto_pedido")
@JsonIgnoreProperties({"pedido"})
public class ProdutoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto_pedido;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    @JsonProperty("id_produto")
    private Integer idProduto;

    @JsonProperty("quantidade")
    private Integer quantidade;

    // Getters e Setters

    public Integer getIdProdutoPedido() {
        return id_produto_pedido;
    }

    public void setIdProdutoPedido(Integer idProdutoPedido) {
        this.id_produto_pedido = idProdutoPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
