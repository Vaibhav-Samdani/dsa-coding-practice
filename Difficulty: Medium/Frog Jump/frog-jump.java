class Solution {
    int minCost(int[] height) {
        int n = height.length;
        
        if(n == 1) return 0;
        
        // if(n == 2)
        
        int[] dp = new int[n];
        
        Arrays.fill(dp,0);
        
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);
        
        for(int i = 2; i<n;i++){
            int j1 = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int j2 = dp[i-2] + Math.abs(height[i] - height[i-2]);
            
            dp[i] = Math.min(j1,j2);
        }
        
        return dp[n-1];
    }
    
    
}