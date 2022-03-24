package com.example.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CODPOSTAL", schema = "PROJUSER", catalog = "")
public class CodpostalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPOSTAL", nullable = false, precision = 0)
    private int codpostal;
    @Basic
    @Column(name = "LOCALIDADE", nullable = false, length = 40)
    private String localidade;
    @OneToMany(mappedBy = "codpostalByCodpostal")
    private Collection<FornecedorEntity> fornecedorsByCodpostal;

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodpostalEntity that = (CodpostalEntity) o;

        if (codpostal != that.codpostal) return false;
        if (localidade != null ? !localidade.equals(that.localidade) : that.localidade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codpostal;
        result = 31 * result + (localidade != null ? localidade.hashCode() : 0);
        return result;
    }

    public Collection<FornecedorEntity> getFornecedorsByCodpostal() {
        return fornecedorsByCodpostal;
    }

    public void setFornecedorsByCodpostal(Collection<FornecedorEntity> fornecedorsByCodpostal) {
        this.fornecedorsByCodpostal = fornecedorsByCodpostal;
    }
}
