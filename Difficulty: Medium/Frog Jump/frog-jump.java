class Solution {
    int minCost(int[] height) {
        int n = height.length;
        
        int[] dp = new int[n];
        
        Arrays.fill(dp,-1);
        
        int min = Integer.MAX_VALUE;
        
        // for(int i = 0; i<n;i++){
            min = Math.min(helper(height,dp,n-1), min);
        // }
        
        return min;
    }
    
    int helper(int[] height, int[] dp, int i){
        
        if(i == 0) return 0;
        
        if(dp[i] != -1) {
           return dp[i];
        }
        
        
        int oneJump = helper(height, dp, i-1) + Math.abs(height[i] - height[i-1]);
        int twoJump = Integer.MAX_VALUE ;
        
        if(i > 1){
            twoJump = Math.min(twoJump, helper(height, dp, i-2) + Math.abs(height[i] - height[i-2]));
        }
        
        
        dp[i] = Math.min(oneJump ,twoJump);
        
        return dp[i];
    }
}