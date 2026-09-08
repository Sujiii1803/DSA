package Hashing;

import java.util.HashMap;
import java.util.Map;

class ValidAnagramSolution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Count characters in s
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Decrease counts using t
        for (char ch : t.toCharArray()) {

            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) < 0) {
                return false;
            }
        }

        return true;
    }
}


public class ValidAnagram{

    public static void main(String[] args) {

        ValidAnagramSolution solution = new ValidAnagramSolution();

        // Test Case 1
        String s1 = "anagram";
        String t1 = "nagaram";

        System.out.println(solution.isAnagram(s1, t1));


        // Test Case 2
        String s2 = "rat";
        String t2 = "car";

        System.out.println(solution.isAnagram(s2, t2));


        // Test Case 3
        String s3 = "listen";
        String t3 = "silent";

        System.out.println(solution.isAnagram(s3, t3));
    }
}

