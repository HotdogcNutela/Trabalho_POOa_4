package br.ufscar.dc.dsw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IPacoteDAO;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.service.spec.IPacoteService;

@Service
@Transactional(readOnly = false)
public class PacoteService implements IPacoteService {
    @Autowired
    IPacoteDAO pacoteDao;

    @Transactional(readOnly = true)
    public Pacote buscarPorId(Long id){
        return pacoteDao.findById(id.longValue());
    }
	
    @Transactional(readOnly = true)
    public List<Pacote> buscarTodos(String campo){
        List<Pacote> pacotes = new ArrayList<>();
        for (Pacote p: pacoteDao.findAll(ordenar(campo))){
            pacotes.add(p);
        }

        return pacotes;
    }
	
    public void salvar(Pacote pacote){
        pacoteDao.save(pacote);
    }
	
    public void excluir(Long id){
        pacoteDao.deleteById(id);
    }

    private Sort ordenar(String campo){
        if (campo == null || campo.isEmpty()){
            campo = "id";
        }
        
        return Sort.by(Order.by(campo));
    }
}
