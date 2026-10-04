package Tree.BST;

class CeilingBSTSolution {

    public int ceiling(TreeNode root, int x) {

        int answer = -1;

        while (root != null) {

            // Exact value found
            if (root.val == x) {
                return root.val;
            }

            // Root is greater → possible ceiling
            if (root.val > x) {
                answer = root.val;
                root = root.left;
            }

            // Root is smaller → go right
            else {
                root = root.right;
            }
        }

        return answer;
    }
}

public class CeilingBST {

    public static void main(String[] args) {

        /*
                  8
                 / \
                4   12
               / \  / \
              2  6 10 14

            Find ceiling of x = 11

            Values >= 11:
            12 14

            Ceiling = 12
        */

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int x = 11;

        CeilingBSTSolution solution = new CeilingBSTSolution();

        int result = solution.ceiling(root, x);

        System.out.println("Ceiling of " + x + ": " + result);
    }
}