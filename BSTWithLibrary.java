import java.util.Scanner;
import java.util.TreeSet;

public class BSTWithLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TreeSet automatically maintains sorted order (like a BST)
        TreeSet<Integer> bst = new TreeSet<>();

        // Insert elements
        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(1);
        bst.add(4);

        // User insertion
        System.out.print("Enter a value to insert: ");
        int key = sc.nextInt();
        if (!bst.add(key)) {
            System.out.println("Cannot insert " + key + ", already in BST");
        }

        // Traversals
        System.out.println("\nInorder Traversal (TreeSet iteration):");
        for (int val : bst) {
            System.out.print(val + " ");
        }

        // Search
        System.out.print("\nEnter a value to search: ");
        int searchKey = sc.nextInt();
        if (bst.contains(searchKey)) {
            System.out.println(searchKey + " found in BST");
        } else {
            System.out.println(searchKey + " not found");
        }

        sc.close();
    }
}
