/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.repository;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Gleb
 */
public class CustomerFacade extends AbstractFacade<Customer>{
    private final EntityManager em;

    public CustomerFacade() {
        super(Customer.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21Shop3PU");
        em = emf.createEntityManager();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
