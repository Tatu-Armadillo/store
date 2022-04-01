package br.com.dedo.store.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dedo.store.model.Fornecedor;
import br.com.dedo.store.model.Produto;
import br.com.dedo.store.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    private Produto produto;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorService fornecedorService;

    public List<Produto> listProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> detailsProduto(Long idProduto) {
        return produtoRepository.findById(idProduto);
    }

    public Produto saveProduto(Produto produto) {
        LocalDate data = LocalDate.now();
        produto.setEntrada(data);
        
        BigDecimal compra = produto.getCompra();
        System.out.println(compra);
        
        Long idFornecedor = produto.getFornecedor().getIdFornecedor();
        Fornecedor f = fornecedorService.getFornecedor(idFornecedor).get();
        produto.setFornecedor(f);

        this.produto = produtoRepository.save(produto);
        return this.produto;
    } 

    public Produto updateProduto(Long idProduto, Produto produto) {
        this.produto = produtoRepository.getById(idProduto);
        this.produto.setNomeProduto(produto.getNomeProduto());
        this.produto.setDescricao(produto.getDescricao());
        return this.produto;
    }

    public void deleteProduto(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedorService.listFornecedores();
    }

    public Boolean reduzirProduto(Produto produto, Long quantidade ) {
        this.produto = produtoRepository.getById(produto.getIdProduto());
        Long novaQuantidade = this.produto.getQuantidadeEstoque() - quantidade;
        if (novaQuantidade <= 0) {
            return true;
        }
        this.produto.setQuantidadeEstoque(novaQuantidade);
        return false;
    }

}
