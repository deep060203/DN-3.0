import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Pride and Prejudice", "Jane Austen"),
            new Book(5, "Moby-Dick", "Herman Melville")
        };

        Library library = new Library(books);
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

            System.out.println("Enter the book title to search: ");
            String title = scanner.nextLine();

            Book result = null;

            switch (choice) {
                case 1:
                    // Linear Search
                    result = library.linearSearchByTitle(title);
                    System.out.println("Linear Search Result: " + (result != null ? result : "Book not found"));
                    break;

                case 2:
                    // Binary Search
                    result = library.binarySearchByTitle(title);
                    System.out.println("Binary Search Result: " + (result != null ? result : "Book not found"));
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
