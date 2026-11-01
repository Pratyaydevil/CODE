class Node{

    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}



public class linkTraversal {

   
    public static void linkedListTraversal(Node ptr){

        while(ptr!=null){

            System.out.println("Element: " + ptr.data);
            ptr = ptr.next;
        }
    }

    public static void main(String[]args){

        Node head=new Node(7);
        Node second=new Node(11);
        Node third =new Node(41);
        Node fourth=new Node(66);
         head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null; // End of list

        // Traverse and print
        linkedListTraversal(head);
    }
    
}
