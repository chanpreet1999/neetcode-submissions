class Solution {
    String ans = "";
    int maxLen = -(int)1e9;

    public String longestPalindrome(String s) {
    
        int n = s.length();

        if(n == 1)
            return s;

        helper( s, 0, n-1, new Boolean[n][n] );
        return ans;
    }

    boolean helper( String s, int i, int j, Boolean[][] dp ) {
        if( i == j ) {
            if( j-i+1 > maxLen ) {
                maxLen = j-i+1;
                ans = s.charAt(j) + "";
            }
            
            return dp[i][j] = true;
            
        }
            
        if(i > j)
            return true;
        
        if( dp[i][j] != null )
            return dp[i][j];

        boolean res = false;

        helper( s, i+1, j, dp );
        helper( s, i, j-1, dp );

        if( s.charAt(i) == s.charAt(j)  ) {
            res  = helper( s, i+1, j-1, dp );
            if(res && j - i + 1 > maxLen) {
            maxLen = j-i+1;
            ans = s.substring(i, j+1);
        }
    }   

        

        return dp[i][j] = res;
    }
}
