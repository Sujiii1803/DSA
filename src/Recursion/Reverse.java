package Recursion;

import java.util.Scanner;

public class Reverse {
    public static int rev( int n,int r){
        if( n == 0 ){
            return r;
        }
        return rev( n / 10, r * 10 + n % 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = sc.nextInt();
        System.out.print(rev(n,0));
    }
}
