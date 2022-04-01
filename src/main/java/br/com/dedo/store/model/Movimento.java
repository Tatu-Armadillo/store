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
@Table(name = "movimentos")
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimento")
    private Long idMovimento;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "total_quantidade")
    private Long quantidadeTotal;

    @Column(name = "total_valor")
    private BigDecimal valorTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto", referencedColumnName = "id_produto")
    private Produto produto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    public Movimento() { }

    public Movimento(LocalDate dataSaida, Long quantidadeTotal, BigDecimal valorTotal,
            Produto produto, Cliente cliente) {
        this.dataSaida = dataSaida;
        this.quantidadeTotal = quantidadeTotal;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.cliente = cliente;
    }

    // #region Getters and Setters
    public Long getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Long idMovimento) {
        this.idMovimento = idMovimento;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Long quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
    // #endregion
}
