class Solution {
    int[] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new int[n + 1];

        Arrays.fill(dp,1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]); 
                }
            }
        }

        int ans = dp[0];

        for(int i = 0;i<n;i++){
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }

    
}