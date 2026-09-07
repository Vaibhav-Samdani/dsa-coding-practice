class Solution {
    public String longestCommonPrefix(String[] strs) {
        // if(strs.length == 1) return strs[0]; 
        String ans = strs[0];


        for(int i = 0; i<strs.length; i++){
            while(!strs[i].startsWith(ans)){
                ans = ans.substring(0,ans.length()-1);
            }
        }

        return ans;
    }
}