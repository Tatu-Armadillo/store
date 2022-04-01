package br.com.dedo.store.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "codigo_produto")
    private String codigoProduto;

    @Column(name = "preco_compra")
    private BigDecimal compra; // valor de compra dos fornecedores

    @Column(name = "preco_venda")
    private BigDecimal venda; // valor de venda aos clientes

    private String descricao;
    private String tamanho;
    private String cor;

    @Column(name = "quantidade_estoque")
    private Long quantidadeEstoque; // quantidade presente nos estoque

    @Column(name = "data_entrada")
    private LocalDate entrada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fornecedor", referencedColumnName = "id_fornecedor")
    private Fornecedor fornecedor;

    public Produto() { }

    public Produto(String nomeProduto, String codigoProduto, BigDecimal compra, BigDecimal venda,
            String descricao, String tamanho, String cor, Long quantidadeEstoque, LocalDate entrada,
            Fornecedor fornecedor) {
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.compra = compra;
        this.venda = venda;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.cor = cor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.entrada = entrada;
        this.fornecedor = fornecedor;
    }

    // #region
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public BigDecimal getCompra() {
        return compra;
    }

    public void setCompra(BigDecimal compra) {
        this.compra = compra;
    }

    public BigDecimal getVenda() {
        return venda;
    }

    public void setVenda(BigDecimal venda) {
        this.venda = venda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Long quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    // #endregion

}
