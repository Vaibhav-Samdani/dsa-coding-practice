class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()){
            return "";
        }
        
        int[] mp = new int[256];



        for (char ch : t.toCharArray()) {
            mp[ch]++;
        }

        int i = 0;
        int count = 0, minI = 0, minJ = Integer.MAX_VALUE;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            mp[ch]--;
            if(mp[ch] >= 0 ){
                count++;
            }

            while(count == t.length()){
                char ch2 = s.charAt(i);
                
                if((minJ - minI) >= (j-i) ){
                    minJ = j;
                    minI = i;
                }
                
                mp[ch2]++;
                if(mp[ch2] > 0){
                    count--;
                }

                i++;
                
            }
        }

        if(minJ == Integer.MAX_VALUE) return "";

        return s.substring(minI, minJ+1);

    }
}