class Solution {
	int count;
	static int lis(int arr[]) {
		
		int[][] dp = new int[arr.length][arr.length+1];
		
		for(int i = 0; i<arr.length;i++){
		    Arrays.fill(dp[i],-1);
		}
		
		return helper(dp, arr, 0, -1);
		
	}
	
	static int helper(int dp[][], int arr[], int i, int prev) {
		if (i == arr.length)
			return 0;
		
		if( dp[i][prev +1] != -1) return dp[i][prev +1];
		
		int skip = helper(dp, arr, i + 1, prev);
		
		int take = Integer.MIN_VALUE;
		
		if (prev == -1 || arr[prev] < arr[i]) {
			
			take = 1 + helper(dp, arr, i + 1, i);
		}
		
		return dp[i][prev + 1] = Math.max(skip, take);
	}
}
