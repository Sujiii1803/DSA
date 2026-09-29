package Recursion.leetcode;

public class FirstBadVersion_278 {

    static class Solution extends VersionControl {

        public int firstBadVersion(int n) {
            return binarySearch(1, n);
        }

        private int binarySearch(int left, int right) {

            if (left > right) {
                return left;
            }

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid is bad, so first bad could be mid or before it
                return binarySearch(left, mid - 1);
            }

            // mid is good, so first bad must be after mid
            return binarySearch(mid + 1, right);
        }
    }

    static class VersionControl {

        private int badVersion = 4;

        boolean isBadVersion(int version) {
            return version >= badVersion;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 5;

        int result = solution.firstBadVersion(n);

        System.out.println("First bad version: " + result);
    }
}
