package sorting;
import java.util.Arrays;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for( int i = 0; i <= n - 2; i++ ){
            int minIndex = i;
            for( int j = i + 1; j <= n - 1; j++ ){
                if( arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 5};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
