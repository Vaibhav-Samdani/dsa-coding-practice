class Solution {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int minI = 0, minJ = Integer.MAX_VALUE;
        int count = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch) >= 0){
                    count++;
                }
            }

            while(count == t.length()){
                if((minJ - minI) > (j-i)){
                    minI = i;
                    minJ = j;
                }

                if(mp.containsKey(s.charAt(i))){
                    mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
                    if(mp.get(s.charAt(i)) > 0){
                        count--;
                    }
                }

                i++;
            }
        }

        if(minJ == Integer.MAX_VALUE) return "";

        return s.substring(minI,minJ+1);
    }
}
