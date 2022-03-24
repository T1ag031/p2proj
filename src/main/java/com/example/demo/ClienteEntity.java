package com.example.demo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "CLIENTE", schema = "PROJUSER", catalog = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM ClienteEntity c"),
        @NamedQuery(name = "Cliente.findAllByNome", query = "SELECT c FROM ClienteEntity c WHERE c.nome LIKE :nome"),
        @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM ClienteEntity c WHERE c.codcliente = :codCliente"),
        @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM ClienteEntity c WHERE c.nome = :nome"),
        @NamedQuery(name = "Cliente.findByMorada", query = "SELECT c FROM ClienteEntity c WHERE c.cidade = :cidade"),
        @NamedQuery(name = "Cliente.findByCpostal", query = "SELECT c FROM ClienteEntity c WHERE c.nif = :nif")})
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODCLIENTE", nullable = false, precision = 0)
    private int codcliente;
    @Basic
    @Column(name = "NOME", nullable = false, length = 30)
    private String nome;
    @Basic
    @Column(name = "NIF", nullable = false, precision = 0)
    private long nif;
    @Basic
    @Column(name = "CIDADE", nullable = false, length = 40)
    private String cidade;
    @Basic
    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email;
    @OneToMany(mappedBy = "clienteByCodcliente")
    private Collection<VendaEntity> vendasByCodcliente;

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (codcliente != that.codcliente) return false;
        if (nif != that.nif) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (cidade != null ? !cidade.equals(that.cidade) : that.cidade != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codcliente;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (int) (nif ^ (nif >>> 32));
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<VendaEntity> getVendasByCodcliente() {
        return vendasByCodcliente;
    }

    public void setVendasByCodcliente(Collection<VendaEntity> vendasByCodcliente) {
        this.vendasByCodcliente = vendasByCodcliente;
    }
}
