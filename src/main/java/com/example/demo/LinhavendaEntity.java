package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "LINHAVENDA", schema = "PROJUSER", catalog = "")
@IdClass(LinhavendaEntityPK.class)
public class LinhavendaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPECA", nullable = false, precision = 0)
    private int idpeca;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMVENDA", nullable = false, precision = 0)
    private int numvenda;
    @Basic
    @Column(name = "PRECOUNIT", nullable = false, precision = 0)
    private int precounit;
    @Basic
    @Column(name = "QTD", nullable = false, precision = 0)
    private int qtd;
    @ManyToOne
    @JoinColumn(name = "IDPECA", referencedColumnName = "IDPECA", nullable = false)
    private PecaEntity pecaByIdpeca;
    @ManyToOne
    @JoinColumn(name = "NUMVENDA", referencedColumnName = "NUMVENDA", nullable = false)
    private VendaEntity vendaByNumvenda;

    public int getIdpeca() {
        return idpeca;
    }

    public void setIdpeca(int idpeca) {
        this.idpeca = idpeca;
    }

    public int getNumvenda() {
        return numvenda;
    }

    public void setNumvenda(int numvenda) {
        this.numvenda = numvenda;
    }

    public int getPrecounit() {
        return precounit;
    }

    public void setPrecounit(int precounit) {
        this.precounit = precounit;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinhavendaEntity that = (LinhavendaEntity) o;

        if (idpeca != that.idpeca) return false;
        if (numvenda != that.numvenda) return false;
        if (precounit != that.precounit) return false;
        if (qtd != that.qtd) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpeca;
        result = 31 * result + numvenda;
        result = 31 * result + precounit;
        result = 31 * result + qtd;
        return result;
    }

    public PecaEntity getPecaByIdpeca() {
        return pecaByIdpeca;
    }

    public void setPecaByIdpeca(PecaEntity pecaByIdpeca) {
        this.pecaByIdpeca = pecaByIdpeca;
    }

    public VendaEntity getVendaByNumvenda() {
        return vendaByNumvenda;
    }

    public void setVendaByNumvenda(VendaEntity vendaByNumvenda) {
        this.vendaByNumvenda = vendaByNumvenda;
    }
}
