import java.util.*;

class Node {

    int key;
    Node left,right;

    int height;
    Node(int key){

        this.key=key;
        this.left = null;
        this. right  = null;
        this.height = 1;
    }

    
}
    public class AVLTree{
            int getHeight(Node n) {
        if (n == null) return 0;
        return n.height;
    }
         
    int getBalanceFactor(Node n) {
        if (n == null) return 0;
        return getHeight(n.left) - getHeight(n.right);
    }
    

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y){

        Node  x=y.left;
        Node T2=x.right;

        x.right=y;
        y.left=T2;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;

        // Return new root
        return x;
    }
  Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

        // Return new root
        return y;
    }


     Node insert (Node node,int key){

        if(node ==null)return new Node(key);

        if(key<node.key)node.left=insert(node.left,key);
            else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;




        node.height=1+max(getHeight(node.left), getHeight(node.right));

        int bf = getBalanceFactor(node);
if (bf > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right
        if (bf < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right
        if (bf > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left
        if (bf < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
     }
void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

     public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Node root = null;

        root = tree.insert(root, 1);
        root = tree.insert(root, 2);
        root = tree.insert(root, 4);
        root = tree.insert(root, 5);
        root = tree.insert(root, 6);
        root = tree.insert(root, 3);

        System.out.println("Preorder traversal of AVL tree:");
        tree.preOrder(root);
    }
    }

