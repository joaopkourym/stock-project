import java.util.Scanner;

public class Product {
    private String productName;
    private Double price;
    private double totalPrice;
    private int stockAddedQuantity;
    private int stockRemovedQuantity;
    private int stockQuantity;
    private int selection;
    Scanner scanner = new Scanner(System.in);
        
    public void showProductData() {
        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        productName = scanner.next();

        System.out.print("Price: ");
        
        try {
            price = scanner.nextDouble();
            System.out.print("Quantity in stock: ");
            stockQuantity = scanner.nextInt();
    
            totalPrice = price * stockQuantity;
    
            System.out.format("Product data: %s, $%.2f, %d units, Total price: $%.2f\n", productName, price, stockQuantity, totalPrice);
            System.out.println("Select an option: (1)Remove product stock quantity | (2)Add product stock quantity");
            selection = scanner.nextInt();
        } catch (Exception erro) {
            System.out.println("Error!!! Put a valid price");
        }
    }

    public void addProductQuantity() {
        System.out.println("Enter the number of products to be added in stock: ");
        stockAddedQuantity = scanner.nextInt();
        stockQuantity += stockAddedQuantity;
        System.out.format("Current stock quantity: %d", stockQuantity);
    }

    public void removeProductQuantity() {
        System.out.println("Enter the number of products to be removed from stock: ");
        stockRemovedQuantity = scanner.nextInt();
        stockQuantity -= stockRemovedQuantity;
        System.out.format("Current stock quantity: %d", stockQuantity);
    }
}

