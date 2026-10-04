package Tree.BST;

class FloorBSTSolution {

    public int floor(TreeNode root, int x) {

        int answer = -1;

        while (root != null) {

            // Exact value found
            if (root.val == x) {
                return root.val;
            }

            // Root is smaller → possible floor
            if (root.val < x) {
                answer = root.val;
                root = root.right;
            }

            // Root is greater → go left
            else {
                root = root.left;
            }
        }

        return answer;
    }
}

public class FloorBST {

    public static void main(String[] args) {

        /*
                  8
                 / \
                4   12
               / \  / \
              2  6 10 14

            Find floor of x = 11

            Values <= 11:
            2 4 6 8 10

            Floor = 10
        */

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int x = 11;

        FloorBSTSolution solution = new FloorBSTSolution();

        int result = solution.floor(root, x);

        System.out.println("Floor of " + x + ": " + result);
    }
}