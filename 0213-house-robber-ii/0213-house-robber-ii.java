class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);

        int[] dp = new int[n];

        Arrays.fill(dp,0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int ans2 = helper(n-1,dp,nums);

        Arrays.fill(dp,0);

        dp[0] = 0;
        dp[1] =  nums[1];

        int ans1 = helper(n,dp,nums);

        return Math.max(ans1,ans2);
    }

    int helper(int n, int[] dp, int[] nums){

        for (int i = 2; i < n ; i++) {
                dp[i] = Math.max(nums[i] + dp[i-2], dp[i - 1]);
        }

        return dp[n-1];
    }
}