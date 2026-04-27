class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while( start < end ) {
            int curSum = nums[start] + nums[end];
            if( curSum == target ) 
                return new int[]{start+1, end+1};
            else if( curSum < target )
                start ++;
            else 
                end--;
        }

        return new int[]{-1, -1};
    }
}
