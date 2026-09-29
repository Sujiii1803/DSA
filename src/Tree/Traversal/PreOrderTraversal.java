package Tree.Traversal;

import java.util.*;

class PreOrderTraversalSolution {

    // Recursive
    public List<Integer> preorderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    // Iterative
    public List<Integer> preorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PreOrderTraversalSolution solution = new PreOrderTraversalSolution();

        List<Integer> recursiveResult = solution.preorderRecursive(root);
        List<Integer> iterativeResult = solution.preorderIterative(root);

        System.out.println("Recursive Preorder: " + recursiveResult);
        System.out.println("Iterative Preorder: " + iterativeResult);
    }
}