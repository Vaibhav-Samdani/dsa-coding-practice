class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        // Arrays.fill(dp,-1);

        if(nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];


        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        for(int i = 2; i < dp.length;i++){
            int last = dp[i-1];
            int curr = nums[i] + dp[i-2];

            dp[i] = Math.max(last,curr);
        }
        
        return dp[nums.length-1];
    }

    
}