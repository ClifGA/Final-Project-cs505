import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class InventoryManagement {
    private static ArrayList<InventoryItem> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Add a new item to the inventory
    public static void addItem(InventoryItem item) {
        inventory.add(item);
    }

    // List all items in the inventory
    public static void listItems() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            for (InventoryItem item : inventory) {
                System.out.println(item);
            }
        }
    }

    // Sort items by name
    public static void sortItemsByName() {
        Collections.sort(inventory, Comparator.comparing(InventoryItem::getItemName));
    }

    // Sort items by price
    public static void sortItemsByPrice() {
        Collections.sort(inventory, Comparator.comparingDouble(InventoryItem::getPrice));
    }

    // Display menu options for users
    public static void displayMenu() {
        System.out.println("\nInventory Management System");
        System.out.println("1. List all items");
        System.out.println("2. Add a new item");
        System.out.println("3. Remove an item");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        // Fake import data for example
        addItem(new NewItem("Laptop", 10, 999.99, "New", "Aisle 3", "2 years"));
        addItem(new OldItem("Phone", 5, 299.99, "Slightly scratched"));
        addItem(new NewItem("Headphones", 20, 89.99, "New", "Aisle 1", "1 year"));
        addItem(new OldItem("Tablet", 7, 399.99, "Screen cracked"));
        addItem(new NewItem("Smartwatch", 15, 199.99, "New", "Aisle 2", "6 months"));
        addItem(new OldItem("Camera", 3, 499.99, "Lens scratched"));
        addItem(new NewItem("Keyboard", 50, 49.99, "New", "Aisle 5", "1 year"));
        addItem(new OldItem("Monitor", 8, 249.99, "Minor dents"));
        addItem(new NewItem("Mouse", 30, 29.99, "New", "Aisle 4", "1 year"));
        addItem(new OldItem("Charger", 12, 19.99, "Frayed cable"));
        

        boolean running = true;
        while (running) {
            displayMenu(); // Show the menu options
            int choice = scanner.nextInt(); // Get user input

            // Handle the user's choice
            switch (choice) {
                case 1:
                    // List items in the inventory with sorting options
                    System.out.println("Sort by: ");
                    System.out.println("1. Name");
                    System.out.println("2. Price");
                    int sortChoice = scanner.nextInt();

                    if (sortChoice == 1) {
                        sortItemsByName();
                        System.out.println("Items sorted by name:");
                    } else if (sortChoice == 2) {
                        sortItemsByPrice();
                        System.out.println("Items sorted by price:");
                    } else {
                        System.out.println("Invalid option. Showing unsorted items.");
                    }
                    listItems();
                    break;

                case 2:
                    // Add a new item to the inventory
                    scanner.nextLine(); 
                    System.out.println("Enter item name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); 

                    System.out.println("Is the item new or old?");
                    String type = scanner.nextLine();

                    if (type.equalsIgnoreCase("new")) {
                        System.out.println("Enter condition:");
                        String condition = scanner.nextLine();
                        System.out.println("Enter location:");
                        String location = scanner.nextLine();
                        System.out.println("Enter warranty period:");
                        String warrantyPeriod = scanner.nextLine();

                        // Add new item to inventory
                        addItem(new NewItem(name, quantity, price, condition, location, warrantyPeriod));
                    } else if (type.equalsIgnoreCase("old")) {
                        System.out.println("Enter damage description:");
                        String damageDescription = scanner.nextLine();

                        // Add old item to inventory
                        addItem(new OldItem(name, quantity, price, damageDescription));
                    } else {
                        System.out.println("Invalid item type.");
                    }
                    break;

                case 3:
                    // Remove an item from the inventory
                    scanner.nextLine(); 
                    System.out.println("Enter the name of the item to remove:");
                    String itemNameToRemove = scanner.nextLine();
                    RemoveItem.removeItemByName(inventory, itemNameToRemove);
                    break;

                case 4:
                    // Exit the program
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}