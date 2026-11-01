class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class circularlinkedlist {

    // Traversal
    public static void linkedListTraversal(Node head) {
        if (head == null) return;
        Node ptr = head;
        do {
            System.out.println("Element is " + ptr.data);
            ptr = ptr.next;
        } while (ptr != head);
    }

    // Insert at first
    public static Node insertAtFirst(Node head, int data) {
        Node ptr = new Node(data);

        if (head == null) {
            ptr.next = ptr; // points to itself
            return ptr;
        }

        Node p = head;
        while (p.next != head) {
            p = p.next;
        }
        // At this point p points to the last node
        p.next = ptr;
        ptr.next = head;
        head = ptr;
        return head;
    }

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(4);
        Node second = new Node(3);
        Node third = new Node(6);
        Node fourth = new Node(1);

        // Link nodes circularly
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = head; // circular link

        System.out.println("Circular linked list before insertion:");
        linkedListTraversal(head);

        head = insertAtFirst(head, 99);

        System.out.println("\nCircular linked list after insertion:");
        linkedListTraversal(head);
    }
}
