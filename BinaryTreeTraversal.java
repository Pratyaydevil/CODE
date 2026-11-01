class Node {
    int data;
    Node left, right;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeTraversal {

    // Preorder Traversal: Root → Left → Right
    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Inorder Traversal: Left → Root → Right
    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Postorder Traversal: Left → Right → Root
    static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        // Constructing the tree
        Node p = new Node(4);
        Node p1 = new Node(1);
        Node p2 = new Node(6);
        Node p3 = new Node(5);
        Node p4 = new Node(2);

        // Linking nodes
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;

        // Tree looks like:
        //      4
        //     / \
        //    1   6
        //   / \
        //  5   2  

        System.out.println("Preorder Traversal:");
        preOrder(p);
        System.out.println("\nInorder Traversal:");
        inOrder(p);
        System.out.println("\nPostorder Traversal:");
        postOrder(p);
    }
}

