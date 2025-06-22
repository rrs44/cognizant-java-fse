public class FinancialForecasting {

    public static double futureValueRecursive(double initialValue, double rate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return futureValueRecursive(initialValue, rate, years - 1) * (1 + rate);
    }

    public static double futureValueMemo(double initialValue, double rate, int years, Double[] memo) {
        if (years == 0) return initialValue;

        if (memo[years] != null) return memo[years];

        memo[years] = futureValueMemo(initialValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 10000; 
        double rate = 0.10;          
        int years = 5;

        double result = futureValueRecursive(initialValue, rate, years);
        System.out.printf("Future value after %d years (recursive): ₹%.2f%n", years, result);

        Double[] memo = new Double[years + 1];
        double optimizedResult = futureValueMemo(initialValue, rate, years, memo);
        System.out.printf("Future value after %d years (memoized): ₹%.2f%n", years, optimizedResult);
    }
}
