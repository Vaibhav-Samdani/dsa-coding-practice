class Solution {
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new boolean[n + 1];

        dp[n] = true;
        if (wordDict.contains(s)) {
            return true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = i + 1; k <= n; k++) {
                String temp = s.substring(i,k);
                if(wordDict.contains(temp) && dp[k]){
                    dp[i] = true;
                }
            }
        }

        return dp[0];
    }

}
