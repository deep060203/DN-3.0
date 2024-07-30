import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Clothing"),
            new Product(3, "Coffee Maker", "Home Appliances"),
            new Product(4, "Smartphone", "Electronics"),
            new Product(5, "Book", "Books")
        };

        Comparator<Product> productNameComparator = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getProductName().compareToIgnoreCase(p2.getProductName());
            }
        };


        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, productNameComparator);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose the search method (1 for Linear Search, 2 for Binary Search, 0 to Exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 0) {
                running = false;
                break;
            }

            System.out.println("Enter the product ID (or 0 if not searching by ID): ");
            Integer productId = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Enter the product name (or leave empty if not searching by name): ");
            String productName = scanner.nextLine();

            System.out.println("Enter the category (or leave empty if not searching by category): ");
            String category = scanner.nextLine();

            Product result = null;

            switch (choice) {
                case 1:
                    // Linear Search
                    result = LinearSearch.linearSearch(products, productId == 0 ? null : productId, productName.isEmpty() ? null : productName, category.isEmpty() ? null : category);
                    System.out.println("Linear Search Result: " + (result != null ? result : "Product not found"));
                    break;

                case 2:
                    // Binary Search
                    if (!productName.isEmpty()) {
                        result = BinarySearch.binarySearch(sortedProducts, productName, productNameComparator);
                        System.out.println("Binary Search Result: " + (result != null ? result : "Product not found"));
                    } else {
                        System.out.println("Binary search requires a non-empty product name.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        scanner.close();
        System.out.println("Exiting the program.");
    }
}

