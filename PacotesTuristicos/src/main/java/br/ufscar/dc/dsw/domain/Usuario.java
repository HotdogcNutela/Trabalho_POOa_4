package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
public class Usuario extends AbstractEntity<Long>{
    
    @NotBlank
    @Column(nullable = false, length = 60)
    private String email;
    
    @NotBlank
    @Column(nullable = false, length = 60, unique = true)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String senha;
    
    @NotBlank
    @Column(nullable = false, length = 60)
    private String papel;

    @Column(nullable = false)
    private boolean enabled;

    /// GETTERS E SETTERS ///

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
