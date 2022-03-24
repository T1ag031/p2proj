package com.example.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TECIDO", schema = "PROJUSER", catalog = "")
public class TecidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDTECIDO", nullable = false, precision = 0)
    private int idtecido;
    @Basic
    @Column(name = "DESCRICAO", nullable = false, length = 20)
    private String descricao;
    @Basic
    @Column(name = "CODFORNECEDOR", nullable = false, precision = 0)
    private int codfornecedor;
    @OneToMany(mappedBy = "tecidoByIdtecido")
    private Collection<LinhaencomendaEntity> linhaencomendasByIdtecido;
    @ManyToOne
    @JoinColumn(name = "CODFORNECEDOR", referencedColumnName = "CODFORNECEDOR", nullable = false)
    private FornecedorEntity fornecedorByCodfornecedor;
    @OneToMany(mappedBy = "tecidoByIdtecido")
    private Collection<TecpecaEntity> tecpecasByIdtecido;

    public int getIdtecido() {
        return idtecido;
    }

    public void setIdtecido(int idtecido) {
        this.idtecido = idtecido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodfornecedor() {
        return codfornecedor;
    }

    public void setCodfornecedor(int codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TecidoEntity that = (TecidoEntity) o;

        if (idtecido != that.idtecido) return false;
        if (codfornecedor != that.codfornecedor) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtecido;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + codfornecedor;
        return result;
    }

    public Collection<LinhaencomendaEntity> getLinhaencomendasByIdtecido() {
        return linhaencomendasByIdtecido;
    }

    public void setLinhaencomendasByIdtecido(Collection<LinhaencomendaEntity> linhaencomendasByIdtecido) {
        this.linhaencomendasByIdtecido = linhaencomendasByIdtecido;
    }

    public FornecedorEntity getFornecedorByCodfornecedor() {
        return fornecedorByCodfornecedor;
    }

    public void setFornecedorByCodfornecedor(FornecedorEntity fornecedorByCodfornecedor) {
        this.fornecedorByCodfornecedor = fornecedorByCodfornecedor;
    }

    public Collection<TecpecaEntity> getTecpecasByIdtecido() {
        return tecpecasByIdtecido;
    }

    public void setTecpecasByIdtecido(Collection<TecpecaEntity> tecpecasByIdtecido) {
        this.tecpecasByIdtecido = tecpecasByIdtecido;
    }
}
