class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class deletionnlinkedlist {

    // Traversal
    public static void linkedListTraversal(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.println("Element: " + ptr.data);
            ptr = ptr.next;
        }
    }

    // Case 1: Delete first node
    public static Node deleteFirst(Node head) {
        if (head == null) return null;
        return head.next; // Java GC handles cleanup
    }

    // Case 2: Delete at index
    public static Node deleteAtIndex(Node head, int index) {
        if (head == null) return null;
        if (index == 0) return deleteFirst(head);

        Node p = head;
        Node q = head.next;
        for (int i = 0; q != null && i < index - 1; i++) {
            p = p.next;
            q = q.next;
        }
        if (q != null) {
            p.next = q.next;
        }
        return head;
    }

    // Case 3: Delete last node
    public static Node deleteAtLast(Node head) {
        if (head == null || head.next == null) return null;
        Node p = head;
        Node q = head.next;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = null;
        return head;
    }

    // Case 4: Delete by value
    public static Node deleteByValue(Node head, int value) {
        if (head == null) return null;
        if (head.data == value) return deleteFirst(head);

        Node p = head;
        Node q = head.next;
        while (q != null && q.data != value) {
            p = p.next;
            q = q.next;
        }
        if (q != null) {
            p.next = q.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(4);
        Node second = new Node(3);
        Node third = new Node(8);
        Node fourth = new Node(1);

        // Link nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        System.out.println("Linked list before deletion:");
        linkedListTraversal(head);

        // head = deleteFirst(head);       // Delete first element
        // head = deleteAtIndex(head, 2);  // Delete at index
        head = deleteAtLast(head);         // Delete last element
        // head = deleteByValue(head, 8);  // Delete by value

        System.out.println("Linked list after deletion:");
        linkedListTraversal(head);
    }
}
