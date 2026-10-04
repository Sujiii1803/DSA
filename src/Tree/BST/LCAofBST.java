package Tree.BST;

class LCAofBSTSolution {

    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        while (root != null) {

            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            else {
                return root;
            }
        }

        return null;
    }
}

public class LCAofBST {

    public static void main(String[] args) {

        /*
                  6
                 / \
                2   8
               / \ / \
              0  4 7  9
                / \
               3   5

            Find LCA of p = 2 and q = 8

            LCA = 6
        */

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;
        TreeNode q = root.right;

        LCAofBSTSolution solution = new LCAofBSTSolution();

        TreeNode result =
                solution.lowestCommonAncestor(root, p, q);

        System.out.println(
                "Lowest Common Ancestor: " + result.val
        );
    }
}