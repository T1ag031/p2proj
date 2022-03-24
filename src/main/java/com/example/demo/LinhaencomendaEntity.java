package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "LINHAENCOMENDA", schema = "PROJUSER", catalog = "")
@IdClass(LinhaencomendaEntityPK.class)
public class LinhaencomendaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMENCOMENDA", nullable = false, precision = 0)
    private int numencomenda;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDTECIDO", nullable = false, precision = 0)
    private int idtecido;
    @Basic
    @Column(name = "PRECOUNIT", nullable = false, precision = 0)
    private short precounit;
    @Basic
    @Column(name = "QTD", nullable = false, precision = 0)
    private int qtd;
    @ManyToOne
    @JoinColumn(name = "NUMENCOMENDA", referencedColumnName = "NUMENCOMENDA", nullable = false)
    private EncomendaEntity encomendaByNumencomenda;
    @ManyToOne
    @JoinColumn(name = "IDTECIDO", referencedColumnName = "IDTECIDO", nullable = false)
    private TecidoEntity tecidoByIdtecido;

    public int getNumencomenda() {
        return numencomenda;
    }

    public void setNumencomenda(int numencomenda) {
        this.numencomenda = numencomenda;
    }

    public int getIdtecido() {
        return idtecido;
    }

    public void setIdtecido(int idtecido) {
        this.idtecido = idtecido;
    }

    public short getPrecounit() {
        return precounit;
    }

    public void setPrecounit(short precounit) {
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

        LinhaencomendaEntity that = (LinhaencomendaEntity) o;

        if (numencomenda != that.numencomenda) return false;
        if (idtecido != that.idtecido) return false;
        if (precounit != that.precounit) return false;
        if (qtd != that.qtd) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numencomenda;
        result = 31 * result + idtecido;
        result = 31 * result + (int) precounit;
        result = 31 * result + qtd;
        return result;
    }

    public EncomendaEntity getEncomendaByNumencomenda() {
        return encomendaByNumencomenda;
    }

    public void setEncomendaByNumencomenda(EncomendaEntity encomendaByNumencomenda) {
        this.encomendaByNumencomenda = encomendaByNumencomenda;
    }

    public TecidoEntity getTecidoByIdtecido() {
        return tecidoByIdtecido;
    }

    public void setTecidoByIdtecido(TecidoEntity tecidoByIdtecido) {
        this.tecidoByIdtecido = tecidoByIdtecido;
    }
}
