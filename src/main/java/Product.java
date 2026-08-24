/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SEISANI GUNDO JR
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {

    private static Scanner s = new Scanner(System.in);
    private static ArrayList<ReportData> list = new ArrayList<>();

    public Product() {

        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("****************************************");

        while (true) {

            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String value = s.nextLine();

            if ("1".equals(value.trim())) {

                switch (DisplayMenu()) {
                    case 1:
                        CaptureProduct();
                        break;
                    case 2:
                        SearchProduct();
                        break;
                    case 3:
                        UpdateProduct();
                        break;
                    case 4:
                        DeleteProduct();
                        break;
                    case 5:
                        PrintProductReport();
                        break;
                    case 6:
                        Exit();
                        break;
                }

            } else {
                Exit();
            }
        }
    }

    public static int DisplayMenu() {

        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new product");
        System.out.println("(2) Search for a product");
        System.out.println("(3) Update a product");
        System.out.println("(4) Delete a product");
        System.out.println("(5) Print report");
        System.out.println("(6) Exit application");

        while (true) {

            try {
                System.out.print("Choice >> ");
                int choice = s.nextInt();
                s.nextLine();

                if (choice >= 1 && choice <= 6) {
                    return choice;
                }

                System.out.println("Choice must be between 1 and 6");

            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only.");
                s.nextLine();
            }
        }
    }

    public static void CaptureProduct() {

        System.out.println("\nCAPTURE A NEW PRODUCT");

        System.out.print("Enter Product Code: ");
        String code = s.nextLine();

        for (ReportData p : list) {
            if (p.getProductCode().equalsIgnoreCase(code)) {
                System.out.println("Product already exists.");
                return;
            }
        }

        System.out.print("Enter Product Name: ");
        String name = s.nextLine();

        int category;

        while (true) {
            try {
                System.out.println("1 - Desktop Computer");
                System.out.println("2 - Laptop");
                System.out.println("3 - Tablet");
                System.out.println("4 - Printer");
                System.out.println("5 - Gaming Console");

                System.out.print("Category >> ");
                category = s.nextInt();
                s.nextLine();

                if (category >= 1 && category <= 5) {
                    break;
                }

            } catch (InputMismatchException e) {
                s.nextLine();
            }

            System.out.println("Enter a value between 1 and 5.");
        }

        System.out.print("Enter (1) for 6 Months Warranty, any other key for 2 Years: ");
        String w = s.nextLine();

        double warranty;

        if ("1".equals(w.trim())) {
            warranty = 6;
        } else {
            warranty = 24;
        }

        double price;

        while (true) {
            try {

                System.out.print("Enter Product Price: ");
                price = s.nextDouble();
                s.nextLine();

                if (price >= 0) {
                    break;
                }

                System.out.println("Price cannot be negative.");

            } catch (InputMismatchException e) {
                System.out.println("Invalid price.");
                s.nextLine();
            }
        }

        int stock;

        while (true) {

            try {
                System.out.print("Enter Stock Level: ");
                stock = s.nextInt();
                s.nextLine();

                if (stock >= 0) {
                    break;
                }

                System.out.println("Stock cannot be negative.");

            } catch (InputMismatchException e) {
                System.out.println("Invalid stock level.");
                s.nextLine();
            }
        }

        System.out.print("Enter Supplier Name: ");
        String supplier = s.nextLine();

        ReportData product = new ReportData(
                code,
                name,
                warranty,
                category,
                price,
                stock,
                supplier);

        SaveProduct(product);
    }

    public static void SaveProduct(ReportData product) {

        list.add(product);

        System.out.println("Product saved successfully.");
    }

    public static void SearchProduct() {

        System.out.print("Enter Product Code: ");
        String code = s.nextLine();

        for (ReportData product : list) {

            if (product.getProductCode().equalsIgnoreCase(code)) {

                System.out.println("\nPRODUCT FOUND");
                System.out.println("Code: " + product.getProductCode());
                System.out.println("Name: " + product.getProductName());
                System.out.println("Warranty: " + product.getWarranty() + " Months");
                System.out.println("Category: " + CategName(product.getCategory()));
                System.out.println("Price: R" + product.getPrice());
                System.out.println("Stock: " + product.getStockLevels());
                System.out.println("Supplier: " + product.getSupplier());

                return;
            }
        }

        System.out.println("Product not found.");
    }

    public static void UpdateProduct() {

        System.out.print("Enter Product Code to Update: ");
        String code = s.nextLine();

        for (ReportData product : list) {

            if (product.getProductCode().equalsIgnoreCase(code)) {

                System.out.print("New Price: ");
                double price = s.nextDouble();
                s.nextLine();

                System.out.print("New Stock Level: ");
                int stock = s.nextInt();
                s.nextLine();

                product.setPrice(price);
                product.setStockLevels(stock);

                System.out.println("Product updated successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public static void DeleteProduct() {

        System.out.print("Enter Product Code to Delete: ");
        String code = s.nextLine();

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getProductCode().equalsIgnoreCase(code)) {

                list.remove(i);

                System.out.println("Product deleted successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public static void PrintProductReport() {

        if (list.isEmpty()) {
            System.out.println("No products captured.");
            return;
        }

        double totalValue = 0;

        System.out.println("\nPRODUCT REPORT");

        for (int i = 0; i < list.size(); i++) {

            ReportData product = list.get(i);

            totalValue += product.getPrice() * product.getStockLevels();

            System.out.println("----------------------------------");
            System.out.println("Product " + (i + 1));
            System.out.println("Code: " + product.getProductCode());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Category: " + CategName(product.getCategory()));
            System.out.println("Price: R" + product.getPrice());
            System.out.println("Stock: " + product.getStockLevels());
            System.out.println("Supplier: " + product.getSupplier());
        }

        System.out.println("----------------------------------");
        System.out.println("Total Products: " + list.size());
        System.out.println("Total Value: R" + totalValue);
    }

    public static String CategName(int category) {

        switch (category) {
            case 1:
                return "Desktop Computer";
            case 2:
                return "Laptop";
            case 3:
                return "Tablet";
            case 4:
                return "Printer";
            case 5:
                return "Gaming Console";
            default:
                return "Unknown";
        }
    }

    public static void Exit() {

        System.out.println("END. Have a great day!");
        System.exit(0);
    }
}