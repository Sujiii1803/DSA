package Recursion.Basics;

import java.util.Scanner;

public class SumOfDigits {
    public static int sum( int n){
        if( n == 0 ){
            return 0;
        }
        return n % 10 + sum( n / 10 );

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        System.out.print(sum(n));
    }

}
