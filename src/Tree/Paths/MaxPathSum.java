package Tree.Paths;

class MaxPathSumSolution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        gain(root);

        return max;
    }

    public int gain(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, gain(root.left));
        int right = Math.max(0, gain(root.right));

        int currentPath = left + root.val + right;

        max = Math.max(max, currentPath);

        return root.val + Math.max(left, right);
    }
}


public class MaxPathSum {

    public static void main(String[] args) {

        /*
                  -10
                  / \
                 9  20
                   /  \
                  15   7

            Maximum Path:

            15 -> 20 -> 7

            Sum = 42
        */

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSumSolution solution = new MaxPathSumSolution();

        int result = solution.maxPathSum(root);

        System.out.println(
                "Maximum Path Sum: " + result
        );
    }
}