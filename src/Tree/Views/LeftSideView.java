package Tree.Properties;

import java.util.*;

class LeftSideViewSolution {

    public List<Integer> leftSideView(TreeNode root) {

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

                // First node of each level
                if (i == 0) {
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

public class LeftSideView {

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
                \   \
                 5   4

            Left Side View = [1, 2, 5]
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        LeftSideViewSolution solution =
                new LeftSideViewSolution();

        List<Integer> result = solution.leftSideView(root);

        System.out.println("Left Side View: " + result);
    }
}