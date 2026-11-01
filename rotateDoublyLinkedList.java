import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class rotateDoublyLinkedList {

    static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    static Node rotateClockwise(Node head, int k, int n) {

        if (head == null || k == 0)
            return head;

        k = k % n;

        Node tail = head;

        while (tail.next != null)
            tail = tail.next;

        // Make circular
        tail.next = head;
        head.prev = tail;

        int steps = n - k;
        Node newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;

        // Break circular link
        newTail.next = null;
        newHead.prev = null;

        return newHead;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null)
                System.out.print(" ");

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
          
        for (int i = 0; i < n; i++) {
            head = insert(head, sc.nextInt());
        }

        int k = sc.nextInt();

        head = rotateClockwise(head, k, n);

        display(head);
    }
}