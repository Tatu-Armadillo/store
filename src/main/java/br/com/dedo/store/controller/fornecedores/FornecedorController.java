package br.com.dedo.store.controller.fornecedores;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dedo.store.model.Fornecedor;
import br.com.dedo.store.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("fornecedor/FornecedorList");
        List<Fornecedor> fornecedores = fornecedorService.listFornecedores();
        modelAndView.addObject("fornecedores", fornecedores);
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("fornecedor/FornecedorForm");
        modelAndView.addObject("fornecedor", new Fornecedor());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Fornecedor fornecedor, BindingResult result) throws IOException {
        if (result.hasErrors())
            return "fornecedor/FornecedorForm";
        fornecedorService.saveFornecedor(fornecedor);
        return "redirect:/fornecedores/";
    }

    @GetMapping("/{idFornecedor}/excluir")
    public String excluir(@PathVariable Long idFornecedor) {
        fornecedorService.deleteFornecedor(idFornecedor);
        return "redirect:/fornecedores/";
    }

}
