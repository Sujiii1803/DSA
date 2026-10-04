package Tree.BST;

class ValidBSTSolution {

    public boolean isValidBST(TreeNode root) {

        return isValid(
                root,
                Long.MIN_VALUE,
                Long.MAX_VALUE
        );
    }

    public boolean isValid(
            TreeNode root,
            long min,
            long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValid(
                root.left,
                min,
                root.val
        ) && isValid(
                root.right,
                root.val,
                max
        );
    }
}

public class ValidBST {

    public static void main(String[] args) {

        /*
                  5
                 / \
                3   7
               / \ / \
              2  4 6  8

            This is a valid BST.
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        ValidBSTSolution solution = new ValidBSTSolution();

        boolean result = solution.isValidBST(root);

        System.out.println("Is Valid BST? " + result);
    }
}