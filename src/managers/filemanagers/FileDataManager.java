/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers.filemanagers;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import interfaces.DataPersistenceManage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gleb
 */
public class FileDataManager implements DataPersistenceManage{
    
    private final String PRODUCTS_FILE = "MyProduct";
    private final String CUSTOMERS_FILE = "MyCustomer";
    private final String PURCHASE_FILE = "MyPurchase";
    
    @Override
    public void saveProduct(List<Product> producs){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PRODUCTS_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(producs);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет MyProduct файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
        
    }

    @Override
    public List<Product> loadProduct() {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(PRODUCTS_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE,"Нет файла MyProduct", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return products;
    }

    @Override
    public void saveCustomer(List<Customer> customers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(CUSTOMERS_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет MyCustomer файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    @Override
    public List<Customer>loadCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(CUSTOMERS_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            customers = (List<Customer>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE,"Нет файла MyCustomer", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return customers;
    }


    @Override
    public void savePurchase(List<Purchase> purchases) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PURCHASE_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(purchases);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет MyPurchase файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }
    
    @Override
    public List<Purchase> loadPurchase() {
        List<Purchase> purchases = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(PURCHASE_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            purchases = (List<Purchase>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE,"Нет файла MyPurchase", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return purchases;
    }
}
