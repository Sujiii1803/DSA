package Hashing;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {

        int m = s.length();
        int n = t.length();

        if (m != n) {
            return false;
        }

        /*
          APPROACH 1: Array
         
          int[] mapS = new int[256];
          int[] mapT = new int[256];
         
          for (int i = 0; i < m; i++) {
         
              char ch1 = s.charAt(i);
              char ch2 = t.charAt(i);
         
              if (mapS[ch1] != mapT[ch2]) {
                  return false;
              }
         
              mapS[ch1] = i + 1;
              mapT[ch2] = i + 1;
          }
         
          return true;
         */


        // APPROACH 2: HashMap

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < m; i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // Check s -> t mapping
            if (mapS.containsKey(ch1) && mapS.get(ch1) != ch2) {
                return false;
            }

            // Check t -> s mapping
            if (mapT.containsKey(ch2) && mapT.get(ch2) != ch1) {
                return false;
            }

            // Store the mappings
            mapS.put(ch1, ch2);
            mapT.put(ch2, ch1);
        }

        return true;
    }


    public static void main(String[] args) {

        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        String s3 = "paper";
        String t3 = "title";

        String s4 = "ab";
        String t4 = "cc";

        System.out.println("Test Case 1: " + isIsomorphic(s1, t1));
        System.out.println("Test Case 2: " + isIsomorphic(s2, t2));
        System.out.println("Test Case 3: " + isIsomorphic(s3, t3));
        System.out.println("Test Case 4: " + isIsomorphic(s4, t4));
    }
}
