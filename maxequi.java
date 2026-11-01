import java.util.*;

class Main {
    static int maxequi(int[] arr, int n) {
        int res = Integer.MIN_VALUE;

        // Iterate through each index
        for (int i = 0; i < n; i++) {
            int prefix_sum = 0;
            for (int j = 0; j <= i; j++) {
                prefix_sum += arr[j];
            }

            int suffix_sum = 0;
            for (int j = i; j < n; j++) {
                suffix_sum += arr[j];
            }

            if (prefix_sum == suffix_sum) {
                res = Math.max(res, prefix_sum);
            }
        }

        return (res == Integer.MIN_VALUE) ? -1 : res; // return -1 if no match found
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = s.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int ans = findMaxSum(arr, n);
        if (ans == -1) {
            System.out.println("No prefix-suffix sum match found.");
        } else {
            System.out.println("Maximum prefix-suffix sum = " + ans);
        }

        s.close();
    }
}

