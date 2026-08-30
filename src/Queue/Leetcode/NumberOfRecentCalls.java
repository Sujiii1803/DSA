package Queue.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> q;
    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        q.offer(t);
        while( !q.isEmpty() && q.peek() < t - 3000 ){
            q.poll();
        }
        return q.size();
    }
}
public class NumberOfRecentCalls {
    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println( r.ping(1) );
        System.out.println( r.ping(100) );
        System.out.println( r.ping(3001 ) );
        System.out.println( r.ping(3002) );


    }
}
