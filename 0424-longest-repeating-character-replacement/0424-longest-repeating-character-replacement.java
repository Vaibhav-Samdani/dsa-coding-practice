class Solution {

    public int characterReplacement(String s, int k) {
        int i = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        int ans = 0;
        int maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq,mp.getOrDefault(ch,0));
            
            while (i < j && (j - i + 1 - maxFreq > k)) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                i++;
            }

            ans = Math.max(j - i + 1, ans);
        }

        return ans;
    }
}
