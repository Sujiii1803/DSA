package LeetCode.Arrays;
public class MovingZeros
{
    public void moveZeroes(int[] nums)
    {
        int n = nums.length;
        int i=0;
        for(int j=0;j<n;j++)
        {
            if( nums[j] != 0 )
            {
                if(i != j)
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
        }
    }
}
