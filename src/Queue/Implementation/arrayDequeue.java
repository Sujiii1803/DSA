package Queue.Implementation;

import java.util.Queue;
import java.util.ArrayDeque;

public class arrayDequeue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.isEmpty());

        q.poll();
        q.poll();
        q.poll();
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.isEmpty());

    }
}
