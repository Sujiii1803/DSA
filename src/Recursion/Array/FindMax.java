package Recursion.Array;

import java.util.Scanner;

public class FindMax {
    public static int max( int[] arr, int i){
        if( i == arr.length ){
            return arr[0];
        }
        return Math.max( arr[i] , max(arr, i+1 ));
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
        System.out.print( max(arr,0));
    }

}
