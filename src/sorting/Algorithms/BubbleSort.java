package sorting.Algorithms;


import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for( int i = n-1; i >= 1; i-- ) {
            boolean didSwap = false;
            for( int j = 0 ; j <= i -1; j++ ){
                if( arr[j] > arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }
            if( !didSwap ) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 5};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
