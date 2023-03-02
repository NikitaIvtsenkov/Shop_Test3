/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers.basemanager;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import interfaces.DataPersistenceManage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Gleb
 */
public class DataBaseManager implements DataPersistenceManage{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21Shop3PU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    @Override
    public void saveProduct(List<Product> products){
        tx.begin();
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                if(product.getId() == null){
                    em.persist(product);
                }else{
                    em.merge(product);
                }

            }
        tx.commit();
    }
    @Override
    public List<Product> loadProduct(){
        try {
            return em.createQuery("SELECT p FROM Product p")
                    .getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, "Неудалось загрузить книги", ex);
            return new ArrayList<>();
        }
    }
    @Override
    public void saveCustomer(List<Customer> customers) {
        tx.begin();
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                if(customer.getId() == null){
                    em.persist(customer);
                }else{
                    em.merge(customer);
                }
            }
        tx.commit();
        
    }
    @Override
    public List<Customer> loadCustomer(){
        try {
            return em.createQuery("SELECT c FROM Customer c")
                    .getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, "Неудалось загрузить читателей", ex);
            return new ArrayList<>();
        }
    }
    @Override
    public void savePurchase(List<Purchase> purchases) {
        tx.begin();
            for (int i = 0; i < purchases.size(); i++) {
                Purchase purchase = purchases.get(i);
                if(purchase.getId() == null && purchase.getDate() == null){
                    em.persist(purchase);
                }else{
                    em.merge(purchase);
                }
            }
        tx.commit();
    }
    @Override
    public List<Purchase> loadPurchase() {
        try {
            return em.createQuery("SELECT pu FROM Purchase pu")
                    .getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, "Неудалось загрузить истории", ex);
            return new ArrayList<>();
        }
    }
    
    
}
