package Queue.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class Subarray {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int left = 0;
        int ans = 0;
        for( int right = 0; right < nums.length; right++ ){
            while( !max.isEmpty() && nums[max.peekLast()] < nums[right] ){
                max.pollLast();
            }
            max.offerLast(right);

            while( !min.isEmpty() && nums[min.peekLast()] > nums[right] ){
                min.pollLast();
            }
            min.offerLast(right);

            while( ( nums[ max.peekFirst()] - nums[ min.peekFirst()] ) > limit ){
                left++;
                if( !max.isEmpty() && max.peekFirst() < left ){
                    max.pollFirst();
                }

                if( !min.isEmpty() && min.peekFirst() < left ){
                    min.pollFirst();
                }
            }
            ans = Math.max( ans, right - left + 1);
        }
        return ans;
    }
}
public class LCSADL {
    //LCSADL -> LongestContinousSubarrayWithAbsoluteDiffferenceLessThanOrEqualToLimit
    public static void main(String[] args) {
        Subarray obj = new Subarray();
        System.out.println(obj.longestSubarray(new int[]{8,2,4,7}, 4));
    }
}
