class Solution {
	int[][] dp;
	
	public int maxSumIS(int arr[]) {
		dp = new int[arr.length][arr.length+1];
		for (int i = 0; i<dp.length; i++) {
			Arrays.fill(dp[i],-1);
		}
		return solve(arr, 0, -1);
	}
	
	int solve(int[] arr, int i, int prev) {
		if (arr.length == i)
			return 0;
		
		if (dp[i][prev+1] != -1)
			return dp[i][prev+1];
		
		int skip = solve(arr, i + 1, prev);
		
		int take = 0;
		
		if (prev == -1 || arr[i] > arr[prev]) {
			take = arr[i] + solve(arr, i + 1, i);
		}
		
		return dp[i][prev+1] = Math.max(take, skip);
	}
}
