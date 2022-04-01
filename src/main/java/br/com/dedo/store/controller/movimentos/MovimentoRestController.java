package br.com.dedo.store.controller.movimentos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dedo.store.model.Movimento;
import br.com.dedo.store.service.MovimentoService;

@RestController
@RequestMapping("/api/movimentos")
public class MovimentoRestController {

    @Autowired
    private MovimentoService movimentacaoService;

    @GetMapping
    public List<Movimento> viewMovimentoDto() {
        return movimentacaoService.listMovimentacoes();
    }

    @GetMapping("/{idMovimentacao}")
    public ResponseEntity<Movimento> datailsMovimento(@PathVariable Long idMovimentacao) {
        Optional<Movimento> movimento = movimentacaoService.getMovimento(idMovimentacao);
        if (movimento.isPresent()) {
            return ResponseEntity.ok(movimento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public Movimento registerMovimento(@RequestBody @Valid Movimento movimento) {
        return movimentacaoService.saveMovimento(movimento);
    }

}
