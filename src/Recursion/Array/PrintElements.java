package Recursion.Array;

import java.util.Scanner;

public class PrintElements {
    public static void print( int[] arr, int n){
        if( n == arr.length ){
            return;
        }
        System.out.print(arr[n] + " ");
        print( arr, n + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        print(arr, 0);
     }

}
