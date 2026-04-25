class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans[] = new int[2];

        for(int i= 0; i < nums.length; i++) {
            int diffToTarget = target - nums[i];
            if( hm.containsKey(diffToTarget) ) {
                ans[0] = hm.get(diffToTarget);
                ans[1] = i;
                return ans;
            }

            hm.put(nums[i], i);
        }
        return ans;
    }
}
