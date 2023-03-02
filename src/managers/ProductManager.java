/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Product;
import entity.repository.ProductFacade;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author pupil
 */
public class ProductManager {
    private Scanner scanner;

    public ProductManager() {
        this.scanner = new Scanner(System.in);
    }

    public Product createProduct(){
        
        Product product = new Product();
        System.out.printf("Введите название продукта: ");
        product.setName(scanner.nextLine());
        System.out.printf("Введите название брэнда: ");
        product.setBrand(scanner.nextLine());
        System.out.printf("Введите цену: ");
        product.setCost(scanner.nextInt());
        System.out.printf("Введите количество товара: ");
        product.setQuantity(scanner.nextInt());
//        System.out.printf("razmer");
//        product.setRazmer(scanner.nextInt());
        
        return product;
    }
    public void printListProducts(){    
        ProductFacade productFacade = new ProductFacade();
        List<Product> product = productFacade.findAll();
        for (int i = 0; i < product.size(); i++) {
            Product products = product.get(i);
            System.out.printf("%d. %s %s%n   Cost: %s%n   Quantity: %s%n"
                    ,products.getId()
                    ,products.getName()
                    ,products.getBrand()
                    ,products.getCost()
                    ,products.getQuantity()
//                       Razmer: %s%n ,products.getRazmer()
            );
        }
    }
}

