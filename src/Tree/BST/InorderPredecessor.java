package Tree.BST;

class InorderPredecessorSolution {

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {

        TreeNode predecessor = null;

        while (root != null) {

            if (p.val > root.val) {

                // Current root is a possible predecessor
                predecessor = root;

                root = root.right;
            }

            else {

                // Need a smaller value
                root = root.left;
            }
        }

        return predecessor;
    }
}

public class InorderPredecessor {

    public static void main(String[] args) {

        /*
                  5
                 / \
                3   7
               / \ / \
              2  4 6  8

            Find inorder predecessor of 6.

            Inorder:
            2 3 4 5 6 7 8

            Predecessor of 6 = 5
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode p = root.right.left;

        InorderPredecessorSolution solution =
                new InorderPredecessorSolution();

        TreeNode result =
                solution.inorderPredecessor(root, p);

        if (result != null) {
            System.out.println(
                    "Inorder Predecessor: " + result.val
            );
        } else {
            System.out.println("No Inorder Predecessor");
        }
    }
}