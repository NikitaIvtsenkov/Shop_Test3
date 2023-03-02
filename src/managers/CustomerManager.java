/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Customer;
import entity.repository.CustomerFacade;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class CustomerManager {
    private Scanner scanner;

    public CustomerManager() {
        this.scanner = new Scanner(System.in);

    }
    public Customer createCustomer(){
        
        Customer customer = new Customer();
        System.out.printf("Введите имя покупателя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.printf("Введите фамилию покупателя: ");
        customer.setLastname(scanner.nextLine());
        System.out.printf("Введите количество денег у покупателя: ");
        customer.setWallet(scanner.nextInt());
        return customer;
    }  
    public void printListCustomers(){
        CustomerFacade сustomerFacade = new CustomerFacade();
        List<Customer> сustomer = сustomerFacade.findAll();
        for (int i = 0; i < сustomer.size(); i++) {
            Customer сustomers = сustomer.get(i);
            System.out.printf("%d. %s %s Wallet: %s%n"
                    ,сustomers.getId()
                    ,сustomers.getFirstname()
                    ,сustomers.getLastname()
                    ,сustomers.getWallet()
            );
        }
    }
}
