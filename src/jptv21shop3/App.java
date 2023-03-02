/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv21shop3;

import managers.CustomerManager;
import entity.Customer;
import managers.ProductManager;
import managers.PurchaseManager;
import entity.Product;
import entity.Purchase;
import entity.repository.CustomerFacade;
import entity.repository.ProductFacade;
import entity.repository.PurchaseFacade;
import interfaces.DataPersistenceManage;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import managers.basemanager.DataBaseManager;
import managers.filemanagers.FileDataManager;

/**
 *
 * @author pupil
 */
public class App {
    private final PurchaseFacade purchaseFacade;
    private final ProductFacade productFacade;
    private final CustomerFacade customerFacade;
    public static boolean saveToBase = false;
    private final DataPersistenceManage dataManager;
    
    private PurchaseManager purchaseManager;
    private ProductManager productManager;
    private CustomerManager customerManager;  
    public App() {
        if(App.saveToBase){
            dataManager = new DataBaseManager();
        }else{
            dataManager = new FileDataManager();
        }
        purchaseFacade = new PurchaseFacade();
        productFacade = new ProductFacade();
        customerFacade = new CustomerFacade();
        productManager = new ProductManager();
        customerManager = new CustomerManager();
        purchaseManager = new PurchaseManager();
    }
    public void run(){
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        OUTER:
        do{
            System.out.println("================");
            System.out.println("Список задач:");
            System.out.println("0. Закрыть приложение");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Добавить покупателя");
            System.out.println("3. Список продаваемых продуктов");
            System.out.println("4. Список зарегестрированных покупателей");
            System.out.println("5. Покупка покупателем продукта");
            System.out.println("6. Доход магазина за все время работы");
            System.out.println("7. Добавить денег покупателю");
            System.out.printf("Выберите номер задачи:");
            int task = scanner.nextInt();
            System.out.println("================");
            switch(task){
                 case 0:
                    repeat = false;
                    System.out.println("Задача 0. Закрыть приложение");
                    break OUTER;
                case 1:
                    System.out.println("Задача 1. Добавить продукт");
                    productFacade.save(productManager.createProduct());                   
                    break;
                case 2:
                    System.out.println("Задача 2. Добавить покупателя");
                    customerFacade.save(customerManager.createCustomer());         
                    break;
                case 3:
                    System.out.println("Задача 3. Список товаров");
                    productManager.printListProducts();
                   
                    break;
                case 4:
                    System.out.println("Задача 4. Список покупателей");
                    customerManager.printListCustomers();
                    break; 
                case 5:
                    System.out.println("Задача 5. Покупка покупателем продукта");
                    purchaseManager.doPurchase();
                  
                     break;
                case 6:
                    System.out.println("Задача 6.  Доход магазина за все время работы");
                    System.out.println(purchaseManager.getProfite());
                    break;
                case 7:
                    System.out.println("Задача 7. Добавить денег покупателю");
                    purchaseManager.AddMoney();
                    break;    
                default:
                    System.out.println("Выберите задачу из списка");
            }
        }while(repeat);
    }
}

