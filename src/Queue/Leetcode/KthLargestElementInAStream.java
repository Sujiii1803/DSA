package Queue.Leetcode;

import java.util.*;

class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int n : nums) {
            pq.offer(n);

            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}

public class KthLargestElementInAStream {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        System.out.print("Enter the elements of the array: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        KthLargest obj = new KthLargest(k, arr);

        System.out.print("Enter the new value: ");
        int val = sc.nextInt();

        System.out.println("Kth largest element: " + obj.add(val));

        sc.close();
    }
}