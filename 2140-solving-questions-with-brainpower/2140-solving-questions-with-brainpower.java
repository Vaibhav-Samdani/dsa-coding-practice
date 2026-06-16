class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];

        Arrays.fill(dp,-1);

        return hl(dp,questions,0);
    }

    long hl(long[] dp, int[][] questions, int i){

        if(i>=questions.length) return 0;

        if(dp[i] != -1) return dp[i];

        long notSolv = hl(dp,questions, i+1);

        long solv = questions[i][0] + hl(dp, questions,i+questions[i][1]+1);

        return dp[i] = Math.max(solv,notSolv);



    }
}