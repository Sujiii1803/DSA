package Tree.Paths;

import java.util.*;

class PathSumIIISolution {

    // =========================================================
    // Approach 1: DFS from Every Node
    // Time: O(N²) worst case
    // Space: O(H)
    // =========================================================

    public int pathSumBruteForce(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        // Start a path from the current node
        // and also try every node in left and right subtrees
        return countPaths(root, targetSum)
                + pathSumBruteForce(root.left, targetSum)
                + pathSumBruteForce(root.right, targetSum);
    }

    private int countPaths(TreeNode root, long target) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        // Current node itself completes a valid path
        if ( root.val == target ) {
            count++;
        }

        // Continue the path downward
        count += countPaths(root.left, target - root.val);
        count += countPaths(root.right, target - root.val);

        return count;
    }


    // =========================================================
    // Approach 2: Prefix Sum + HashMap
    // Time: O(N)
    // Space: O(H)
    // =========================================================

    public int pathSumPrefixSum(TreeNode root, int targetSum) {

        HashMap<Long, Integer> map = new HashMap<>();

        // Prefix sum 0 exists once before starting the tree
        map.put(0L, 1);

        return prefixSumDFS(root, targetSum, 0, map);
    }

    private int prefixSumDFS(
            TreeNode root,
            int target,
            long sum,
            HashMap<Long, Integer> map) {

        if (root == null) {
            return 0;
        }

        // Calculate current prefix sum
        sum += root.val;

        // Previous prefix sum needed:
        // currentSum - previousSum = target
        long required = sum - target;

        // Number of valid paths ending at current node
        int count = map.getOrDefault(required, 0);

        // Store current prefix sum
        map.put(
                sum,
                map.getOrDefault(sum, 0) + 1
        );

        // Explore left and right subtrees
        count += prefixSumDFS(
                root.left,
                target,
                sum,
                map
        );

        count += prefixSumDFS(
                root.right,
                target,
                sum,
                map
        );

        // Backtracking:
        // Current prefix sum should not be used
        // while exploring another branch
        map.put(sum, map.get(sum) - 1);

        return count;
    }
}


public class PathSumIII {

    public static void main(String[] args) {

        /*
                  10
                 /  \
                5   -3
               / \    \
              3   2    11
             / \   \
            3  -2   1

            Target Sum = 8

            Valid paths:

            5 -> 3 = 8
            5 -> 2 -> 1 = 8
            -3 -> 11 = 8

            Total = 3
        */

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);

        int targetSum = 8;

        PathSumIIISolution solution = new PathSumIIISolution();


        // =====================================================
        // Approach 1: DFS from Every Node
        // =====================================================

        int result1 =
                solution.pathSumBruteForce(root, targetSum);

        System.out.println(
                "Approach 1 - DFS from Every Node: "
                        + result1
        );


        // =====================================================
        // Approach 2: Prefix Sum + HashMap
        // =====================================================

        int result2 =
                solution.pathSumPrefixSum(root, targetSum);

        System.out.println(
                "Approach 2 - Prefix Sum + HashMap: "
                        + result2
        );
    }
}