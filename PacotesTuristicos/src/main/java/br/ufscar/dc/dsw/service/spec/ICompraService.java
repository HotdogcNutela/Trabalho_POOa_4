package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Compra;

public interface ICompraService {
    Compra buscarPorId(Long id);
    List<Compra> buscarTodosPorCliente(String campo, Cliente cliente);
    Compra salvar(Compra compra);
    void excluir(Long id);
}
