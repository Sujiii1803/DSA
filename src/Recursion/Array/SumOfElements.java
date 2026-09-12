package Recursion.Array;

import java.util.Scanner;

public class SumOfElements {
    public static int sum( int[] arr,int index){
        if( index == arr.length){
            return 0;
        }
        return arr[index]+ sum(arr,index+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Sum "+sum(arr,0));
    }
}
