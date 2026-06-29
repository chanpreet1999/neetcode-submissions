class Solution {
    public int rob(int[] nums) {
        return helper( nums, new Integer[nums.length], 0 );
    }
    int helper( int nums[], Integer[] dp, int curIdx ) {
        if(curIdx >= nums.length)
            return 0;

        if( dp[curIdx] != null )
            return dp[curIdx];

        return dp[curIdx] = Math.max(  nums[curIdx] + helper(nums, dp, curIdx + 2),
        helper( nums, dp, curIdx + 1 ) );
    }
}
