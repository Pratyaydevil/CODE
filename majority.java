import java.util.*;

class majority {
    static void findMajority(int arr[], int n) {
        int maxCount = 0;
        int index = -1; // sentinel

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }

        if (maxCount > n / 2) {
            System.out.println("Majority element is: " + arr[index]);
        } else {
            System.out.println("No majority element.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findMajority(arr, n);
    }
}

