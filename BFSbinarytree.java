import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BFSbinarytree {
    
    // BFS traversal of the tree
    public static void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            // Add left child if exists
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add right child if exists
            if (current.right != null) {
                queue.add(current.right);
            }
        }



        
    }

    public static void main(String[] args) {
        // Constructing a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("BFS (Level Order Traversal):");
        bfs(root);
    }
}
