class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];

        return solve(0,s, wordDict);
    }

    boolean solve(int i, String s, List<String> dict){
        if(s.length() == i) return true;

        if(dict.contains(s)){
            return true;
        }

        if(dp[i] != null) return dp[i];

        for(int k = i + 1; k <= s.length(); k++){

            String temp = s.substring(i,k);

            if(dict.contains(temp) && solve(k,s,dict)){
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
}