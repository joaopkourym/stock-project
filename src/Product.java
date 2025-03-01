// Import Scanner class for user input handling
import java.util.Scanner;

/**
 * Represents a product with properties and methods for stock management.
 * Allows users to input product data, adjust stock quantities, and view product information.
 */
public class Product {
    // Product properties
    private String productName;         // Name of the product
    private Double price;               // Unit price of the product
    private double totalPrice;          // Total value of all units in stock (price * quantity)
    private int stockAddedQuantity;     // Temporary storage for added stock quantity
    private int stockRemovedQuantity;   // Temporary storage for removed stock quantity
    private int stockQuantity;          // Current quantity of the product in stock
    private int selection;              // User's menu selection
    
    // Scanner object for reading user input from console
    Scanner scanner = new Scanner(System.in);

    /**
     * Main method for product data entry and stock management.
     * Handles user input for initial product setup and provides menu options for stock operations.
     * Includes error handling for invalid price input.
     */
    public void enterProductData() {
        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        productName = scanner.next();

        System.out.print("Price: ");
        try {
            // Read and validate price input
            price = scanner.nextDouble();
            
            // Read initial stock quantity
            System.out.print("Quantity in stock: ");
            stockQuantity = scanner.nextInt();

            // Calculate initial total price
            totalPrice = price * stockQuantity;

            // Display initial product information
            System.out.format("Product data: %s, $%.2f, %d units, Total price: $%.2f\n", 
                productName, price, stockQuantity, totalPrice);

            // Stock management menu loop
            do {
                System.out.println("Select an option: (0)Show product data | (1)Remove product stock quantity | (2)Add product stock quantity");
                selection = scanner.nextInt();

                // Handle user selection using switch statement
                switch (selection) {
                    case 0 ->  // Display current product information
                        showProductData();
                    case 1 ->  // Remove stock quantity
                        removeProductQuantity();
                    case 2 ->  // Add stock quantity
                        addProductQuantity();
                    case 3 ->  // Exit program
                        System.out.println("You chose exit. Goodbye!");
                    default ->  // Handle invalid options
                        System.out.println("Error! Select a valid option...");
                }
            } while (selection != 3);  // Continue until user selects exit
            
        } catch (Exception error) {
            // Handle input mismatch exceptions (non-numeric input for price)
            System.out.println("Error!!! Put a valid price");
        }
    }

    /**
     * Adds specified quantity to stock and updates total price.
     * Prompts user for quantity to add and updates stock information.
     */
    private void addProductQuantity() {
        System.out.print("\nEnter the number of products to be added in stock: ");
        stockAddedQuantity = scanner.nextInt();
        stockQuantity += stockAddedQuantity;
        totalPrice = price * stockQuantity;
        System.out.format("Current stock quantity: %d.\n", stockQuantity);
    }
    
    /**
     * Removes specified quantity from stock and updates total price.
     * Prompts user for quantity to remove and updates stock information.
     */
    private void removeProductQuantity() {
        System.out.print("Enter the number of products to be removed from stock: ");
        stockRemovedQuantity = scanner.nextInt();
        stockQuantity -= stockRemovedQuantity;
        if (stockQuantity < 0) {
            System.out.println("ERROR!!! Invalid quantity of stock");
        }else{
            totalPrice = price * stockQuantity;
            System.out.format("Current stock quantity: %d.\n", stockQuantity);
        }
    }

    /**
     * Displays formatted product information including:
     * - Product name
     * - Unit price
     * - Current stock quantity
     * - Total inventory value
     * */
    private void showProductData() {
        System.out.format("\nProduct data: %s, $%.2f, %d units, Total price: $%.2f\n", 
            productName, price, stockQuantity, totalPrice);
    }
}