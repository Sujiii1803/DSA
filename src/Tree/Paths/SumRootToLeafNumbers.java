package Tree.Paths;

class SumRootToLeafNumbersSolution {

    public int sumNumbers(TreeNode root) {

        return sum(root, 0);
    }

    public int sum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return sum(root.left, sum)
                + sum(root.right, sum);
    }
}


public class SumRootToLeafNumbers {

    public static void main(String[] args) {

        /*
                  1
                 / \
                2   3

            Root-to-leaf numbers:

            1 -> 2 = 12
            1 -> 3 = 13

            Sum = 12 + 13 = 25
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        SumRootToLeafNumbersSolution solution =
                new SumRootToLeafNumbersSolution();

        int result = solution.sumNumbers(root);

        System.out.println(
                "Sum of Root-to-Leaf Numbers: " + result
        );
    }
}