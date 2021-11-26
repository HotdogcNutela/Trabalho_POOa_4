package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Compra;

@SuppressWarnings("unchecked")
public interface ICompraDAO extends CrudRepository<Compra, Long>{
    Compra findById(long id);
    List<Compra> findAllByCliente(Sort sort, Cliente cliente);
    Compra save(Compra compra);
    void deleteById(Long id);
}
