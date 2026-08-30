package Arrays;

public class NRepeatedElementinSize2NArray {

    public int repeatedNTimes(int[] nums) {
        /*
        O(N)--> Time and Space complexity
        int n=nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){

            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        for(int num : nums)
        {
            int m = freq.get(num);

            if(m*2 == n)
            {
                return num;
            }
        }
        return -1;
        */
        /*(Faster then hash Map)
        HashSet<Integer>seen=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!seen.add(nums[i])) {
                return nums[i];
            }
            seen.add(nums[i]);
        }
        return -1;
        */

        //O(1)-->Space complexity
        for(int i=0 ; i<nums.length-2 ; i++){
            if(nums[i] == nums[i+1] || nums[i] == nums[i+2]){
                return nums[i];
            }
        }
        return nums[nums.length-1];

    }
}
