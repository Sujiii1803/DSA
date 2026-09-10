package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {


    // APPROACH 1: BRUTE FORCE
    public static boolean bruteForce(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                // Length of subarray = j - i + 1
                if (j - i + 1 >= 2 && sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    // APPROACH 2: PREFIX SUM + BRUTE FORCE
    public static boolean prefixSumApproach(int[] nums, int k) {

        int n = nums.length;

        // Create prefix sum array
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Check every possible subarray
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int sum;

                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }

                if (sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    // APPROACH 3: PREFIX SUM + HASHMAP
    public static boolean optimizedApproach(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Represents prefix sum 0 before the array starts
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Calculate prefix sum
            sum += nums[i];

            // Calculate remainder
            int rem = sum % k;

            // If this remainder was already seen
            if (map.containsKey(rem)) {

                int prev = map.get(rem);

                // Check subarray length
                if (i - prev >= 2) {
                    return true;
                }

            } else {

                // Store only the first occurrence
                map.put(rem, i);
            }
        }

        return false;
    }
public static void main(String[] args) {

        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;


        boolean result1 = bruteForce(nums, k);

        System.out.println("Approach 1 - Brute Force:");
        System.out.println(result1);


        boolean result2 = prefixSumApproach(nums, k);

        System.out.println("\nApproach 2 - Prefix Sum + Brute Force:");
        System.out.println(result2);


        boolean result3 = optimizedApproach(nums, k);

        System.out.println("\nApproach 3 - Prefix Sum + HashMap:");
        System.out.println(result3);
    }
}

