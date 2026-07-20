public class FinancialForecastingTest {
    public static void main(String[] args) {
        System.out.println("--- Concept of Recursion ---");
        System.out.println("Recursion simplifies complex problems by breaking them down into smaller, self-similar sub-problems until a base case is reached.");

        double presentValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        System.out.println("\n--- Forecasting Execution ---");
        System.out.printf("Present Value: $%.2f | Annual Growth Rate: %.0f%%\n", presentValue, (growthRate * 100));
        
        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Predicted Future Value after %d years: $%.2f\n", years, futureValue);

        System.out.println("\n--- Complexity & Optimization Analysis ---");
        System.out.println("Time Complexity: O(n) where 'n' is the number of periods, because it makes 'n' sequential recursive calls.");
        System.out.println("Optimization: To avoid excessive computation (StackOverflow) in deep recursive trees, we can use Memoization to cache previously calculated periods in a HashMap. Alternatively, rewriting it iteratively or using the mathematical formula O(1) is best for enterprise systems.");
    }

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return (1 + growthRate) * calculateFutureValue(presentValue, growthRate, periods - 1);
    }
}