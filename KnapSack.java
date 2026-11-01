public class KnapSack {

    // Function to solve 0/1 Knapsack using DP
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        // DP table: dp[i][w] = max value using first i items with capacity w
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Option 1: include item i-1
                    int include = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                    // Option 2: exclude item i-1
                    int exclude = dp[i - 1][w];
                    // Take max
                    dp[i][w] = Math.max(include, exclude);
                } else {
                    // Item too heavy, skip it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity]; // Final answer
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};   // profits
        int[] weights = {10, 20, 30};    // weights
        int capacity = 50;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}

