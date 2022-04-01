package br.com.dedo.store.controller.produto;


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

import br.com.dedo.store.model.Fornecedor;
import br.com.dedo.store.model.Produto;
import br.com.dedo.store.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView listarProdutos() {
        ModelAndView modelAndView = new ModelAndView("produto/ProdutoList");
        List<Produto> produtos = produtoService.listProdutos();
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @GetMapping("/cards")
    public ModelAndView cardProdutos() {
        ModelAndView modelAndView = new ModelAndView("produto/ProdutoCards");
        List<Produto> produtos = produtoService.listProdutos();
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("produto/ProdutoForm");
        modelAndView.addObject("produto", new Produto());

        List<Fornecedor> fornecedores = produtoService.getFornecedores();
        modelAndView.addObject("fornecedores", fornecedores);

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Produto produto, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "produto/ProdutoForm";
        }

        produtoService.saveProduto(produto);
        return "redirect:/produtos/";
    }
}
