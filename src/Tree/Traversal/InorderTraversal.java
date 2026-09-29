package Tree.Traversal;

import java.util.*;

class InorderTraversalSolution {

    // Recursive
    public List<Integer> inorderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    // Iterative
    public List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
}

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InorderTraversalSolution solution = new InorderTraversalSolution();

        List<Integer> recursiveResult = solution.inorderRecursive(root);
        List<Integer> iterativeResult = solution.inorderIterative(root);

        System.out.println("Recursive Inorder: " + recursiveResult);
        System.out.println("Iterative Inorder: " + iterativeResult);
    }
}