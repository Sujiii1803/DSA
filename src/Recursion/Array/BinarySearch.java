package Recursion.Array;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int left, int right, int target){
        if( left > right){
            return -1;
        }
        int mid = (left+right)/2;
        if( arr[mid] == target){
            return mid;
        }
        else if( target < arr[mid] ){
                return binarySearch(arr, left, mid-1, target);
        }
        return binarySearch(arr, mid + 1, right, target);
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
        System.out.println("Enter target : ");
        int target = sc.nextInt();
        System.out.println(binarySearch(arr, 0, arr.length-1, target));
    }
}
