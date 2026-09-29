package Tree.Properties;

import java.util.*;

class MaxDepthSolution {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}

public class MaximumDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxDepthSolution solution = new MaxDepthSolution();

        int result = solution.maxDepth(root);

        System.out.println("Maximum Depth: " + result);
    }
}