package Tree.Views;

import java.util.*;

class RightSideViewSolution {

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return result;
    }
}

public class RightSideView {

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
                \   \
                 5   4

            Right Side View = [1, 3, 4]
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightSideViewSolution solution =
                new RightSideViewSolution();

        List<Integer> result = solution.rightSideView(root);

        System.out.println("Right Side View: " + result);
    }
}