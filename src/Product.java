    import java.util.Scanner;

public class Product {
    private String productName;
    private double price;
    private double totalPrice;
    private int stockAddedQuantity;
    private int stockRemovedQuantity;
    private int stockQuantity;
    Scanner scanner = new Scanner(System.in);
        
    public void showProductData() {
        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        productName = scanner.next();

        System.out.print("Price: ");
        price = scanner.nextDouble();

        System.out.print("Quantity in stock: ");
        stockQuantity = scanner.nextInt();

        totalPrice = price * stockQuantity;

        System.out.format("Product data: %s, $%.2f, %d units, Total price: $%.2f\n", productName, price, stockQuantity, totalPrice);
    }

    public void addProductQuantity() {
        System.out.print("Enter the number of products to be added in stock: ");
        stockAddedQuantity = scanner.nextInt();
        System.out.println(stockQuantity);
        stockQuantity += stockAddedQuantity;
        System.out.println(stockQuantity);
    
    }

    public void removeProductQuantity() {
        System.out.print("Enter the number of products to be removed from stock: ");
        stockRemovedQuantity = scanner.nextInt();
        stockQuantity -= stockRemovedQuantity;
    }
}
