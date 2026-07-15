class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(dp, nums,0);
    }

    int helper(int[] dp, int[] nums, int i){
        if(i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        int steal = nums[i] + helper(dp,nums,i+2);
        int skip = helper(dp, nums,i+1);

        return dp[i] = Math.max(steal,skip);
    }
}