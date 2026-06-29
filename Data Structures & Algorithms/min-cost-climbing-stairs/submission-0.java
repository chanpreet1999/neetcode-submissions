class Solution {
    public int minCostClimbingStairs(int[] cost) {
         

        return Math.min(helper( cost, new Integer[cost.length+1], 0 ), helper( cost, new Integer[cost.length+1], 1 ));
    }

    int helper( int cost[], Integer[] dp, int curIdx ) {
        if(curIdx == cost.length)
            return  dp[curIdx] = 0;

        if( dp[curIdx] != null )
            return dp[curIdx];
        
        int ans = 0;
        if(curIdx +1 <= cost.length)
            ans = cost[curIdx] + helper(cost, dp, curIdx+1);
        
        if( curIdx+2 <= cost.length )
            ans =  Math.min(ans, cost[curIdx] +  helper(cost, dp, curIdx+2));

        return dp[curIdx] = ans;

    }
}
