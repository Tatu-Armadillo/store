package br.com.dedo.store.controller.cliente;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dedo.store.model.Cliente;
import br.com.dedo.store.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView listClientes() {
        ModelAndView modelAndView = new ModelAndView("cliente/ClienteList");
        modelAndView.addObject("clientes", clienteService.listClientes());
        return modelAndView;
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("cliente/ClienteForm");
        modelAndView.addObject("cliente", new Cliente());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Cliente cliente, BindingResult result) throws IOException{
        if (result.hasErrors()) {
            return "cliente/ClienteForm";
        }
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }
    
}
