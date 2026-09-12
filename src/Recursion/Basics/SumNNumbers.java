package Recursion.Basics;

import java.util.Scanner;


public class SumNNumbers {
    public static int sum(int n ){
        if( n <= 0 ) return 0;

        return n + sum(n - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Enter a number: ");
        number = input.nextInt();
        System.out.print(sum(number));
    }
}
