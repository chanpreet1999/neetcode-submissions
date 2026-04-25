class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int ans[] = new int[nums.length];
        int zeroCount = 0;    
        for(int num : nums) {
            if(num != 0)
                product *= num;
            else
                zeroCount++;
        }

        if(zeroCount > 1)
            return ans;

        for(int i = 0; i < nums.length; i++) {
            if(zeroCount == 1) {
                if(nums[i] == 0)
                    ans[i] = (int)product;
                else
                    ans[i] = 0;
            }
                
            else               
                ans[i] = (int)(product/nums[i]);
        }

        return ans;

    }
}  
