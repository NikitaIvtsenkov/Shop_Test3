/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import java.util.List;

/**
 *
 * @author Gleb
 */
public interface DataPersistenceManage {
    public void saveProduct(List<Product> products);
    public List<Product> loadProduct();
    public void saveCustomer(List<Customer> customers);
    public List<Customer> loadCustomer();
    public void savePurchase(List<Purchase> histories);
    public List<Purchase> loadPurchase();
}

