import java.util.*;

public class binaryPalindrome {

    public static boolean isBinaryPalindrome(int n) {
        String binary = Integer.toBinaryString(n);

        int left = 0;
        int right = binary.length() - 1;

        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isBinaryPalindrome(n))
            System.out.println("Binary Palindrome");
        else
            System.out.println("Not a Binary Palindrome");

        System.out.println("Binary Representation: " + Integer.toBinaryString(n));
    }
}