class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] mp = new int[26];

        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);

            mp[ch-'a']++;
        } 
        for(int i = 0; i < t.length();i++){
            char ch = t.charAt(i);

            mp[ch-'a']--;
        } 

        for(int i = 0; i<26;i++){
            if(mp[i] > 0) return false;
        }

        return true;

    }
}