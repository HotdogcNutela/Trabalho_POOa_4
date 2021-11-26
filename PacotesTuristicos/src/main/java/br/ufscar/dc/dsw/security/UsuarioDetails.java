package br.ufscar.dc.dsw.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.ufscar.dc.dsw.domain.Usuario;

@SuppressWarnings("serial")
public class UsuarioDetails implements UserDetails {

    private Usuario Usuario;


    public UsuarioDetails(Usuario Usuario){
        this.Usuario = Usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(Usuario.getPapel());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return Usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return Usuario.getNome();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public Usuario getUsuario(){
        return Usuario;
    }
}
