import java.util.*;

class Node{

    int data;
    Node left;
    Node right;

    Node(int data){

        this.data=data;
        this.left=null;
        this.right=null;

    }
}




public class Binarytree {

    public static Node createNode(int data){
        return new Node(data);

    }
    public static void main(String[]args){
 Node p = createNode(2);
        Node p1 = createNode(1);
        Node p2 = createNode(4);

        // Linking the root node with left and right children
        p.left = p1;
        p.right = p2;

        // Simple output to verify the tree structure
        System.out.println("Root: " + p.data);
        System.out.println("Left Child: " + p.left.data);
        System.out.println("Right Child: " + p.right.data);


    }
    
}
