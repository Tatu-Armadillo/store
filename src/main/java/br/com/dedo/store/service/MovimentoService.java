package br.com.dedo.store.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dedo.store.model.Cliente;
import br.com.dedo.store.model.Movimento;
import br.com.dedo.store.model.Produto;
import br.com.dedo.store.repository.MovimentoRepository;

@Service
public class MovimentoService {

    private Movimento movimento;

    @Autowired
    private MovimentoRepository movimentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    public Movimento createMovimento(Movimento movimento) {
        BigDecimal valorTotal = valorVenda(movimento.getProduto(), movimento.getQuantidadeTotal());
        movimento.setValorTotal(valorTotal);
        movimento.setDataSaida(LocalDate.now());

        Produto produtoSelecionado = selecionarProduto(movimento.getProduto().getIdProduto());
        movimento.setProduto(produtoSelecionado);
        Boolean menosProduto = produtoService.reduzirProduto(produtoSelecionado, movimento.getQuantidadeTotal());

        if (menosProduto) {
            return new Movimento();
        }

        movimento.setCliente(clienteService.getCliente(movimento.getCliente().getIdCliente()).get());

        movimento.setDesconto(BigDecimal.ZERO);

        movimentoRepository.save(movimento);
        this.movimento = movimento;
        return this.movimento;
    }

    private BigDecimal valorVenda(Produto produto, Long quantidadeProduto) {
        BigDecimal valorProduto = produto.getVenda();
        BigDecimal quantidade = new BigDecimal(quantidadeProduto);
        return valorProduto.multiply(quantidade);
    }

    public Produto selecionarProduto(Long idProduto) {
        return produtoService.detailsProduto(idProduto).get();
    }

    public Movimento saveMovimento(Movimento movimento) {
        return movimentoRepository.save(movimento);
    }

    public List<Movimento> listMovimentacoes() {
        return movimentoRepository.findAll();
    }

    public Optional<Movimento> getMovimento(Long idMovimento) {
        return movimentoRepository.findById(idMovimento);
    }

    public List<Produto> listProdutos() {
        return produtoService.listProdutos();
    }

    public List<Cliente> listClientes() {
        return clienteService.listClientes();
    }

}
