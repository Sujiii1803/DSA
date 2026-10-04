package Tree.BST;

class SearchBSTSolution {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        return searchBST(root.right, val);
    }
}

public class SearchBST {

    public static void main(String[] args) {

        /*
                  4
                 / \
                2   7
               / \
              1   3

            Search value = 2

            Result:

                  2
                 / \
                1   3
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;

        SearchBSTSolution solution = new SearchBSTSolution();

        TreeNode result = solution.searchBST(root, val);

        if (result != null) {
            System.out.println("Found Node: " + result.val);
        } else {
            System.out.println("Node not found");
        }
    }
}