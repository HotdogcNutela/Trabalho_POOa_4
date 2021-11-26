package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Compra;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.security.ClienteDetails;
import br.ufscar.dc.dsw.service.spec.ICompraService;
import br.ufscar.dc.dsw.service.spec.IPacoteService;

@Controller
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private ICompraService compraService;
    @Autowired
    private IPacoteService pacoteService;

    private Cliente getCliente(){
        ClienteDetails clienteDetails = (ClienteDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return clienteDetails.getCliente();
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Compra compra){
        compra.setCliente(this.getCliente());
        compra.setDataCompra("30/11/2021");
        return "compra/cadastro";
    }

    @GetMapping("/listar")
    public String listar(@RequestParam(required = false, name = "order", defaultValue = "id") String campo, ModelMap model){
        model.addAttribute("compras", compraService.buscarTodosPorCliente(campo, this.getCliente()));
        return "compra/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Compra compra, BindingResult result, RedirectAttributes attr){
        compra.setCliente(this.getCliente());
        compra.setValor(compra.getPacote().getValor());
        compraService.salvar(compra);
        attr.addFlashAttribute("success", "compra.create.success");
        return "redirect:/compras/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        compraService.excluir(id);
        attr.addFlashAttribute("success", "compra.delete.success");
        return "redirect:/compras/listar";
    }

    @ModelAttribute("pacotes")
    public List<Pacote> listaPacotes(){
        return pacoteService.buscarTodos(null);
    }
}
