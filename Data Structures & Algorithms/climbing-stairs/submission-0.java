class Solution {
    public int climbStairs(int n) {
        Integer dp[]  = new Integer[n+1];
        return helper(n, dp);
    }

    int helper( int n, Integer dp[] ) {
        if( n == 0 )
            return dp[n] = 1;
        
        if( dp[n] != null )
            return dp[n];

        int count = 0;
        
        if(n-1 >= 0 )
            count = helper(n-1, dp);
        
        if(n-2 >= 0 )
            count += helper(n-2, dp); 

        return dp[n] = count;
    }
}
