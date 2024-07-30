import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 300.0),
            new Order(4, "David", 200.0),
            new Order(5, "Eve", 100.0)
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose the sorting method (1 for Bubble Sort, 2 for Quick Sort, 0 to Exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            Order[] sortedOrders = orders.clone();
            switch (choice) {
                case 1:
                    BubbleSort.bubbleSort(sortedOrders);
                    System.out.println("Orders sorted by Bubble Sort:");
                    for (Order order : sortedOrders) {
                        System.out.println(order);
                    }
                    break;

                case 2:
                    QuickSort.quickSort(sortedOrders, 0, sortedOrders.length - 1);
                    System.out.println("Orders sorted by Quick Sort:");
                    for (Order order : sortedOrders) {
                        System.out.println(order);
                    }
                    break;

                case 0:
                    running = false;
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
