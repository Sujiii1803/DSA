package Recursion.leetcode;
public class Pow_50 {

    static class Solution {

        public double myPow(double x, int n) {

            long power = n;

            if (power < 0) {
                x = 1 / x;
                power = -power;
            }

            return powerHelper(x, power);
        }

        private double powerHelper(double x, long n) {

            // Base case
            if (n == 0) {
                return 1;
            }

            // Recursive call
            double half = powerHelper(x, n / 2);

            // Even power
            if (n % 2 == 0) {
                return half * half;
            }

            // Odd power
            return half * half * x;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example 1
        double x1 = 2.00000;
        int n1 = 10;

        System.out.println("Result 1: " + solution.myPow(x1, n1));

        // Example 2
        double x2 = 2.10000;
        int n2 = 3;

        System.out.println("Result 2: " + solution.myPow(x2, n2));

        // Example 3
        double x3 = 2.00000;
        int n3 = -2;

        System.out.println("Result 3: " + solution.myPow(x3, n3));
    }
}