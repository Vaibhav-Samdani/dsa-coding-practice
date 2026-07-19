class Solution {
    int[] dp;

    public int minCut(String s) {
        int n = s.length();
        dp = new int[n + 1];

        boolean[][] isPal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || isPal[i + 1][j - 1]) {
                        isPal[i][j] = true;
                    }
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            for (int k = i; k < n; k++) {
                
                if (isPal[i][k]) {
                    int val = 1 + dp[k + 1];
                    ans = Math.min(ans, val);
                    dp[i] = ans;
                }
            }
        }

        return dp[0] - 1;
    }

    boolean check(String s) {
        if (s.length() == 1) return true;

        for (int i = 0; i < s.length() / 2; i++) {
            char A = s.charAt(i);
            char B = s.charAt(s.length() - i - 1);
            if (A != B) return false;
        }

        return true;
    }
}
