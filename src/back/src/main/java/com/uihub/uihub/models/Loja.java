package com.uihub.uihub.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "loja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_loja;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("banner")
    private String banner;

    @JsonProperty("cor_menu")
    @Column(length = 7)
    private String corMenu;

    @JsonProperty("cor_texto_menu")
    @Column(length = 7)
    private String corTextoMenu;

    @JsonProperty("cor_fundo")
    @Column(length = 7)
    private String corFundo;

    @JsonProperty("visitantes")
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer visitantes = 0;

    // Getters e Setters
    public Integer getIdLoja() {
        return id_loja;
    }

    public void setIdLoja(Integer id_Loja) {
        id_loja = id_Loja;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getCorMenu() {
        return corMenu;
    }

    public void setCorMenu(String corMenu) {
        this.corMenu = corMenu;
    }

    public String getCorTextoMenu() {
        return corTextoMenu;
    }

    public void setCorTextoMenu(String corTextoMenu) {
        this.corTextoMenu = corTextoMenu;
    }

    public String getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(String corFundo) {
        this.corFundo = corFundo;
    }

    public Integer getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(Integer visitantes) {
        this.visitantes = visitantes;
    }

    public Integer getUsuarioId() {
        return usuario.getIdUsuario();
    }
}
