class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int curr = 0;
        int ans = 0;

        for(int j = 0; j < s.length();j++){
            
            if(isVowel(s.charAt(j))) curr++;


            while(j-i + 1 > k){
                if(isVowel(s.charAt(i))) curr--;
                i++;
            }

            if(j-i+1 == k){
                ans = Math.max(ans,curr);
            }
        }

        return ans;
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u';
    }
}