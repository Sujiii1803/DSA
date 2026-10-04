package Tree.BST;

class KthSmallestSolution {

    int count = 0;
    int answer = -1;

    public int kthSmallest(TreeNode root, int k) {

        inOrder(root, k);

        return answer;
    }

    public void inOrder(TreeNode root, int k) {

        if (root == null) {
            return;
        }

        inOrder(root.left, k);

        count++;

        if (count == k) {
            answer = root.val;
            return;
        }

        inOrder(root.right, k);
    }
}

public class KthSmallest {

    public static void main(String[] args) {

        /*
                  5
                 / \
                3   7
               / \ / \
              2  4 6  8

            Inorder:
            2 3 4 5 6 7 8

            k = 3

            3rd Smallest = 4
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int k = 3;

        KthSmallestSolution solution = new KthSmallestSolution();

        int result = solution.kthSmallest(root, k);

        System.out.println(
                "Kth Smallest Element: " + result
        );
    }
}