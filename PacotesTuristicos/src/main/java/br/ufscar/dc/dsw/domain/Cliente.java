package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Cliente extends AbstractEntity<Long> {
    
    @NotBlank(message = "{NotBlank.cliente.email}")
    @Column(nullable = false, length = 60)
    private String email;
    
    @NotBlank(message = "{NotBlank.cliente.nome}")
    @Column(nullable = false, length = 60, unique = true)
    private String nome;

    @NotBlank(message = "{NotBlank.cliente.senha}")
    @Column(nullable = false, length = 60)
    private String senha;
    
    @NotBlank(message = "{NotBlank.cliente.papel}")
    @Column(nullable = false, length = 60)
    private String papel;

    @Column(nullable = false)
    private boolean enabled;

    @NotBlank(message = "{NotBlank.cliente.cpf}")
    @Column(nullable = false, length = 15)
    private String cpf;
    
    @NotBlank(message = "{NotBlank.cliente.telefone}")
    @Column(nullable = false, length = 15)    
    private String telefone;
    
    @NotBlank(message = "{NotBlank.cliente.sexo}")
    @Column(nullable = false, length = 60)
    private String sexo;
    
    @NotBlank(message = "{NotBlank.cliente.dataNasc}")
    @Column(nullable = false, length = 15)
    private String dataNasc;

    /// GETTERS E SETTERS ///

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return cpf;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getTelefone(){
        return telefone;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public String getSexo(){
        return sexo;
    }

    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }
    public String getDataNasc(){
        return dataNasc;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setPapel(String papel){
        this.papel = papel;
    }
    public String getPapel(){
        return papel;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
    public boolean isEnabled(){
        return enabled;
    }
}
