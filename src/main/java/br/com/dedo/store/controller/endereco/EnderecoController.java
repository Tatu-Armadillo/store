package br.com.dedo.store.controller.endereco;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dedo.store.model.Endereco;
import br.com.dedo.store.service.EnderecoService;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("endereco/EnderecoList");
        List<Endereco> enderecos = enderecoService.listEnderecos();
        modelAndView.addObject("enderecos", enderecos);
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("endereco/EnderecoForm");
        modelAndView.addObject("endereco", new Endereco());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Endereco endereco, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "endereco/EnderecoForm";
        }
        enderecoService.saveEndereco(endereco);
        return "redirect:/enderecos/cadastrar/";
    }

}
