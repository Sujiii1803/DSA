package Tree.BST;

class InsertBSTSolution {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}

public class InsertBST {

    public static void main(String[] args) {

        /*
                  4
                 / \
                2   7
               / \
              1   3

            Insert value = 5

            Result:

                  4
                 / \
                2   7
               / \ /
              1  3 5
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 5;

        InsertBSTSolution solution = new InsertBSTSolution();

        TreeNode result = solution.insertIntoBST(root, val);

        System.out.println("Inserted Value: " + val);
        System.out.println("Root: " + result.val);
    }
}