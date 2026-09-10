package Hashing;

import java.util.*;

class FourSumIISolution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store the frequency of every nums1 + nums2 sum
        for (int a : nums1) {
            for (int b : nums2) {

                int sum = a + b;

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Find the required opposite sum from nums3 + nums4
        for (int c : nums3) {
            for (int d : nums4) {

                int sum = c + d;
                int required = -sum;

                if (map.containsKey(required)) {
                    count += map.get(required);
                }
            }
        }

        return count;
    }
}

public class FourSumII{

    public static void main(String[] args) {

        FourSumIISolution solution = new FourSumIISolution();

        // Example 1
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        int result = solution.fourSumCount(nums1, nums2, nums3, nums4);

        System.out.println("Number of tuples: " + result);
    }
}
