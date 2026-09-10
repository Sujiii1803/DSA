package streak;

public class CountNodeEqualToAvg_2265{

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    /*
     * ALGORITHM:
     *
     * 1. Use DFS + postorder traversal.
     * 2. We use postorder because we need the information
     *    from the left and right subtrees before processing
     *    the current node.
     *
     * 3. The dfs() method returns:
     *       [sum, count]
     *
     * 4. If the node is null, return [0, 0].
     *
     * 5. Recursively find the left subtree's sum and count.
     *
     * 6. Recursively find the right subtree's sum and count.
     *
     * 7. Calculate:
     *       sum = left sum + right sum + current node value
     *
     *       count = left count + right count + 1
     *
     * 8. Calculate the average:
     *       average = sum / count
     *
     * 9. If the current node's value is equal to the average,
     *    increment ans.
     *
     * 10. Return [sum, count] to the parent node.
     */

    public int[] dfs(TreeNode node) {

        // Base case
        if (node == null) {
            return new int[]{0, 0};
        }

        // Get sum and count of left subtree
        int[] left = dfs(node.left);

        // Get sum and count of right subtree
        int[] right = dfs(node.right);

        // Calculate sum of current subtree
        int sum = left[0] + right[0] + node.val;

        // Calculate number of nodes in current subtree
        int count = left[1] + right[1] + 1;

        // Calculate average
        int avg = sum / count;

        // Check if node value equals average
        if (node.val == avg) {
            ans++;
        }

        // Return sum and count to parent
        return new int[]{sum, count};
    }
    public static void main(String[] args) {
        /*
         * Create this tree:
         *
         *         4
         *        / \
         *       8   5
         *      / \
         *     0   1
         */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(8);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);


        // Create Solution object
        CountNodeEqualToAvg_2265 obj = new CountNodeEqualToAvg_2265();

        // Call the method
        int result = obj.averageOfSubtree(root);

        // Print answer
        System.out.println("Number of nodes = " + result);
    }
}
// TreeNode class
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}