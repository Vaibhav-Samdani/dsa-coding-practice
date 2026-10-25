class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int i = 0; i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(word1,word2,0,0);
    }

    int solve(String w1, String w2, int i, int j){

        if(i >= w1.length()) return w2.length() - j;
        if(j >= w2.length()) return w1.length() - i;

        if(dp[i][j] != -1) return dp[i][j];


        if(w1.charAt(i) == w2.charAt(j)){
            return dp[i][j] = solve(w1,w2,i+1,j+1);
        }else{
            return dp[i][j] = 1 + Math.min(solve(w1,w2,i,j+1),Math.min(solve(w1,w2,i+1,j+1),solve(w1,w2,i+1,j)));
        }
    }
}