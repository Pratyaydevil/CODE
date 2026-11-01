class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListInsertion {

    // Traversal
    public static void linkedListTraversal(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.println("Element: " + ptr.data);
            ptr = ptr.next;
        }
    }

    // Case 1: Insert at first
    public static Node insertAtFirst(Node head, int data) {
        Node ptr = new Node(data);
        ptr.next = head;
        return ptr;
    }

    // Case 2: Insert at index
    public static Node insertAtIndex(Node head, int data, int index) {
        if (index == 0) {
            return insertAtFirst(head, data);
        }
        Node ptr = new Node(data);
        Node p = head;
        int i = 0;
        while (i != index - 1 && p != null) {
            p = p.next;
            i++;
        }
        if (p != null) {
            ptr.next = p.next;
            p.next = ptr;
        }
        return head;
    }

    // Case 3: Insert at end
    public static Node insertAtEnd(Node head, int data) {
        Node ptr = new Node(data);
        if (head == null) return ptr;
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = ptr;
        return head;
    }

    // Case 4: Insert after a given node
    public static Node insertAfterNode(Node head, Node prevNode, int data) {
        if (prevNode == null) return head;
        Node ptr = new Node(data);
        ptr.next = prevNode.next;
        prevNode.next = ptr;
        return head;
    }

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(7);
        Node second = new Node(11);
        Node third = new Node(41);
        Node fourth = new Node(66);

        // Link nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        System.out.println("Linked list before insertion:");
        linkedListTraversal(head);

        // head = insertAtFirst(head, 56);
        // head = insertAtIndex(head, 56, 1);
        // head = insertAtEnd(head, 56);
        head = insertAfterNode(head, third, 45);

        System.out.println("\nLinked list after insertion:");
        linkedListTraversal(head);
    }
}
