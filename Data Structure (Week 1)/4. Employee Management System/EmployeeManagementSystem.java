import java.util.Scanner;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size == capacity) {
            System.out.println("Array is full, cannot add more employees.");
            return;
        }
        employees[size++] = employee;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {

                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(10);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an operation: ");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Employee Position: ");
                    String position = scanner.nextLine();

                    System.out.println("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character

                    Employee emp = new Employee(id, name, position, salary);
                    system.addEmployee(emp);
                    break;

                case 2:
                    System.out.println("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Employee foundEmp = system.searchEmployee(searchId);
                    System.out.println(foundEmp != null ? foundEmp : "Employee not found.");
                    break;

                case 3:
                    system.traverseEmployees();
                    break;

                case 4:
                    System.out.println("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    system.deleteEmployee(deleteId);
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

