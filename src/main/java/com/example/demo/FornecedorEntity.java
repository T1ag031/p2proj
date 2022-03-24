package com.example.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "FORNECEDOR", schema = "PROJUSER", catalog = "")
public class FornecedorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODFORNECEDOR", nullable = false, precision = 0)
    private int codfornecedor;
    @Basic
    @Column(name = "NOME", nullable = false, length = 20)
    private String nome;
    @Basic
    @Column(name = "RUA", nullable = false, length = 20)
    private String rua;
    @Basic
    @Column(name = "NPORTA", nullable = false, precision = 0)
    private short nporta;
    @Basic
    @Column(name = "NIF", nullable = false, precision = 0)
    private int nif;
    @Basic
    @Column(name = "CODPOSTAL", nullable = false, precision = 0)
    private int codpostal;
    @OneToMany(mappedBy = "fornecedorByCodfornecedor")
    private Collection<EncomendaEntity> encomendasByCodfornecedor;
    @ManyToOne
    @JoinColumn(name = "CODPOSTAL", referencedColumnName = "CODPOSTAL", nullable = false)
    private CodpostalEntity codpostalByCodpostal;
    @OneToMany(mappedBy = "fornecedorByCodfornecedor")
    private Collection<TecidoEntity> tecidosByCodfornecedor;

    public int getCodfornecedor() {
        return codfornecedor;
    }

    public void setCodfornecedor(int codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public short getNporta() {
        return nporta;
    }

    public void setNporta(short nporta) {
        this.nporta = nporta;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FornecedorEntity that = (FornecedorEntity) o;

        if (codfornecedor != that.codfornecedor) return false;
        if (nporta != that.nporta) return false;
        if (nif != that.nif) return false;
        if (codpostal != that.codpostal) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (rua != null ? !rua.equals(that.rua) : that.rua != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codfornecedor;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (int) nporta;
        result = 31 * result + nif;
        result = 31 * result + codpostal;
        return result;
    }

    public Collection<EncomendaEntity> getEncomendasByCodfornecedor() {
        return encomendasByCodfornecedor;
    }

    public void setEncomendasByCodfornecedor(Collection<EncomendaEntity> encomendasByCodfornecedor) {
        this.encomendasByCodfornecedor = encomendasByCodfornecedor;
    }

    public CodpostalEntity getCodpostalByCodpostal() {
        return codpostalByCodpostal;
    }

    public void setCodpostalByCodpostal(CodpostalEntity codpostalByCodpostal) {
        this.codpostalByCodpostal = codpostalByCodpostal;
    }

    public Collection<TecidoEntity> getTecidosByCodfornecedor() {
        return tecidosByCodfornecedor;
    }

    public void setTecidosByCodfornecedor(Collection<TecidoEntity> tecidosByCodfornecedor) {
        this.tecidosByCodfornecedor = tecidosByCodfornecedor;
    }
}
