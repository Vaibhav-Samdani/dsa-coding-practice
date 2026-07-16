class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,s1,s2,0,0);
    }

    int helper(int[][] dp, String s1, String s2, int i, int j){
        if(i == s1.length() || j == s2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + helper(dp,s1,s2,i+1,j+1);
        else{
            int skip1 = helper(dp,s1,s2,i+1,j);
            int skip2 = helper(dp, s1,s2,i,j+1);

            return dp[i][j] = Math.max(skip1,skip2);
        }
    }
}