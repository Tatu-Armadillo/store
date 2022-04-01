package br.com.dedo.store.model;

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
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Long idFornecedor;

    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;

    private String cnpj;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    public Fornecedor() { }

    public Fornecedor(String nomeFornecedor, Endereco endereco) {
        this.nomeFornecedor = nomeFornecedor;
        this.endereco = endereco;
    }
    
    public Fornecedor(String nomeFornecedor, String cnpj) {
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
    }

    // #region Getters e Setters

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // #endregion

}
