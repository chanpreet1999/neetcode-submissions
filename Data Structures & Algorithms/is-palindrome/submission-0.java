class Solution {
    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int s = 0, e = str.length()-1;
        while( s < e ){
            if( shouldSkip(str.charAt(s)) )
                s++;
            else if( shouldSkip(str.charAt(e)) )
                e--;
            else if( str.charAt(s) != str.charAt(e) )
                return false;
            else {
                s++;
                e--;
            }
        }
        return true;
    }

    boolean shouldSkip( char ch ) {
        return !Character.isLetterOrDigit(ch);
    }
}
