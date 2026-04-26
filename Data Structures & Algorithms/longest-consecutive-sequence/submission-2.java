class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int ans = 0;
        
        for(int num: nums)
            hs.add( num );


        for(int num : hs) {
            if( !hs.contains( num - 1 ) ) {
                int length = 1;
                
            while(  hs.contains(num + length) ) {
                length++;
            }
            ans = Math.max(length, ans);
            
            } 
        }
        return ans;
    }
}
