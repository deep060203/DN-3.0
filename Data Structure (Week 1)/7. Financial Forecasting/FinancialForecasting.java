public class FinancialForecasting {
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return (1 + growthRate) * calculateFutureValue(presentValue, growthRate, periods - 1);
    }
}
