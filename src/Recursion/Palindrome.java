package Recursion;

import java.util.Scanner;

public class Palindrome {
    public static int reverse(int n, int r){

        if(n == 0){
            return r;
        }

        return reverse(n / 10, r * 10 + n % 10);
    }
    public static boolean check(int n){

        int reversed = reverse(n, 0);

        return n == reversed;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = sc.nextInt();
        System.out.print(check(n));
    }
}
