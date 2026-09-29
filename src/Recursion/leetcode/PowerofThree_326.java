package Recursion.leetcode;

import java.util.Scanner;

public class PowerofThree_326 {

    public static boolean isPowerOfThree(int n) {

        if (n == 1) {
            return true;
        }

        if (n <= 0 || n % 3 != 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        boolean result = isPowerOfThree(n);

        System.out.println(result);

        sc.close();

        //return n > 0 && 1162261467 % n == 0;->optimal
    }
}