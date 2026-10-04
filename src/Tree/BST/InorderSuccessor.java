package Tree.BST;

class InorderSuccessorSolution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null) {
            return null;
        }

        if (p.val < root.val) {

            TreeNode left = inorderSuccessor(root.left, p);

            if (left != null) {
                return left;
            }

            return root;
        }

        return inorderSuccessor(root.right, p);
    }
}

public class InorderSuccessor {

    public static void main(String[] args) {

        /*
                  5
                 / \
                3   7
               / \ / \
              2  4 6  8

            Find inorder successor of 4.

            Inorder:
            2 3 4 5 6 7 8

            Successor of 4 = 5
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left.right;

        InorderSuccessorSolution solution =
                new InorderSuccessorSolution();

        TreeNode result =
                solution.inorderSuccessor(root, p);

        if (result != null) {
            System.out.println(
                    "Inorder Successor: " + result.val
            );
        } else {
            System.out.println("No Inorder Successor");
        }
    }
}