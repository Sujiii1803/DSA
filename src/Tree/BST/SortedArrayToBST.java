package Tree.BST;

class SortedArrayToBSTSolution {

    public TreeNode sortedArrayToBST(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, left, mid - 1);

        root.right = build(nums, mid + 1, right);

        return root;
    }
}

public class SortedArrayToBST {

    public static void main(String[] args) {

        /*
            Sorted Array:

            [-10, -3, 0, 5, 9]

            Constructed Height-Balanced BST:

                   0
                  / \
                -3   9
                /   /
              -10   5
        */

        int[] nums = {-10, -3, 0, 5, 9};

        SortedArrayToBSTSolution solution =
                new SortedArrayToBSTSolution();

        TreeNode root = solution.sortedArrayToBST(nums);

        System.out.println("Root: " + root.val);
        System.out.println("Left: " + root.left.val);
        System.out.println("Right: " + root.right.val);
    }
}