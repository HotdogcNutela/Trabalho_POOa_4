package br.ufscar.dc.dsw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Cliente cliente = clienteDAO.getClienteByNome(nome);

        if (cliente == null){
            throw new UsernameNotFoundException("Could not find user");
        }

        return new ClienteDetails(cliente);
    }
}
