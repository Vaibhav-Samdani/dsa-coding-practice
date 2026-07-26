class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        HashSet<Character> st = new HashSet<>();
        int ans = 0;
        for(int j = 0; j < s.length(); j++){
            while(i < j && st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }

            st.add(s.charAt(j));
            ans = Math.max(ans,st.size());
        }

        return ans;
    }
}