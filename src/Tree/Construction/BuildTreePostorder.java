package Tree.Construction;

class BuildTreePostorderSolution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(
                postorder,
                inorder,
                0,
                postorder.length - 1,
                0,
                inorder.length - 1
        );
    }

    public TreeNode build(
            int[] postorder,
            int[] inorder,
            int postStart,
            int postEnd,
            int inStart,
            int inEnd) {

        if (postStart > postEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inStart;

        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;

        root.right = build(
                postorder,
                inorder,
                postStart + leftSize,
                postEnd - 1,
                rootIndex + 1,
                inEnd
        );

        root.left = build(
                postorder,
                inorder,
                postStart,
                postStart + leftSize - 1,
                inStart,
                rootIndex - 1
        );

        return root;
    }
}

public class BuildTreePostorder {

    public static void main(String[] args) {

        /*
            Inorder:    9 3 15 20 7
            Postorder:  9 15 7 20 3

            Constructed Tree:

                  3
                 / \
                9   20
                   /  \
                  15   7
        */

        int[] inorder = {9, 3, 15, 20, 7};

        int[] postorder = {9, 15, 7, 20, 3};

        BuildTreePostorderSolution solution =
                new BuildTreePostorderSolution();

        TreeNode root = solution.buildTree(inorder, postorder);

        System.out.println("Root: " + root.val);
        System.out.println("Left: " + root.left.val);
        System.out.println("Right: " + root.right.val);
    }
}