package br.ufscar.dc.dsw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ICompraDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Compra;
import br.ufscar.dc.dsw.service.spec.ICompraService;

@Service
@Transactional(readOnly = false)
public class CompraService implements ICompraService{
    @Autowired
    ICompraDAO compraDao;

    @Transactional(readOnly = true)
    public Compra buscarPorId(Long id) {
        return compraDao.findById(id.longValue());
    }

    @Transactional(readOnly = true)
    public List<Compra> buscarTodosPorCliente(String campo, Cliente cliente) {
        List<Compra> compras = new ArrayList<>();
        for (Compra c: compraDao.findAllByCliente(ordenar(campo), cliente)){
            compras.add(c);
        }

        return compras;
    }

    public Compra salvar(Compra compra) {
        return compraDao.save(compra);
    }

    public void excluir(Long id){
        compraDao.deleteById(id);
    }

    private Sort ordenar(String campo){
        if (campo == null || campo.isEmpty()){
            campo = "id";
        }
        
        return Sort.by(Order.by(campo));
    }
}
