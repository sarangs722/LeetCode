class Solution {
    private int[] dp;
    
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return comb(nums, target);
    }
    
    private int comb(int[] nums, int target) {
        if (dp[target] != -1)
            return dp[target];
        
        if (target == 0)
            return 1;
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += comb(nums, target - nums[i]);
        }
        return dp[target] = res;
    }
}