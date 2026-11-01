import java.util.*;


import java.util.Scanner;

public class Slidingwindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // For each window of size k
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            // Find max in current window
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input window size
        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        // Compute result
        int[] result = maxSlidingWindow(nums, k);

        // Print output
        System.out.println("Maximums in each window:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
