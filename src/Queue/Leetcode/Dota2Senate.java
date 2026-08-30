package Queue.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class predictPartyVictory{
    public String findVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();
        for( int i = 0; i < senate.length(); i++ ){
            if( senate.charAt(i) == 'R' ){
                radiant.offer(i);
            }else{
                dire.offer(i);
            }
        }
        while( !radiant.isEmpty() && !dire.isEmpty() ){
            int r = radiant.poll();
            int d = dire.poll();

            if( r < d ){
                r = r + senate.length();
                radiant.offer( r );
            }else{
                d = d + senate.length();
                dire.offer( d );
            }
        }
        if( radiant.isEmpty() ) return "Dire";
        return "Radiant";
    }
}
public class Dota2Senate {
    public static void main(String[] args) {
           predictPartyVictory p = new predictPartyVictory();
           System.out.println( p.findVictory("RDD"));
    }
}