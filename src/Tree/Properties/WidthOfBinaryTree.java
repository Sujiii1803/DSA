package Tree.Properties;

import java.util.*;

class WidthOfBinaryTreeSolution {

    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            long firstIndex = q.peek().index;
            long lastIndex = 0;

            for (int i = 0; i < size; i++) {

                Pair current = q.poll();

                TreeNode node = current.node;
                long index = current.index;

                index = index - firstIndex;

                lastIndex = index;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * index + 2));
                }
            }

            int width = (int) lastIndex + 1;

            maxWidth = Math.max(width, maxWidth);
        }

        return maxWidth;
    }
}

public class WidthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        WidthOfBinaryTreeSolution solution =
                new WidthOfBinaryTreeSolution();

        int result = solution.widthOfBinaryTree(root);

        System.out.println("Maximum Width: " + result);
    }
}