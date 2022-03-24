package com.example.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PECA", schema = "PROJUSER", catalog = "")
public class PecaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPECA", nullable = false, precision = 0)
    private int idpeca;
    @Basic
    @Column(name = "NOME", nullable = false, length = 20)
    private String nome;
    @Basic
    @Column(name = "QTD", nullable = false, precision = 0)
    private int qtd;
    @Basic
    @Column(name = "PRECOUNID", nullable = false, length = 20)
    private String precounid;
    @OneToMany(mappedBy = "pecaByIdpeca")
    private Collection<LinhavendaEntity> linhavendasByIdpeca;
    @OneToMany(mappedBy = "pecaByIdpeca")
    private Collection<TecpecaEntity> tecpecasByIdpeca;

    public int getIdpeca() {
        return idpeca;
    }

    public void setIdpeca(int idpeca) {
        this.idpeca = idpeca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getPrecounid() {
        return precounid;
    }

    public void setPrecounid(String precounid) {
        this.precounid = precounid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PecaEntity that = (PecaEntity) o;

        if (idpeca != that.idpeca) return false;
        if (qtd != that.qtd) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (precounid != null ? !precounid.equals(that.precounid) : that.precounid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpeca;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + qtd;
        result = 31 * result + (precounid != null ? precounid.hashCode() : 0);
        return result;
    }

    public Collection<LinhavendaEntity> getLinhavendasByIdpeca() {
        return linhavendasByIdpeca;
    }

    public void setLinhavendasByIdpeca(Collection<LinhavendaEntity> linhavendasByIdpeca) {
        this.linhavendasByIdpeca = linhavendasByIdpeca;
    }

    public Collection<TecpecaEntity> getTecpecasByIdpeca() {
        return tecpecasByIdpeca;
    }

    public void setTecpecasByIdpeca(Collection<TecpecaEntity> tecpecasByIdpeca) {
        this.tecpecasByIdpeca = tecpecasByIdpeca;
    }
}
