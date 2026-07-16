class Solution {
	static int lcs(String s1, String s2) {
		int[][] dp = new int[s1.length()][s2.length()];
		
		for (int i = 0; i<s1.length(); i++) {
			Arrays.fill(dp[i], -1);
		}
		return helper(dp, s1, s2, 0, 0);
	}
	
	static int helper(int[][] dp, String s1, String s2, int i, int j) {
		if (i == s1.length() || j == s2.length())
			return 0;
		if(dp[i][j] != -1) return dp[i][j];
		if (s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = 1 + helper(dp, s1, s2, i + 1, j + 1);
		} else {
			int s = helper(dp, s1, s2, i + 1, j);
			int t = helper(dp, s1, s2, i, j + 1);
			return dp[i][j] = Math.max(s, t);
		}
	}
}
