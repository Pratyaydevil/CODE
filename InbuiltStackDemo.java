import java.util.*;




public class InbuiltStackDemo {




    public static void main(String[]args){



        Stack<Integer>stack=new Stack<>();
stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack after pushes: " + stack);

        // Peek at the top element
        System.out.println("Top element (peek): " + stack.peek());

        // Pop elements
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.empty());

        // Search for an element (returns 1-based position from top, -1 if not found)
        System.out.println("Position of 20 from top: " + stack.search(20));

        // Size of stack
        System.out.println("Current size: " + stack.size());

    }
    
}
