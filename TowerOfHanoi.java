import java.util.Scanner;
TowerOfHanoi
class  {
    // Recursive function to solve Tower of Hanoi
    static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        // Base case: only one disk
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }

        // Step 1: Move n-1 disks from source to auxiliary
        solveHanoi(n - 1, fromRod, auxRod, toRod);

        // Step 2: Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);

        // Step 3: Move n-1 disks from auxiliary to destination
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of disks
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        // Call recursive function
        solveHanoi(n, 'A', 'C', 'B'); // A = source, C = destination, B = auxiliary
    }
}

