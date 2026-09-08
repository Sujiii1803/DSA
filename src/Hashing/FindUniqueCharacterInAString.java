package Hashing;

import java.util.*;

class FindUniqueCharacterInAStringSolution {

    // Method 1: Using HashMap
    public int firstUniqCharHashMap(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }


    // Method 2: Using HashMap with normal for loops
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> count =
                new HashMap<Character, Integer>();

        int n = s.length();

        // Build frequency map
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Find first unique character
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}


public class FindUniqueCharacterInAString{

    public static void main(String[] args) {

        FindUniqueCharacterInAStringSolution solution = new FindUniqueCharacterInAStringSolution();

        String s = "leetcode";

        int result1 = solution.firstUniqCharHashMap(s);
        int result2 = solution.firstUniqChar(s);

        System.out.println("Method 1: " + result1);
        System.out.println("Method 2: " + result2);
    }
}
