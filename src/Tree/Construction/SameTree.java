package Tree.Construction;

class SameTreeSolution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}

public class SameTree {

    public static void main(String[] args) {

        /*
                Tree 1:              Tree 2:

                   1                     1
                  / \                   / \
                 2   3                 2   3

                Both trees are the same.
        */

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        SameTreeSolution solution = new SameTreeSolution();

        boolean result = solution.isSameTree(p, q);

        System.out.println("Are the trees same? " + result);
    }
}