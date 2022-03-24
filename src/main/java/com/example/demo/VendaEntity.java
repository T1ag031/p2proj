package com.example.demo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "VENDA", schema = "PROJUSER", catalog = "")
public class VendaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMVENDA", nullable = false, precision = 0)
    private int numvenda;
    @Basic
    @Column(name = "DATA", nullable = false)
    private Date data;
    @Basic
    @Column(name = "VALORTOTAL", nullable = false, precision = 0)
    private int valortotal;
    @Basic
    @Column(name = "CODCLIENTE", nullable = false, precision = 0)
    private int codcliente;
    @OneToMany(mappedBy = "vendaByNumvenda")
    private Collection<LinhavendaEntity> linhavendasByNumvenda;
    @ManyToOne
    @JoinColumn(name = "CODCLIENTE", referencedColumnName = "CODCLIENTE", nullable = false)
    private ClienteEntity clienteByCodcliente;

    public int getNumvenda() {
        return numvenda;
    }

    public void setNumvenda(int numvenda) {
        this.numvenda = numvenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendaEntity that = (VendaEntity) o;

        if (numvenda != that.numvenda) return false;
        if (valortotal != that.valortotal) return false;
        if (codcliente != that.codcliente) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numvenda;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + valortotal;
        result = 31 * result + codcliente;
        return result;
    }

    public Collection<LinhavendaEntity> getLinhavendasByNumvenda() {
        return linhavendasByNumvenda;
    }

    public void setLinhavendasByNumvenda(Collection<LinhavendaEntity> linhavendasByNumvenda) {
        this.linhavendasByNumvenda = linhavendasByNumvenda;
    }

    public ClienteEntity getClienteByCodcliente() {
        return clienteByCodcliente;
    }

    public void setClienteByCodcliente(ClienteEntity clienteByCodcliente) {
        this.clienteByCodcliente = clienteByCodcliente;
    }
}
