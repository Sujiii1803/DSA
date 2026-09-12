package Recursion.Array;

import java.util.Scanner;

public class CheckSorted {
    public static boolean isSorted( int[] arr,int index){
            if( index == arr.length-1){
                return true;
            }
            if( arr[index] > arr[index+1]){
                return false;
            }
            return isSorted(arr,index+1);
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
        System.out.println(isSorted(arr,0));

    }
}
