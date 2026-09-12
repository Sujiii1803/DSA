package Recursion.Array;
import java.util.Scanner;

public class LinearSearch {

        public static int isfound( int[] arr,int target, int index){
              if( index == arr.length){
                  return -1;
              }
              if( arr[index] == target){
                  return index;
              }
              return isfound(arr,target,index + 1);
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
            System.out.println(isfound(arr,target,0));

        }
}


