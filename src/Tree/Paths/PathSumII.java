package Tree.Paths;

import java.util.*;

class PathSumIISolution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        path(result, root, targetSum, 0, current);

        return result;
    }

    public void path(
            List<List<Integer>> result,
            TreeNode root,
            int target,
            int sum,
            List<Integer> current) {

        if (root == null) {
            return;
        }

        current.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null) {

            if (sum == target) {
                result.add(new ArrayList<>(current));
            }
        }

        if (root.left != null) {
            path(result, root.left, target, sum, current);
        }

        if (root.right != null) {
            path(result, root.right, target, sum, current);
        }

        current.remove(current.size() - 1);
    }
}

public class PathSumII {

    public static void main(String[] args) {

        /*
                  5
                 / \
                4   8
               /   / \
              11  13  4
             / \      / \
            7   2    5   1

            Target Sum = 22

            Valid paths:

            5 -> 4 -> 11 -> 2 = 22
            5 -> 8 -> 4 -> 5 = 22
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        PathSumIISolution solution = new PathSumIISolution();

        List<List<Integer>> result =
                solution.pathSum(root, targetSum);

        System.out.println("Paths with Sum " + targetSum + ": " + result);
    }
}