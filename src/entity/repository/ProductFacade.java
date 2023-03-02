/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.repository;

/**
 *
 * @author Gleb
 */
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class ProductFacade extends AbstractFacade<Product>{
    private final EntityManager em;

    public ProductFacade() {
        super(Product.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21Shop3PU");
        em = emf.createEntityManager();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
