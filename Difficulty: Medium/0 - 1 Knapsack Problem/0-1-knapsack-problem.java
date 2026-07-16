class Solution {
	
	public int knapsack(int W, int val[], int wt[]) {
		// code here
		int[][] dp = new int[val.length][W+1];
		
		for(int i = 0; i<val.length;i++){
		    Arrays.fill(dp[i],-1);
		}
		
		return helper(dp,W, val, wt, 0);
	}
	
	int helper(int[][] dp,int W, int val[], int wt[], int i) {
		if (i >= val.length || W == 0)
			return 0;
		
		if(dp[i][W] != -1) return dp[i][W];
		
		int take = 0;
		if (wt[i] <= W)
			take = val[i] + helper(dp,W - wt[i], val, wt, i + 1);
		
		int skip = helper(dp,W, val, wt, i + 1);
		
		return dp[i][W] = Math.max(take, skip);
	}
}
