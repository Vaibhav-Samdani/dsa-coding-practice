class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() <= 1) return s;
        
        int[] mp = new int[26];

        for(int i = 0; i < s.length();i++ ){
            mp[s.charAt(i)-'a']++;
        }

        char middle = 0;

        StringBuilder st = new StringBuilder();

        for(int i = 0; i<26;i++){
            int val = mp[i];
            int half = val/2;
            for(int j = 0; j < half;j++){
                st.append((char)('a' + i));
            }
            if (mp[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        int halfLength = st.length();

        if (middle != 0) {
            st.append(middle);
        }

        for(int i = halfLength-1; i>=0;i--){
            st.append(st.charAt(i));
        }

        return st.toString();
    }
}