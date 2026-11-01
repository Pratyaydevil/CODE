import java.util.Stack;

public class StackPermutation {
    // Function to check if target is a stack permutation of original
    public static boolean isStackPermutation(int[] original, int[] target) {
        if (original.length != target.length) return false;

        Stack<Integer> stack = new Stack<>();
        int i = 0; // pointer for target

        for (int element : original) {
            stack.push(element);

            // Pop while stack top matches target
            while (!stack.isEmpty() && stack.peek() == target[i]) {
                stack.pop();
                i++;
            }
        }

        // If stack is empty, permutation is valid
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        int[] target   = {2, 1, 3};

        boolean result = isStackPermutation(original, target);
        System.out.println("Is it a stack permutation? " + result);

        int[] target2 = {3, 1, 2};
        System.out.println("Is {3,1,2} a stack permutation? " + 
                           isStackPermutation(original, target2));
    }
}

