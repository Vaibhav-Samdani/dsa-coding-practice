class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][][] dp = new int[strs.length][m+1][n+1];

        for(int i = 0; i < strs.length;i++){
            for(int j = 0; j <= m; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return helper(dp ,strs,0,m,n);
    }


    int helper(int[][][] dp ,String[] strs, int i, int m , int n){
        if(i == strs.length) return 0;

        if(dp[i][m][n] != -1){
            return dp[i][m][n];
        }

        int skip = helper(dp ,strs, i +1, m,n);

        int c0 = count(strs[i],'0');

        int c1 = strs[i].length() - c0;

        int pick = c0 <= m && c1 <= n ? 1 + helper(dp ,strs, i +1, m-c0,n - c1) : 0;

        return dp[i][m][n] = Math.max(pick,skip);

    }

    int count(String str,char ch){
        int c = 0;
        for(char val : str.toCharArray()){
            if(val == ch){
                c++;
            }
        }
        return c;
    }
}