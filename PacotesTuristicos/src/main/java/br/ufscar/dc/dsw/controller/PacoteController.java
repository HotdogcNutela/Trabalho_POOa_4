package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.service.spec.IAgenciaService;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.IPacoteService;

@Controller
@RequestMapping("/pacotes")
public class PacoteController {
    @Autowired
    private IPacoteService pacoteService;
    @Autowired
    private IClienteService clienteService;
    @Autowired
    private IAgenciaService agenciaService;


    @GetMapping("/cadastrar")
    public String cadastrar(Pacote pacote){
        return "pacote/cadastro";
    }

    @GetMapping("/listar")
    public String listar(@RequestParam(required = false, name = "order", defaultValue = "id") String campo, ModelMap model){
        model.addAttribute("pacotes", pacoteService.buscarTodos(campo));
        return "pacote/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Pacote pacote, BindingResult result, RedirectAttributes attr){
        pacoteService.salvar(pacote);
        attr.addFlashAttribute("success", "pacote.create.success");

        return "redirect:/pacotes/listar";
    }
    
    @PostMapping("/editar")
    public String editar(@Valid Pacote pacote, BindingResult result, RedirectAttributes attr){
        pacoteService.salvar(pacote);
        attr.addFlashAttribute("success", "pacote.edit.success");

        return "redirect:/pacotes/listar";
    }

    @GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pacote", pacoteService.buscarPorId(id));
		return "pacote/cadastro";
	}

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        pacoteService.excluir(id);
        attr.addFlashAttribute("success", "pacote.delete.success");
        return "redirect:/pacotes/listar";
    }

    @ModelAttribute("clientes")
    public List<Cliente> listaClientes(){
        return clienteService.buscarTodos();
    }

    @ModelAttribute("agencias")
    public List<Agencia> listaAgencias(){
        return agenciaService.buscarTodos();
    }
}
