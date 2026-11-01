import java.util.*;


class Node{

    int val;
    Node next;
    Node (int val){
        this.val=val;
        this.next=null;
    }
}

public class loop{

    public static boolean hasLoop(Node head){

        Node slow=head;
        Node fast=head;

        while(fast!=null&&fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;

            }
        }
        return false;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input for number of nodes
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head=null,tail=null;

        for(int i=0;i<n;i++){
             System.out.print("Enter value for node " + (i+1) + ": ");

             int val=sc.nextInt();

             Node newNode=new Node(val);
             if(head==null){
                head=newNode;
                tail=newNode;

             }else{
                tail.next=newNode;
                tail=newNode;
             }

        }
         System.out.print("Do you want to create a loop? (yes=1 / no=0): ");
        int choice = sc.nextInt();
        if(choice==1){
             System.out.print("Enter position to connect last node (1 to " + n + "): ");
            int pos = sc.nextInt();
             Node loopNode = head;
            for (int i = 1; i < pos; i++) {
                loopNode = loopNode.next;
            }
            tail.next = loopNode; 

            
        }
         if (hasLoop(head)) {
            System.out.println("Loop detected in the linked list!");
        } else {
            System.out.println("No loop detected.");
        }

        sc.close();

    }
}