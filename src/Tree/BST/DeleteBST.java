package Tree.BST;

class DeleteBSTSolution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        else {

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            root.val = successor.val;

            root.right = deleteNode(
                    root.right,
                    successor.val
            );
        }

        return root;
    }
}

public class DeleteBST {

    public static void main(String[] args) {

        /*
                  5
                 / \
                3   6
               / \   \
              2   4   7

            Delete value = 3

            Inorder Successor = 4

            Result:

                  5
                 / \
                4   6
               /     \
              2       7
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        int key = 3;

        DeleteBSTSolution solution = new DeleteBSTSolution();

        TreeNode result = solution.deleteNode(root, key);

        System.out.println("Deleted Value: " + key);
        System.out.println("Root: " + result.val);
    }
}