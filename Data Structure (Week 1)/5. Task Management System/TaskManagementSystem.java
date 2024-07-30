import java.util.Scanner;

public class TaskManagementSystem {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an operation: ");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("Enter Task Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Task Status: ");
                    String status = scanner.nextLine();

                    Task task = new Task(id, name, status);
                    taskList.addTask(task);
                    break;

                case 2:
                    System.out.println("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Task foundTask = taskList.searchTask(searchId);
                    System.out.println(foundTask != null ? foundTask : "Task not found.");
                    break;

                case 3:
                    taskList.traverseTasks();
                    break;

                case 4:
                    System.out.println("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    taskList.deleteTask(deleteId);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Exiting the program.");
    }
}
