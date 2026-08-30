package Queue.Implementation;
import java.util.Collections;
import java.util.PriorityQueue;

public class priorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //for large priority
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        System.out.println("Priority Queue: " + pq);

        System.out.println("Peek: " + pq.peek());

        System.out.println("Poll: " + pq.poll());
        System.out.println("Poll: " + pq.poll());
        System.out.println("Poll: " + pq.poll());

        System.out.println("Is empty: " + pq.isEmpty());
    }
}