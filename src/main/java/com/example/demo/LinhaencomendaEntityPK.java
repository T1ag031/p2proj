package com.example.demo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class LinhaencomendaEntityPK implements Serializable {
    @Column(name = "NUMENCOMENDA", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numencomenda;
    @Column(name = "IDTECIDO", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtecido;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinhaencomendaEntityPK that = (LinhaencomendaEntityPK) o;

        if (numencomenda != that.numencomenda) return false;
        if (idtecido != that.idtecido) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numencomenda;
        result = 31 * result + idtecido;
        return result;
    }
}
