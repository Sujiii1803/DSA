package Tree.Traversal;

import java.util.*;

class LevelOrderTraversalSolution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root);
        return result;
    }

    public void levelOrder(List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                level.add(current.val);

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }

            result.add(level);
        }
       // Collections.reverse(result); --> reverse order leaft to root
    }
}

public class LevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        LevelOrderTraversalSolution solution =
                new LevelOrderTraversalSolution();

        List<List<Integer>> result =
                solution.levelOrder(root);

        System.out.println("Level Order: " + result);
    }
}