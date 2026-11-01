public class SearchExample {

    // Linear Search
    public static int linearSearch(int[] arr, int size, int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int size, int element) {
        int low = 0, high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == element) {
                return mid;
            }
            if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        // Unsorted array for linear search
        // int[] arr = {1, 3, 5, 56, 4, 3, 23, 5, 4, 54634, 56, 34};
        // int size = arr.length;

        // Sorted array for binary search
        int[] arr = {1, 3, 5, 56, 64, 73, 123, 225, 444};
        int size = arr.length;
        int element = 444;

        int searchIndex = binarySearch(arr, size, element);
        System.out.println("The element " + element + " was found at index " + searchIndex);
    }
}