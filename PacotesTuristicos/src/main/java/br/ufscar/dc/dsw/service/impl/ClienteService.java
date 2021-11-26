package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.service.spec.IClienteService;

@Service
@Transactional(readOnly = false)
public class ClienteService implements IClienteService {
    @Autowired
    IClienteDAO clienteDao;

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id){
        return clienteDao.findById(id.longValue());
    }
	
    @Transactional(readOnly = true)
    public List<Cliente> buscarTodos(){
        return clienteDao.findAll();
    }
	
    public void salvar(Cliente cliente){
        clienteDao.save(cliente);
    }
	
    public void excluir(Long id){
        clienteDao.deleteById(id);
    }
}
