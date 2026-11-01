class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BSTExample {

    // Preorder Traversal
    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Inorder Traversal
    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Postorder Traversal
    static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Check if tree is BST
    static boolean isBST(Node root) {
        return isBSTUtil(root, null);
    }

    private static boolean isBSTUtil(Node root, Node prev) {
        if (root != null) {
            if (!isBSTUtil(root.left, prev)) return false;
            if (prev != null && root.data <= prev.data) return false;
            prev = root;
            return isBSTUtil(root.right, prev);
        }
        return true;
    }

    // Iterative Search
    static Node searchIter(Node root, int key) {
        while (root != null) {
            if (key == root.data) {
                return root;
            } else if (key < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    // Insert into BST
    static void insert(Node root, int key) {
        Node prev = null;
        Node current = root;

        while (current != null) {
            prev = current;
            if (key == current.data) {
                System.out.println("Cannot insert " + key + ", already in BST");
                return;
            } else if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        Node newNode = new Node(key);
        if (key < prev.data) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
    }

    public static void main(String[] args) {
        // Constructing the BST
        Node p = new Node(5);
        Node p1 = new Node(3);
        Node p2 = new Node(6);
        Node p3 = new Node(1);
        Node p4 = new Node(4);

        // Linking nodes
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;

        // Tree looks like:
        //      5
        //     / \
        //    3   6
        //   / \
        //  1   4  

        // Insert new node
        insert(p, 16);

        // Print inserted node
        System.out.println("Inserted node: " + p.right.right.data);

        // Traversals
        System.out.println("Preorder:");
        preOrder(p);
        System.out.println("\nInorder:");
        inOrder(p);
        System.out.println("\nPostorder:");
        postOrder(p);

        // Search
        Node found = searchIter(p, 4);
        if (found != null) {
            System.out.println("\nFound node with value: " + found.data);
        } else {
            System.out.println("\nNode not found");
        }

        // Check BST
        System.out.println("Is BST? " + isBST(p));
    }
}
