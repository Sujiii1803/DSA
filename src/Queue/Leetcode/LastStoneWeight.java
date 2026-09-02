package Queue.Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class LastStone {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        // Add all stones to max heap
        for (int n : stones) {
            pq.offer(n);
        }

        // Smash the two heaviest stones
        while (pq.size() > 1) {

            int x = pq.poll();
            int y = pq.poll();

            if (x != y) {
                pq.offer(x - y);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}

public class LastStoneWeight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of stones: ");
        int n = sc.nextInt();

        int[] stones = new int[n];

        System.out.println("Enter the stone weights:");

        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        LastStone obj = new LastStone();

        int result = obj.lastStoneWeight(stones);

        System.out.println("Last stone weight: " + result);

        sc.close();
    }
}