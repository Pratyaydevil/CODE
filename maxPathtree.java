// You are using Java

import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
        
    }
}

class maxPathtree{
    static int maxSum=Integer.MIN_VALUE;
    
    static Node build(Scanner sc,int val){
        
        if(val==-1){
            return null;
        }
        Node root=new Node(val);
        int left=sc.nextInt();
        root.left=build(sc,left);
        
        int right=sc.nextInt();
        root.right=build(sc,right);
        
        return root;
        
    }
    
    
    

static int maxPath(Node root){
    if(root==null)
    return 0;
    
    int left=Math.max(0,maxPath(root.left));
    int right =Math.max(0,maxPath(root.right));
    
    maxSum=Math.max(maxSum,left+right+root.data);
    
    return root.data+Math.max(left,right);
}

public static void main(String []args){
    
    Scanner sc= new Scanner(System.in);
    int rootValue=sc.nextInt();
    
    Node root=build(sc,rootValue);
    
    maxPath(root);
    System.out.println("Maximum Path Sum"+maxSum);
}
}