package streak;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Unique3DigitEvenNumberSolution {
    public int totalNumbers(int[] digits) {

        /*
            Since the constraints are small, we can use a brute force approach by simulation.

            - We need to create a set to store the numbers.
            - Run three loops from 0 to n.
            - Apply the following conditions:
                - If the indices are the same, continue.
                - If digits[i] equals 0, continue.
                - If the last digit is not even, continue.
            - Calculate the number and add it to the set.
            - Return the size of the set.
       */
      
        Set<Integer> set = new HashSet<>();

        int n = digits.length;
        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                for( int k = 0; k < n; k++ ){
                    if( i == j || i == k || j == k )
                        continue;

                    if( digits[i] == 0 ){
                        continue;
                    }

                    if( digits[k] % 2 != 0 ){
                        continue;
                    }

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    System.out.print( num + " ");

                    set.add( num );
                }
            }
        }
        System.out.println();
        return set.size();
    }
}
public class Unique3DigitEvenNumber {
    public static void main(String[] args) {
        Unique3DigitEvenNumberSolution solution = new Unique3DigitEvenNumberSolution();
        int[] digits = {1, 2, 3, 0};
        int result = solution.totalNumbers(digits);
        System.out.println("Total unique 3-digit even numbers: " + result);
    }
}