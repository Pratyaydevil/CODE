import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class circular {
    Node last = null;

    // Insert into Circular Linked List
    void insert(String data) {
        Node newNode = new Node(data);

        // First node
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    // Display list
    void display() {
        System.out.println("Circular Linked List - Running Applications");

        if (last == null) {
            System.out.println("No applications to iterate.");
            return;
        }

        System.out.println("Running Applications:");

        Node temp = last.next;

        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != last.next);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Main cll = new Main();

        while (true) {
            String app = sc.nextLine();

            if (app.equals("exit")) {
                break;
            }

            cll.insert(app);
        }

        cll.display();
    }
}
