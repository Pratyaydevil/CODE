import java.util.*;

class Node{

    int data;
    Node left,right;

    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;

    }
}

public class BSTdeletion {

    // Deletion in BST
   public static void preOrder(Node root){

    if(root!=null){

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
   }
   public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Inorder Traversal
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
private static Node prev=null;

public static boolean isBST(Node root){

    if(root!=null){

        if(!isBST(root.left))return false;
        if(prev!=null&&root.data<=prev.data)return false;
        prev=root;
        return isBST(root.right);

    }
    return true;

}
public static Node searchIter(Node root, int key) {
        while (root != null) {
            if (key == root.data) return root;
            else if (key < root.data) root = root.left;
            else root = root.right;
        }
        return null;
    }


 public static Node insert(Node root,int key){
        if(root==null) return new Node(key);
    if(key<root.data){
        root.left=insert(root.left,key);
    }

    else if(key>root.data){
        root.right=insert(root.right,key);
    }
    return root;
    }
public static Node inOrderPredecessor(Node root){

    root=root.left;

    while(root.right!=null)root=root.right;

    return root;}

    public static Node deleteNode(Node root,int value){


        if(root==null)return null;
        if(root.left==null&&root.right==null){
            return null;

        }
        if(value<root.data)root.left=deleteNode(root.left,value);
        else if(value>root.data)root.right=deleteNode(root.right,value);
        else{

            Node inOrderPredecessor=inOrderPredecessor(root);
            root.data=inOrderPredecessor.data;
            root.left=deleteNode(root.left,inOrderPredecessor.data);

        }return root;
    }

public static void main(String[] args) {
        // Constructing the root node
        Node p = new Node(5);
        Node p1 = new Node(3);
        Node p2 = new Node(6);
        Node p3 = new Node(1);
        Node p4 = new Node(4);

        // Linking the root node with left and right children
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;

        // Inorder before deletion
        inOrder(p);
        System.out.println();

        // Delete node with value 3
        deleteNode(p, 3);

        // Inorder after deletion
        inOrder(p);
    }










}
