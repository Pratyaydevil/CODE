public class trapWater {

    static int trap(int[] height) {

        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        // Find highest bar on the left of each index
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // Find highest bar on the right of each index
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int water = 0;

        // Formula:
        // Water = min(Highest Left, Highest Right) - Current Height
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {

        int[] height = {3, 0, 2, 0, 4};

        System.out.println("Water Trapped = " + trap(height));
    }
}
