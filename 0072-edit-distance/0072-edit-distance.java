class Solution {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[n][j] = m - j;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][m] = n - i;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int delVal = 1 + dp[i + 1][j];

                // 2. Insert
                int inVal = 1 + dp[i][j + 1];

                // 3. Replace
                int reVal = 0;

                if (word1.charAt(i) == word2.charAt(j)) {
                    reVal = dp[i + 1][j + 1];
                } else {
                    reVal = 1 + dp[i + 1][j + 1];
                }

                dp[i][j] = Math.min(delVal, Math.min(inVal, reVal));
            }
        }

        return dp[0][0];
    }
}
