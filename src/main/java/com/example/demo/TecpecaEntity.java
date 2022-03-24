package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "TECPECA", schema = "PROJUSER", catalog = "")
public class TecpecaEntity {
    @Basic
    @Column(name = "IDTECIDO", nullable = false, precision = 0)
    private int idtecido;
    @Basic
    @Column(name = "IDPECA", nullable = false, precision = 0)
    private int idpeca;
    @ManyToOne
    @JoinColumn(name = "IDTECIDO", referencedColumnName = "IDTECIDO", nullable = false)
    private TecidoEntity tecidoByIdtecido;
    @ManyToOne
    @JoinColumn(name = "IDPECA", referencedColumnName = "IDPECA", nullable = false)
    private PecaEntity pecaByIdpeca;

    public int getIdtecido() {
        return idtecido;
    }

    public void setIdtecido(int idtecido) {
        this.idtecido = idtecido;
    }

    public int getIdpeca() {
        return idpeca;
    }

    public void setIdpeca(int idpeca) {
        this.idpeca = idpeca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TecpecaEntity that = (TecpecaEntity) o;

        if (idtecido != that.idtecido) return false;
        if (idpeca != that.idpeca) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtecido;
        result = 31 * result + idpeca;
        return result;
    }

    public TecidoEntity getTecidoByIdtecido() {
        return tecidoByIdtecido;
    }

    public void setTecidoByIdtecido(TecidoEntity tecidoByIdtecido) {
        this.tecidoByIdtecido = tecidoByIdtecido;
    }

    public PecaEntity getPecaByIdpeca() {
        return pecaByIdpeca;
    }

    public void setPecaByIdpeca(PecaEntity pecaByIdpeca) {
        this.pecaByIdpeca = pecaByIdpeca;
    }
}
