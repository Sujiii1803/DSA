package Queue.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public Deque<Integer> maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();

        for( int i = 0; i < nums.length; i++ ){
            int max = 0;
            for( int j = 0; j < k; j++ ){
                max = Math.max( max, nums[i] );
            }
            q.addLast(max);
        }
        return q;
    }
}
public class SlidingWindowMax {
   public static void main(String[] args) {
       Solution s = new Solution();
       int[] nums = {1,3,-1,-3,5,3,6,7};
       System.out.println(s.maxSlidingWindow(nums, 3));
   }
}
