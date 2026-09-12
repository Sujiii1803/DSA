package Recursion.Array;

import java.util.Scanner;

public class ReverseAnArray {

    public static void reverse(int[] arr, int left, int right) {

        // Base case
        if (left >= right) {
            return;
        }

        // Swap
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        // Recursive call
        reverse(arr, left + 1, right - 1);
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

        reverse(arr, 0, arr.length - 1);

        System.out.println("Reversed array : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}