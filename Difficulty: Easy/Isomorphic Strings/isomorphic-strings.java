class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        
        int[] mp1 = new int[256];
        int[] mp2 = new int[256];
        
        for(int i = 0; i<s1.length() ; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            
            if(mp1[ch1] != mp2[ch2]){
                return false;
            }
            
            mp1[ch1] = i+1;
            mp2[ch2] = i+1;
        }
        
        return true;
    }
}