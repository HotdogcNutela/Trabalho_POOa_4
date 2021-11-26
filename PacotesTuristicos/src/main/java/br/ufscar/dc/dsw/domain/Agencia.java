package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import br.ufscar.dc.dsw.validation.UniqueCnpj;

@SuppressWarnings("serial")
@Entity
public class Agencia extends AbstractEntity<Long> {
    
    @NotBlank
    @Column(nullable = false, length = 60)
    private String email;
    
    @NotBlank
    @Column(nullable = false, length = 60, unique = true)
    private String nome;

    @NotBlank
    @UniqueCnpj
    @Column(nullable = false, length = 60)
    private String cnpj;
    
    @NotBlank
    @Column(nullable = false, length = 60)
    private String descricao;

    /// GETTERS E SETTERS ///

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public String getCnpj(){
        return cnpj;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
}
