package Queue.Leetcode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Cards{
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new ArrayDeque<>();
        for( int i = 0; i < deck.length; i++ ){
            q.offer(i);
        }

        int[] ans = new int[deck.length];

        for( int card : deck ){
            int pos = q.poll();
            ans[pos] = card;

            if(!q.isEmpty()){
                q.offer(q.poll());
            }
        }
        return ans;
    }
}
public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        Cards c = new Cards();
        System.out.println(
                Arrays.toString(c.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5}))
        );
    }
}
