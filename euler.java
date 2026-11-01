import java.util.Scanner;

public class euler {

    // Function to compute gcd of two numbers
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Function to compute Euler's Totient φ(n)
    static int phi(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (gcd(i, n) == 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Euler's Totient φ(" + n + ") = " + phi(n));

        sc.close();
    }
}
