package Hashing;

import java.util.*;

class IntersectionOfTwoArraysSolution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }

        List<Integer> result = new ArrayList<>();

        for (int n : nums2) {
            if (set.contains(n)) {
                result.add(n);
                set.remove(n);
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}

public class IntersectionOfTwoArrays{
    public static void main(String[] args) {

        IntersectionOfTwoArraysSolution solution = new IntersectionOfTwoArraysSolution();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = solution.intersection(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
}

