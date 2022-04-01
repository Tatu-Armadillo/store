package br.com.dedo.store.controller.movimentos;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dedo.store.model.Movimento;
import br.com.dedo.store.service.MovimentoService;

@Controller
@RequestMapping("/movimentos")
public class MovimentoController {
    
    @Autowired
    private MovimentoService movimentoService;

    @GetMapping
    public ModelAndView iniciarMovimento() {
        ModelAndView modelAndView = new ModelAndView("movimentos/MovimentoForm");
        modelAndView.addObject("produtos", movimentoService.listProdutos());
        modelAndView.addObject("clientes", movimentoService.listClientes());
        modelAndView.addObject("movimento", new Movimento());
        return modelAndView;
    }

    @GetMapping("/lista")
    public ModelAndView listMovimentos() {
        ModelAndView modelAndView = new ModelAndView("movimentos/MovimentoList");
        modelAndView.addObject("movimentos",movimentoService.listMovimentacoes());
        return modelAndView;
    }
    
    @PostMapping
    public String finalizarMovimento(@Valid Movimento movimento, BindingResult result) throws IOException {
       
        if (result.hasErrors()) {
           
            return "/movimentos/";
        }

        movimentoService.createMovimento(movimento);        
        return "redirect:/movimentos/";
    }
}
