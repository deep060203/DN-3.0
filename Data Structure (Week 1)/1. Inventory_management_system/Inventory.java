import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Inventory {
	private Map<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product not found!");
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double addPrice = scanner.nextDouble();
                    inventory.addProduct(new Product(addId, addName, addQuantity, addPrice));
                    System.out.println("Product added successfully.");
                    break;
                
                case 2:
                    System.out.print("Enter Product ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Updated Product Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter Updated Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter Updated Price: ");
                    double updatePrice = scanner.nextDouble();
                    inventory.updateProduct(new Product(updateId, updateName, updateQuantity, updatePrice));
                    System.out.println("Product updated successfully.");
                    break;
                
                case 3:
                    System.out.print("Enter Product ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    inventory.deleteProduct(deleteId);
                    System.out.println("Product deleted successfully.");
                    break;
                
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
