package Tree.Paths;

import java.util.*;

class PathSumSolution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return isequal(root, targetSum, 0);
    }

    public boolean isequal(TreeNode root, int target, int sum) {

        if (root == null) {
            return false;
        }

        sum += root.val;

        if (sum == target && root.left == null && root.right == null) {
            return true;
        }

        return isequal(root.left, target, sum)
                || isequal(root.right, target, sum);
    }
}

public class PathSum {

    public static void main(String[] args) {

        /*
                 5
                / \
               4   8
              /   / \
             11  13  4
            /  \      \
           7    2      1

            Target Sum = 22

            Path:
            5 -> 4 -> 11 -> 2

            5 + 4 + 11 + 2 = 22

            Result = true
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        PathSumSolution solution = new PathSumSolution();

        boolean result = solution.hasPathSum(root, targetSum);

        System.out.println("Has Path Sum " + targetSum + ": " + result);
    }
}