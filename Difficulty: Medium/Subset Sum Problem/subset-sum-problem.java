class Solution {
	static int[][] dp;
	// 1 True, 0 False, -1 no visited
	static boolean isSubsetSum(int arr[], int sum) {
		dp = new int[arr.length][sum + 1];
		for (int i = 0; i < arr.length ; i++) {
			Arrays.fill(dp[i], -1);
		}
		return solve(arr, 0, sum);
		
	}
	
	static boolean solve(int[] arr, int i, int sum) {
		if (sum < 0)
			return false;
		if (sum == 0)
			return true;
		
		if (arr.length == i)
			return false;
		
		if (dp[i][sum] != -1)
			return dp[i][sum] == 1;
		
		boolean take = solve(arr, i + 1, sum - arr[i]);
		boolean skip = solve(arr, i + 1, sum);
		
		dp[i][sum] = take || skip ? 1 : 0;
		
		return take || skip;
	}
}
