package Hashing;

import java.util.HashMap;

class SubarraySumEqualsKSolution {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int n : nums) {

            sum += n;

            int required = sum - k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        SubarraySumEqualsKSolution obj = new SubarraySumEqualsKSolution();

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = obj.subarraySum(nums, k);

        System.out.println("Number of subarrays: " + result);
    }
}

