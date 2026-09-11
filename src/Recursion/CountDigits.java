package Recursion;

import java.util.Scanner;

public class CountDigits {
    public static int count(int n){
       if( n == 0 ) {
           return 0;
       }
       return 1 + count( n / 10);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Enter a number: ");
        number = input.nextInt();
        System.out.print(count(number));
    }
}

