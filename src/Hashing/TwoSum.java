package Hashing;

import java.util.HashMap;
import java.util.Arrays;

class TwoSumSolution{

    public int[] twoSum(int[] nums, int target) {

        // Brute force solution -- O(n^2)
        /*
        int x = 0, y = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    x = i;
                    y = j;
                }
            }
        }

        return new int[]{x, y};
        */

        // Optimal solution using HashMap -- O(n)
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int  needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[]{map.get(needed), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}


public class TwoSum {

    public static void main(String[] args) {

        // Test case 1
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSumSolution solution = new TwoSumSolution();

        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}

