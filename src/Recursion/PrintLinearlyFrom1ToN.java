package Recursion;
import java.util.Scanner;

public class PrintLinearlyFrom1ToN{
    public static void print(int i,int n){
        if( i > n ){
            return;
        }
        System.out.print(i + " ");
        print(i+1,n);
    }
    public static void printUsingBacktracking(int i,int n){
        if( i < 1 ){
            return;
        }
        print(i - 1,n);
        System.out.print(i + " ");

    }
    public static void main( String[] args ){
        Scanner sc = new Scanner( System.in );
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        print(1,n);
        printUsingBacktracking(n,n);

    }
}