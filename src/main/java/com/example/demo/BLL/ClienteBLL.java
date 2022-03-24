package com.example.demo.BLL;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.example.demo.ClienteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author miguel
 */
public class ClienteBLL {
    private static final String PERSISTENCE_UNIT_NAME = "JavaApplication119PU";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public ClienteBLL(EntityManagerFactory factory) {

    }

    public static void create(ClienteEntity cli){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
    }

    public static ClienteEntity read(int idCliente){
        ClienteEntity cli = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("ClienteEntity.findByIdcliente");
        q1.setParameter("idcliente", idCliente);
        Object obj = q1.getSingleResult();

        if(obj != null){
            cli = ((ClienteEntity)obj);
        }
        else
            return null;


        return cli;
    }

    public static List<ClienteEntity> readAll(){
        List<ClienteEntity> listaCli = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("ClienteEntity.findAll");
        List<Object> result = q1.getResultList();

        for(Object cli : result){
            listaCli.add((ClienteEntity)cli);
        }

        return listaCli;
    }

    public static List<ClienteEntity> readAll(String nome){
        List<ClienteEntity> listaCli = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("ClienteEntity.findAllByNome");
        q1.setParameter("nome", "%"+nome+"%");
        List<Object> result = q1.getResultList();

        for(Object cli : result){
            listaCli.add((ClienteEntity)cli);
        }

        return listaCli;
    }

    public static void update(ClienteEntity cli){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(cli);
        em.getTransaction().commit();
    }

    public static void delete(ClienteEntity cli){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(cli);
        em.getTransaction().commit();
    }
}