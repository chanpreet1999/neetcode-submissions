class Solution {
    List<List<Integer>> ans = new ArrayList<>();
        
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curAns = new ArrayList<>();
        helper(nums, target, 0, curAns, 0);
        return ans;
    }

    void helper( int nums[], int target, int curSum, List<Integer> curAns, int idx ) {
        if( curSum == target) {
            ans.add( new ArrayList<>(curAns) );
        }

        for(int i = idx; i < nums.length; i++){
            if( curSum + nums[i] <= target ) {
                curAns.add( nums[i] );
                helper( nums, target, curSum + nums[i], curAns, i );
                curAns.remove( curAns.size()-1 );
            }
        } 
    }
}
