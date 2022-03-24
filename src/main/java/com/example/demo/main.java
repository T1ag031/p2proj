package com.example.demo;
import com.example.demo.BLL.ClienteBLL;

import javax.persistence.*;

public class main {
    private static final String PERSISTENCE_UNIT_NAME = "JavaApplication119PU";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    public static void main(String[] args) {
        ClienteEntity c1 = new ClienteEntity();
        c1.setCodcliente(10);
        c1.setNome("test");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();

        ClienteBLL clienteBLL = new ClienteBLL(factory);
        ClienteEntity clienteEnt = clienteBLL.read(10);
    }
}

