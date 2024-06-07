package com.productapp;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.productapp.daoimpl.ProductDAOImpl;
import com.productapp.model.Product;

public class ProductApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        boolean running = true;

        while (running) {
            System.out.println("Welcome to CRUD app");
            System.out.println("1. Insert");
            System.out.println("2. Fetch all products");
            System.out.println("3. Fetch product by id");
            System.out.println("4. Delete product");
            System.out.println("5. Update product");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    float price = scanner.nextFloat();
                    Product newProduct = new Product(id, name, price);
                    int insertResult = productDAOImpl.save(newProduct);
                    System.out.println(insertResult + " row(s) inserted");
                    break;

                case 2:
                    List<Product> productsList = productDAOImpl.getAll();
                    Iterator<Product> productIterator = productsList.iterator();
                    while (productIterator.hasNext()) {
                        Product product = productIterator.next();
                        System.out.println(product);
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int fetchId = scanner.nextInt();
                    Product fetchedProduct = productDAOImpl.getById(fetchId);
                    if (fetchedProduct != null) {
                        System.out.println(fetchedProduct);
                    } else {
                        System.out.println("Product with given ID is not found!!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    int deleteResult = productDAOImpl.remove(deleteId);
                    System.out.println(deleteResult + " row(s) deleted");
                    break;

                case 5:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter New Product Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Product Price: ");
                    float newPrice = scanner.nextFloat();
                    Product updatedProduct = new Product(updateId, newName, newPrice);
                    int updateResult = productDAOImpl.update(updateId, updatedProduct);
                    System.out.println(updateResult + " row(s) updated");
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
        scanner.close();
    }
}
