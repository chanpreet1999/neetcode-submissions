class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curAns = new ArrayList<>();
        
        helper( nums, ans, curAns, new HashSet<Integer>() );
        
        return ans;        
    }

    void helper( int[] nums, List<List<Integer>> ans, List<Integer> curAns, Set<Integer> hs ) {
        
        if( nums.length == curAns.size() ) {
            List<Integer> smallAns = new ArrayList<>(curAns);
            ans.add( smallAns );
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            
            if( !hs.contains( nums[i] ) ) {
    
                hs.add(nums[i]);
                curAns.add( nums[i] );

                helper(nums, ans, curAns, hs);
                
                curAns.remove( curAns.size()-1 );
                hs.remove(nums[i]);

            }
        }
    }
}
