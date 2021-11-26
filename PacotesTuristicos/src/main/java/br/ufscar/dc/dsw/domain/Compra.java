package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
public class Compra extends AbstractEntity<Long>{
    @NotNull
    @Column(nullable = false, length = 60)
    private String dataCompra;

    @NotNull
    @Column(nullable = false, length = 60)
    private String valor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pacote_id")
    private Pacote pacote;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    /// GETTERS E SETTERS ///

    public void setDataCompra(String dataCompra){
        this.dataCompra = dataCompra;
    }
    public String getDataCompra(){
        return dataCompra;
    }

    public void setValor(String valor){
        this.valor = valor;
    }
    public String getValor(){
        return valor;
    }

    public void setPacote(Pacote pacote){
        this.pacote = pacote;
    }
    public Pacote getPacote(){
        return pacote;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public Cliente getCliente(){
        return cliente;
    }
}
