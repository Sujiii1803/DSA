package Tree.Construction;

class SymmetricTreeSolution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}

public class SymmetricTree {

    public static void main(String[] args) {

        /*
                 1
                / \
               2   2
              / \ / \
             3  4 4  3

             Symmetric Tree
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTreeSolution solution = new SymmetricTreeSolution();

        boolean result = solution.isSymmetric(root);

        System.out.println("Is the tree symmetric? " + result);
    }
}