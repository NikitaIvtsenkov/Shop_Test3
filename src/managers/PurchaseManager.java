/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Customer;
import entity.Purchase;
import entity.Product;
import entity.repository.CustomerFacade;
import entity.repository.ProductFacade;
import entity.repository.PurchaseFacade;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author mrALE
 */
public class PurchaseManager {

   // private CustomerManager customerManager;
    
   // private final ProductManager productManager;
    private final Scanner scanner = new Scanner(System.in);
    
    private final PurchaseFacade purchaseFacade;
    private final ProductFacade productFacade;
    private final CustomerFacade customerFacade;

    public PurchaseManager(){
        purchaseFacade = new PurchaseFacade();
         productFacade = new ProductFacade();
         customerFacade = new CustomerFacade();
       

        // productManager = new ProductManager();
       
       // customerManager = new CustomerManager();
    }
    public void  doPurchase(){
        Purchase purchase = new Purchase();
        System.out.println("Список покупателей: ");
        CustomerManager сustomerManager = new CustomerManager();
        сustomerManager.printListCustomers();
        System.out.print("Выберите номер покупателея из списка: ");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        Customer customer = customerFacade.find((long) numberCustomer);
        System.out.println("Список товаров: ");
        ProductManager productManager = new ProductManager();
        productManager.printListProducts();
        System.out.print("Выберите номер товара из списка: ");
        int numberProduct = scanner.nextInt(); scanner.nextLine();
        Product product = productFacade.find((long)numberProduct);
        System.out.println("Сколько товара вы хотите купить: ");
        int quantity = scanner.nextInt();
     
       
      
        if(customer.getWallet() > (product.getCost()*quantity) && product.getQuantity() >= quantity){ 
            purchase.setProduct(product);
            purchase.setCustomer(customer);
            purchase.setDate(new GregorianCalendar().getTime());
            purchase.setQuantity(quantity);
            purchase.setHistory(purchase.getProduct().getCost()*purchase.getQuantity());
            purchaseFacade.save(purchase);
            customer.setWallet((customer.getWallet())-(purchase.getProduct().getCost()*purchase.getQuantity()));
            customerFacade.save(customer);
            product.setQuantity((product.getQuantity())-(purchase.getQuantity()));
            productFacade.save(product);
        }else if(customer.getWallet() < (product.getCost()*quantity)){
            System.out.println("У вас нет денег");             
        }else if(product.getQuantity() < quantity ){
            System.out.println("У нас нет столко товара");
        
        }else if(product.getQuantity() == 0 ){
            System.out.println("У нас закончился этот товар");
    }
    }

    public int getProfite() { 
        int sum = 0;
       List<Purchase> purchases = purchaseFacade.findAll();
        for (int i = 0; i < purchases.size(); i++) {
            Purchase purchase = purchases.get(i);
            sum =sum+purchase.getHistory();
            
        }
       return sum;
    }
    public void AddMoney(){
        System.out.println("Список покупателей: ");
        CustomerManager сustomerManager = new CustomerManager();
        сustomerManager.printListCustomers();
        
        System.out.print("Выберите номер покупателея из списка: ");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        Customer customer = customerFacade.find((long) numberCustomer);
       
        System.out.println("Введите сумму,которую получит покупатель: ");
        int givecustomermoney = scanner.nextInt();
        customer.setWallet(customer.getWallet()+ givecustomermoney);
        customerFacade.save(customer);
        
    }
    
}