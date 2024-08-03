package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodeucts", "root", "Ahmed@2468##")) {
            itemManager itemManager = new itemManager(con);
            storeManager storeManager = new storeManager(con);

            System.out.println("choose 'insert' or 'select'?");
            String action = input.nextLine();

            System.out.println("Choose 'store' or 'items':");
            String target = input.nextLine();

            if (action.equals("insert")) {
                if (target.equals("store")) {
                    System.out.println("Enter store name:");
                    String storeName = input.nextLine();
                    System.out.println("Enter store code:");
                    int storeCode = input.nextInt();
                    input.nextLine();

                    storeManager.insertStore(storeName, storeCode);
                    System.out.println("Store inserted successfully.");
                } else if (target.equals("items")) {
                    System.out.println("Enter item name:");
                    String itemName = input.nextLine();
                    System.out.println("Enter item code:");
                    int itemCode = input.nextInt();
                    input.nextLine();

                    itemManager.insertitem(itemName, itemCode);
                    System.out.println("Item inserted successfully.");
                }
            } else if (action.equals("select")) {
                if (target.equals("store")) {
                    System.out.println("Enter store code to filter:");
                    int storeCode = input.nextInt();
                    input.nextLine();

                    store store = storeManager.findStore(storeCode);
                    if (store != null) {
                        System.out.println("Name: " + store.getName() + ", Code: " + store.getCode());
                    } else {
                        System.out.println("Store not found.");
                    }
                } else if (target.equals("items")) {
                    System.out.println("Enter item code to filter:");
                    int itemCode = input.nextInt();
                    input.nextLine();

                    item item = itemManager.findItem(itemCode);
                    if (item != null) {
                        System.out.println("Name: " + item.getName() + ", Code: " + item.getCode());
                    } else {
                        System.out.println("Item not found.");
                    }

                    System.out.println("Enter part of item name to search:");
                    String itemNamePart = input.nextLine();
                    List<item> items = itemManager.findItemsByNameContains(itemNamePart);
                    for (item foundItem : items) {
                        System.out.println("Name: " + foundItem.getName() + ", Code: " + foundItem.getCode());
                    }
                }
            } else {
                System.out.println("Invalid action. Please choose 'insert' or 'select'.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


