package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
public class Pacote extends AbstractEntity<Long> {
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "agencia_id")
    private Agencia agencia;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String destino;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String dataPartida;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String duracao;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String valor;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String imagens; /// conjunto de ate 10 imagens
    
    @NotBlank
    @Column(nullable = false, length = 60)
    private String descricao; /// documento pdf

    /// GETTERS E SETTERS ///

    public void setAgencia(Agencia agencia){
        this.agencia = agencia;
    }
    public Agencia getAgencia(){
        return agencia;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }
    public String getDestino(){
        return destino;
    }

    public void setDataPartida(String dataPartida){
        this.dataPartida = dataPartida;
    }
    public String getDataPartida(){
        return dataPartida;
    }

    public void setDuracao(String duracao){
        this.duracao = duracao;
    }
    public String getDuracao(){
        return duracao;
    }

    public void setValor(String valor){
        this.valor = valor;
    }
    public String getValor(){
        return valor;
    }

    public void setImagens(String imagens){
        this.imagens = imagens;
    }
    public String getImagens(){
        return imagens;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}