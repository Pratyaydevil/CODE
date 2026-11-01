import java.io.*;

class hour {
    static int row = 5;
    static int col = 5;

    static int findMaxSum(int[][] mat) {
        if (row < 3 || col < 3) {
            System.out.println("Not possible to compute hourglass sum");
            return -1;
        }

        int max_sum = Integer.MIN_VALUE;

        // Traverse all possible hourglasses
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                int sum = (mat[i][j] + mat[i][j + 1] + mat[i][j + 2])   // top row
                        + (mat[i + 1][j + 1])                           // middle
                        + (mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]); // bottom row

                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 0, 0},
            {0, 0, 0, 0, 0},
            {2, 1, 4, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0}
        };

        int res = findMaxSum(mat);
        System.out.println("Maximum sum of hourglass = " + res);
    }
}

