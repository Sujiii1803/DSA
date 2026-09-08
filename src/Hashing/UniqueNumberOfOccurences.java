package Hashing;

import java.util.*;

class UniqueNumberOfOccurencesSolution {
    public boolean uniqueOccurrences(int[] arr) {

        // Count frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Check whether frequencies are unique
        Set<Integer> set = new HashSet<>();

        for (int frequency : map.values()) {

            if (set.contains(frequency)) {
                return false;
            }

            set.add(frequency);
        }

        return true;
    }
}

public class UniqueNumberOfOccurences {
    public static void main(String[] args) {

        UniqueNumberOfOccurencesSolution solution = new UniqueNumberOfOccurencesSolution();

        int[] arr1 = {1, 2, 2, 1, 1, 3};
        int[] arr2 = {1, 2};
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};

        System.out.println(solution.uniqueOccurrences(arr1));
        System.out.println(solution.uniqueOccurrences(arr2));
        System.out.println(solution.uniqueOccurrences(arr3));
    }
}

