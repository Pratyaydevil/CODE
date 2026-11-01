import java.util.*;

public class blockswap {
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle cases where k > n

        // Step 1: Copy first k elements into temp
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        // Step 2: Shift remaining elements to the left
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }

        // Step 3: Copy temp back to the end
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        rotateLeft(arr, k);

        System.out.println("After rotation: " + Arrays.toString(arr));
    }
}
