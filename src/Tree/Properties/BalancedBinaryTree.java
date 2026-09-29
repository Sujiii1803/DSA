package Tree.Properties;

import java.util.*;

class BalancedTreeSolution {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}

public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BalancedTreeSolution solution = new BalancedTreeSolution();

        boolean result = solution.isBalanced(root);

        System.out.println("Is Balanced: " + result);
    }
}