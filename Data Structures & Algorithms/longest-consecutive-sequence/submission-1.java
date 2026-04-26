class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
            
        Arrays.sort(nums);
        int curAns = 1;
        int maxAns = 1;

        for(int i = 1; i < nums.length; i++) {
            if( nums[i] -1 == nums[i-1] )
                curAns++;
            else if( nums[i] == nums[i-1] )
                curAns = curAns;
            else
                curAns = 1;
            maxAns = curAns > maxAns ? curAns : maxAns;            
        }
        return maxAns;
    }
}
