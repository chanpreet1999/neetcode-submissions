class Solution {
    int MAX = (int)1e9;

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;

        int ans =  helper( coins, amount, new Integer[amount+1], 0 );
        return ans == MAX ? -1 : ans;
    }

    int helper(int[] coins, int amt, Integer[] dp, int idx) {
        if( amt == 0 )
            return 0;
        if( idx == coins.length )
            return -1;

        if(dp[amt] != null)
            return dp[amt];
        
        int ans = MAX;
        
        for(int i = idx; i < coins.length; i++) {
            if( amt - coins[i] >= 0 )
                ans = Math.min(1 + helper(coins, amt - coins[i], dp, 0), ans);
        }   
        
        return dp[amt] = ans;
        
    }
}
