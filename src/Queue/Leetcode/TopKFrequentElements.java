package Queue.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count frequency
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 2. Min-heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        // 3. Keep only K most frequent elements
        for (int n : map.keySet()) {

            pq.offer(n);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 4. Create answer
        int[] ans = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
            ans[i] = pq.poll();
            i++;
        }

        return ans;
    }
}

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array:");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter K:");
        int k = sc.nextInt();

        TopKFrequentElements obj = new TopKFrequentElements();

        int[] ans = obj.topKFrequent(arr, k);

        System.out.println("Top K frequent elements:");

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();
    }
}