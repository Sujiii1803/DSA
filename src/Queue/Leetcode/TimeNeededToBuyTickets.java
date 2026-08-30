package Queue.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class tickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        for( int i = 0; i < tickets.length; i++ ){
            q.offer(i);
        }
        int time = 0;
        while( !q.isEmpty() ){
            int person = q.poll();
            tickets[person]--;
            time++;

            if( person == k && tickets[person] == 0 ){
                break;
            }

            if( tickets[person] > 0 ){
                q.offer( person );
            }
        }
        return time;
    }
}
public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        tickets t1 = new tickets();
        System.out.print(t1.timeRequiredToBuy(new int[]{1,2,3,4,5}, 6));
    }
}
