class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.length() == 0) return 0;
         HashSet<Character> st = new HashSet<>();
        int i = 0;
        // int len = 0;
        int ans = 0;
        for(int j = 0; j<s.length();j++){
            
            while(i<j && st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
                // len--;
            }
            
            st.add(s.charAt(j));
            ans = Math.max(ans,j-i+1);
            
        }
        
        return ans;
    }
}