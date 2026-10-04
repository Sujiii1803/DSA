package Tree.BST;

import java.util.*;

class BSTIteratorSolution {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIteratorSolution(TreeNode root) {
        pushLeft(root);
    }

    public void pushLeft(TreeNode root) {

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {

        TreeNode node = stack.pop();

        if (node.right != null) {
            pushLeft(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

public class BSTIterator {

    public static void main(String[] args) {

        /*
                  7
                 / \
                3   15
                   /  \
                  9    20

            Inorder:
            3 7 9 15 20

            next()      → 3
            next()      → 7
            hasNext()   → true
            next()      → 9
            next()      → 15
            next()      → 20
            hasNext()   → false
        */

        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(3);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIteratorSolution iterator =
                new BSTIteratorSolution(root);

        while (iterator.hasNext()) {

            System.out.println(
                    "Next: " + iterator.next()
            );
        }
    }
}