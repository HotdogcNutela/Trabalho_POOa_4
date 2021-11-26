package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.IUsuarioService;

@Service
@Transactional(readOnly = false)
public class UsuarioService implements IUsuarioService {
    @Autowired
    IUsuarioDAO usuarioDao;

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id){
        return usuarioDao.findById(id.longValue());
    }
	
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos(){
        return usuarioDao.findAll();
    }
	
    public void salvar(Usuario Usuario){
        usuarioDao.save(Usuario);
    }
	
    public void excluir(Long id){
        usuarioDao.deleteById(id);
    }
}
