package Recursion.Basics;

import java.util.Scanner;

public class Power {
    public static int pow( int a,int b){
        if( b == 0 ){
            return 1;
        }
        return a * pow( a, b -1 );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        System.out.print(pow(2,n));
    }
}
