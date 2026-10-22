
package sorting.Algorithms;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= n-1; i++) {
            int j = i;

            while (j > 0 && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 8, 2, 6};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
