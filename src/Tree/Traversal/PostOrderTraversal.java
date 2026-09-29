package Tree.Traversal;

import java.util.*;

class PostOrderTraversalSolution {

    // Recursive
    public List<Integer> postorderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    // Iterative - Two Stacks
    public List<Integer> postorderTwoStacks(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }

    // Iterative - One Stack
    public List<Integer> postorderOneStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.peek();

            if (node.right != null && lastVisited != node.right) {
                current = node.right;
            } else {
                result.add(node.val);
                lastVisited = stack.pop();
            }
        }

        return result;
    }
}

public class PostOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        PostOrderTraversalSolution solution =
                new PostOrderTraversalSolution();

        List<Integer> recursiveResult =
                solution.postorderRecursive(root);

        List<Integer> twoStackResult =
                solution.postorderTwoStacks(root);

        List<Integer> oneStackResult =
                solution.postorderOneStack(root);

        System.out.println("Recursive Postorder: " + recursiveResult);
        System.out.println("Two Stack Postorder: " + twoStackResult);
        System.out.println("One Stack Postorder: " + oneStackResult);
    }
}