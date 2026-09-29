package Recursion.leetcode;


public class SearchInsert_35 {

    static class Solution {

        public int searchInsert(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        public static int binarySearch(int[] arr, int left, int right, int target) {

            // Base case
            if (left > right) {
                return left;
            }

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (target < arr[mid]) {
                return binarySearch(arr, left, mid - 1, target);
            }

            return binarySearch(arr, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;

        System.out.println("Result 1: "
                + solution.searchInsert(nums1, target1));

        // Example 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;

        System.out.println("Result 2: "
                + solution.searchInsert(nums2, target2));

        // Example 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;

        System.out.println("Result 3: "
                + solution.searchInsert(nums3, target3));

        // Example 4
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;

        System.out.println("Result 4: "
                + solution.searchInsert(nums4, target4));
    }
}