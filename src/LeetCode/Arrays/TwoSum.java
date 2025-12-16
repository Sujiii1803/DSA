package LeetCode.Arrays;
import java.util.*;
public class TwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
                /* Brute force solution--O(n^2);
                int x=0,y=0;
                for(int i=0;i<nums.length;i++)
                {
                    for(int j=i+1;j<nums.length;j++)
                    {
                       if( nums[i]+nums[j] == target)
                       {
                           x=i;
                           y=j;
                        }
                    }
                }
                return new int[] {x,y};*/

        // Optimal solution using HashMap--O(n);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int y=target-nums[i];
            if(map.containsKey(y))
            {
                return new int[]{map.get(y),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }
}
