package Tree.Properties;

import java.util.*;

class DiameterSolution {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Diameter passing through this node
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterSolution solution = new DiameterSolution();

        int result = solution.diameterOfBinaryTree(root);

        System.out.println("Diameter of Binary Tree: " + result);
    }
}