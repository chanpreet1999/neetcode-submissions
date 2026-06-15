class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curAns = new ArrayList<>();
        helper(nums, 0, ans, curAns);
        return ans;
    }


    void helper( int nums[], int idx, List<List<Integer>> ans, List<Integer> curAns ) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(curAns));
            return;
        }

        curAns.add(nums[idx]);
        helper(nums,idx + 1, ans, curAns);
        curAns.remove(curAns.size()-1);
        
        helper(nums,idx + 1, ans, curAns);
        

    }

}
