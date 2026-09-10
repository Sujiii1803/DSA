package Hashing;


import java.util.*;

class ContiguousArraySolution {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {

                int len = i - map.get(sum);

                maxLen = Math.max(len, maxLen);

            } else {

                map.put(sum, i);
            }
        }

        return maxLen;
    }
}

public class ContiguousArray {

    public static void main(String[] args) {

        ContiguousArraySolution solution = new ContiguousArraySolution();

        int[] nums = {0, 1, 0, 1};

        int result = solution.findMaxLength(nums);

        System.out.println("Maximum length: " + result);
    }
}

