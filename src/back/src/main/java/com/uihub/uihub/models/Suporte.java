
package com.uihub.uihub.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "suporte")
public class Suporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Suporte;

    @ManyToOne
    @JoinColumn(name = "Id_Usuario", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "TEXT")
    private String Solicitacao_Suporte;

    @Column(columnDefinition = "TEXT")
    private String Resposta_Suporte;

    @Column(columnDefinition = "TEXT")
    private String Nova_Requisicao_Usuario;

    @Column(nullable = false)
    private Timestamp Data_Hora_Solicitacao;

    @Column(nullable = false)
    private Timestamp Data_Hora_Atualizacao;

    public Suporte() {
    }

    public Suporte(Integer Id_Suporte, Usuario usuario, String Solicitacao_Suporte, String Resposta_Suporte,
            String Nova_Requisicao_Usuario, Timestamp Data_Hora_Solicitacao, Timestamp Data_Hora_Atualizacao) {
        this.Id_Suporte = Id_Suporte;
        this.usuario = usuario;
        this.Solicitacao_Suporte = Solicitacao_Suporte;
        this.Resposta_Suporte = Resposta_Suporte;
        this.Nova_Requisicao_Usuario = Nova_Requisicao_Usuario;
        this.Data_Hora_Solicitacao = Data_Hora_Solicitacao;
        this.Data_Hora_Atualizacao = Data_Hora_Atualizacao;
    }

    public Integer getId_Suporte() {
        return this.Id_Suporte;
    }

    public void setId_Suporte(Integer Id_Suporte) {
        this.Id_Suporte = Id_Suporte;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSolicitacao_Suporte() {
        return this.Solicitacao_Suporte;
    }

    public void setSolicitacao_Suporte(String Solicitacao_Suporte) {
        this.Solicitacao_Suporte = Solicitacao_Suporte;
    }

    public String getResposta_Suporte() {
        return this.Resposta_Suporte;
    }

    public void setResposta_Suporte(String Resposta_Suporte) {
        this.Resposta_Suporte = Resposta_Suporte;
    }

    public String getNova_Requisicao_Usuario() {
        return this.Nova_Requisicao_Usuario;
    }

    public void setNova_Requisicao_Usuario(String Nova_Requisicao_Usuario) {
        this.Nova_Requisicao_Usuario = Nova_Requisicao_Usuario;
    }

    public Timestamp getData_Hora_Solicitacao() {
        return this.Data_Hora_Solicitacao;
    }

    public void setData_Hora_Solicitacao(Timestamp Data_Hora_Solicitacao) {
        this.Data_Hora_Solicitacao = Data_Hora_Solicitacao;
    }

    public Timestamp getData_Hora_Atualizacao() {
        return this.Data_Hora_Atualizacao;
    }

    public void setData_Hora_Atualizacao(Timestamp Data_Hora_Atualizacao) {
        this.Data_Hora_Atualizacao = Data_Hora_Atualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Suporte))
            return false;
        Suporte suporte = (Suporte) o;
        return Objects.equals(Id_Suporte, suporte.Id_Suporte) &&
                Objects.equals(usuario, suporte.usuario) &&
                Objects.equals(Solicitacao_Suporte, suporte.Solicitacao_Suporte) &&
                Objects.equals(Resposta_Suporte, suporte.Resposta_Suporte) &&
                Objects.equals(Nova_Requisicao_Usuario, suporte.Nova_Requisicao_Usuario) &&
                Objects.equals(Data_Hora_Solicitacao, suporte.Data_Hora_Solicitacao) &&
                Objects.equals(Data_Hora_Atualizacao, suporte.Data_Hora_Atualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Suporte, usuario, Solicitacao_Suporte, Resposta_Suporte, Nova_Requisicao_Usuario,
                Data_Hora_Solicitacao, Data_Hora_Atualizacao);
    }

}
