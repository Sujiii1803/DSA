package sorting.Algorithms;
import java.util.*;


public class QuickSort {
    public static void quickSort( int arr[],int low,int high){
        if( low >= high ){
            return;
        }
        int partitionIndex = partition( arr,low,high);
        quickSort( arr,low,partitionIndex-1 );
        quickSort( arr,partitionIndex+1,high );
    }
    public static int partition( int[]arr, int low, int high ){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while( i < j ){
            while( i <= high && arr[i]  <= pivot    ){
                i++;
            }
            while( j >= low && arr[j] > pivot ){
                j--;
            }
            if( i < j ){
                swap(arr,i,j);
            }
        }
        swap(arr, low, j);
        return j;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main( String[] args ){
        int[] arr = { 2,4,9,3,5,6,7,8};
        quickSort(arr,0,arr.length-1);
        System.out.println( Arrays.toString(arr));

    }
}
