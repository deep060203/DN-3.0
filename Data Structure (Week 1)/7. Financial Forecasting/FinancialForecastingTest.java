import java.util.Scanner;

public class FinancialForecastingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the present value: ");
        double presentValue = scanner.nextDouble();

        System.out.println("Enter the annual growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.println("Enter the number of periods (years): ");
        int periods = scanner.nextInt();

        // Calculate future value using recursion
        double futureValue = FinancialForecasting.calculateFutureValue(presentValue, growthRate, periods);

        System.out.println("The future value is: " + futureValue);
        scanner.close();
    }
}
