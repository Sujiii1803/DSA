package Tree.Construction;

class BuildTreeSolution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(
                preorder,
                inorder,
                0,
                preorder.length - 1,
                0,
                inorder.length - 1
        );
    }

    public TreeNode build(
            int[] preorder,
            int[] inorder,
            int preStart,
            int preEnd,
            int inStart,
            int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        int rootValue = preorder[preStart];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inStart;

        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;

        root.left = build(
                preorder,
                inorder,
                preStart + 1,
                preStart + leftSize,
                inStart,
                rootIndex - 1
        );

        root.right = build(
                preorder,
                inorder,
                preStart + leftSize + 1,
                preEnd,
                rootIndex + 1,
                inEnd
        );

        return root;
    }
}

public class BuildTree {

    public static void main(String[] args) {

        /*
            Preorder:  3 9 20 15 7
            Inorder:   9 3 15 20 7

            Constructed Tree:

                  3
                 / \
                9   20
                   /  \
                  15   7
        */

        int[] preorder = {3, 9, 20, 15, 7};

        int[] inorder = {9, 3, 15, 20, 7};

        BuildTreeSolution solution = new BuildTreeSolution();

        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println("Root: " + root.val);
        System.out.println("Left: " + root.left.val);
        System.out.println("Right: " + root.right.val);
    }
}