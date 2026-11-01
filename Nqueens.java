import java.util.*;

public class NQueens {

    static int N;

    // Function to print the board
    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if placing queen at board[row][col] is safe
    static boolean isSafe(int[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    // Recursive utility to solve N-Queens
    static void solveNQueens(int[][] board, int row) {
        if (row == N) {
            printSolution(board);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // place queen
                solveNQueens(board, row + 1);
                board[row][col] = 0; // backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N (size of board): ");
        N = sc.nextInt();

        int[][] board = new int[N][N];
        solveNQueens(board, 0);

        sc.close();
    }
}
