package com.example.demo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "ENCOMENDA", schema = "PROJUSER", catalog = "")
public class EncomendaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMENCOMENDA", nullable = false, precision = 0)
    private int numencomenda;
    @Basic
    @Column(name = "DATA", nullable = false)
    private Date data;
    @Basic
    @Column(name = "VALORTOTAL", nullable = false, precision = 0)
    private short valortotal;
    @Basic
    @Column(name = "CODFORNECEDOR", nullable = false, precision = 0)
    private int codfornecedor;
    @ManyToOne
    @JoinColumn(name = "CODFORNECEDOR", referencedColumnName = "CODFORNECEDOR", nullable = false)
    private FornecedorEntity fornecedorByCodfornecedor;
    @OneToMany(mappedBy = "encomendaByNumencomenda")
    private Collection<LinhaencomendaEntity> linhaencomendasByNumencomenda;

    public int getNumencomenda() {
        return numencomenda;
    }

    public void setNumencomenda(int numencomenda) {
        this.numencomenda = numencomenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public short getValortotal() {
        return valortotal;
    }

    public void setValortotal(short valortotal) {
        this.valortotal = valortotal;
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

        EncomendaEntity that = (EncomendaEntity) o;

        if (numencomenda != that.numencomenda) return false;
        if (valortotal != that.valortotal) return false;
        if (codfornecedor != that.codfornecedor) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numencomenda;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (int) valortotal;
        result = 31 * result + codfornecedor;
        return result;
    }

    public FornecedorEntity getFornecedorByCodfornecedor() {
        return fornecedorByCodfornecedor;
    }

    public void setFornecedorByCodfornecedor(FornecedorEntity fornecedorByCodfornecedor) {
        this.fornecedorByCodfornecedor = fornecedorByCodfornecedor;
    }

    public Collection<LinhaencomendaEntity> getLinhaencomendasByNumencomenda() {
        return linhaencomendasByNumencomenda;
    }

    public void setLinhaencomendasByNumencomenda(Collection<LinhaencomendaEntity> linhaencomendasByNumencomenda) {
        this.linhaencomendasByNumencomenda = linhaencomendasByNumencomenda;
    }
}
